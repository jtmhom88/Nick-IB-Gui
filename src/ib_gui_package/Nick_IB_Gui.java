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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Nick_IB_Gui {

    private JFrame frame;

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
        frame = new JFrame();
        frame.setBounds(100, 100, 583, 494);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblIbApiGui = new JLabel("IB API Gui");
        lblIbApiGui.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblIbApiGui.setBounds(6, 6, 95, 16);
        frame.getContentPane().add(lblIbApiGui);
        
        JLabel lblMessages = new JLabel("Messages");
        lblMessages.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        lblMessages.setBounds(6, 41, 95, 16);
        frame.getContentPane().add(lblMessages);
        
        JTextArea textArea1 = new JTextArea();
        textArea1.setRows(5);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea1.setBounds(6, 69, 533, 96);
        frame.getContentPane().add(textArea1);
        
        JLabel lblConsole = new JLabel("Console");
        lblConsole.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        lblConsole.setBounds(6, 177, 61, 16);
        frame.getContentPane().add(lblConsole);
        
        JTextArea textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setRows(5);
        textArea.setLineWrap(true);
        textArea.setBounds(6, 205, 533, 96);
        frame.getContentPane().add(textArea);
        
        JButton btnConnect = new JButton("Connect");
        btnConnect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnConnect.setBounds(6, 313, 117, 29);
        frame.getContentPane().add(btnConnect);
        
        JButton btnDisconnect = new JButton("Disconnect");
        btnDisconnect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnDisconnect.setBounds(6, 354, 117, 29);
        frame.getContentPane().add(btnDisconnect);
    }
}
