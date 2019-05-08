package javaStudy.java.网络编程.读取URL中的资源;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author ZhaoWH
 */
public class NetWin extends JFrame implements ActionListener, Runnable {
    private JTextField textField;
    private JTextArea textArea;
    private byte[] bytes = new byte[118];
    private Thread thread;

    NetWin() {
        initComponents();
        textField = new JTextField(20);
        textArea = new JTextArea(12, 12);
        JButton button = new JButton("确定");
        button.addActionListener(this);
        thread = new Thread(this);
        JPanel panel = new JPanel();
        panel.add(new JLabel("输入网址:"));
        panel.add(textField);
        panel.add(button);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(panel, BorderLayout.NORTH);
        setBounds(60, 60, 360, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(thread.isAlive())) {
            thread = new Thread(this);
        }
        try {
            thread.start();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            int n = -1;
            textArea.setText(null);
            URL url = new URL(textField.getText().trim());
            InputStream inputStream = url.openStream();
            while ((n = inputStream.read(bytes)) != -1) {
                String s = new String(bytes, 0, n);
                textArea.append(s);
            }
        } catch (IOException e) {
            textArea.setText("" + e);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        frame1 = new JFrame();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        comboBox1 = new JComboBox();
        button1 = new JButton();
        toolBar1 = new JToolBar();
        passwordField1 = new JPasswordField();

        //======== frame1 ========
        {
            Container frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[135,fill]" +
                "[174,fill]" +
                "[180,fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]"));

            //---- checkBox1 ----
            checkBox1.setText("text");
            frame1ContentPane.add(checkBox1, "cell 1 0");

            //---- checkBox2 ----
            checkBox2.setText("text");
            frame1ContentPane.add(checkBox2, "cell 2 0");
            frame1ContentPane.add(comboBox1, "cell 2 1");

            //---- button1 ----
            button1.setText("text");
            frame1ContentPane.add(button1, "cell 1 2");
            frame1ContentPane.add(toolBar1, "cell 2 2");
            frame1ContentPane.add(passwordField1, "cell 3 2");
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame frame1;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JComboBox comboBox1;
    private JButton button1;
    private JToolBar toolBar1;
    private JPasswordField passwordField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
