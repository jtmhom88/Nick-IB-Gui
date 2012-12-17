package ib_gui_package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import java.awt.Panel;
import javax.swing.JLabel;

import com.ib.client.EClientSocket;
import com.ib.client.EWrapper;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import javax.swing.ScrollPaneConstants;

public class Nick_IB_Gui {
        
    private JFrame frame;
    private NickWrapper nwrapper;
    private String retIpAddress;
    private int retPort ;
    private int retClientId ;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Nick_IB_Gui window = new Nick_IB_Gui();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Nick_IB_Gui() {
        initialize();
      
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        nwrapper = new NickWrapper();
        
        frame = new JFrame();
        frame.setBounds(100, 100, 583, 494);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        final JLabel lblIbApiGui = new JLabel("IB API Gui");
        lblIbApiGui.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblIbApiGui.setBounds(6, 6, 95, 16);
        frame.getContentPane().add(lblIbApiGui);
        
        final JLabel lblMessages = new JLabel("Messages");
        lblMessages.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        lblMessages.setBounds(6, 41, 95, 16);
        frame.getContentPane().add(lblMessages);
        
        final JTextArea textArea1 = new JTextArea();
        textArea1.setRows(5);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea1.setBounds(6, 69, 533, 96);
        frame.getContentPane().add(textArea1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(6, 205, 533, 96);
        frame.getContentPane().add(scrollPane);
        final JTextArea textArea = new JTextArea();
        textArea.setRows(5);
        scrollPane.setRowHeaderView(textArea);
        
        final JLabel lblConsole = new JLabel("Console");
        lblConsole.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        lblConsole.setBounds(6, 177, 61, 16);
        frame.getContentPane().add(lblConsole);
        
        JButton btnConnect = new JButton("Connect");
        btnConnect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onConnect(textArea);
            }
        });
        btnConnect.setBounds(6, 313, 117, 29);
        frame.getContentPane().add(btnConnect);
        
        JButton btnDisconnect = new JButton("Disconnect");
        btnDisconnect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onDisconnect(textArea);
            }
        });
        btnDisconnect.setBounds(6, 354, 117, 29);
        frame.getContentPane().add(btnDisconnect);
        
        JButton btnReqAcctButton = new JButton("Req Accounts");
        btnReqAcctButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                onReqAcct(textArea);
            }
        });
        btnReqAcctButton.setBounds(126, 313, 117, 29);
        frame.getContentPane().add(btnReqAcctButton);
    
       
    }
    
    private void onConnect(JTextArea mytextArea) {
        //mytextArea.append("\nConnect BUTTON WAS PUSHED");
        retIpAddress = "";
        retPort = 7496;
        retClientId = 0;
        nwrapper.m_client.eConnect( retIpAddress, retPort, retClientId);
        if (nwrapper.m_client.isConnected()) {
            mytextArea.append("Connected to Tws server version " +
                       nwrapper.m_client.serverVersion() + " at " +
                       nwrapper.m_client.TwsConnectionTime());
        }
    }
    
    private void onDisconnect(JTextArea mytextArea) {
        mytextArea.append("\nDisconnect BUTTON WAS PUSHED");
    }
    
    private void onReqAcct(JTextArea mytextArea) {
        String allAccounts="";
        //mytextArea.append("\nConnect BUTTON WAS PUSHED");
        nwrapper.m_client.reqManagedAccts();
        // JTH no need to explicitly call 
        // nwrapper.managedAccounts(allAccounts);
    }
}
