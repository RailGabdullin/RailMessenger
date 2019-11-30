package rail.gabdullin;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Window extends JFrame {

    Window() {
        setBounds(500, 200, 350, 520);
        setTitle("RailMessenger");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel chatLogPane = new JPanel();
        chatLogPane.setLayout(new BorderLayout());

        JTextArea chatLog = new JTextArea();
        chatLog.setEditable(false);
        chatLog.setBackground(new Color(43,43,43));
        chatLog.setForeground(Color.WHITE);

        JScrollPane chatScroll = new JScrollPane(chatLog);
        chatScroll.setBackground(new Color(43,43,43));

        chatLogPane.add(chatScroll, BorderLayout.CENTER);
        add(chatLogPane, BorderLayout.CENTER);

        JPanel sendMessagePane = new JPanel();
        sendMessagePane.setLayout(new FlowLayout());
        sendMessagePane.setBackground(new Color(65, 65,65));

        JTextField messageText = new JTextField();
        messageText.setBackground(new Color(65, 65,65));
        messageText.setForeground(Color.WHITE);
        messageText.setPreferredSize(new Dimension(250, 50));
        sendMessagePane.add(messageText);
        add(sendMessagePane, BorderLayout.SOUTH);
        messageText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    if(messageText.getText().length() > 0) {
                        chatLog.append(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm")) + ": " + messageText.getText() + "\n");
                        messageText.setText(null);
                        messageText.grabFocus();
                    }
                }
                super.keyPressed(e);
            }
        });


        JButton sendButton = new JButton();
        sendButton.setBackground(new Color(65, 65,65));
        ImageIcon sendIcon = new ImageIcon("img/send.png");
        sendButton.setIcon(sendIcon);
        sendButton.setPreferredSize(new Dimension(50, 50));
        sendMessagePane.add(sendButton);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(messageText.getText().length() > 0) {
                    chatLog.append(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm")) + ": " + messageText.getText() + "\n");
                    messageText.setText(null);
                    messageText.grabFocus();
                }
            }
        });


        setVisible(true);
    }
}
