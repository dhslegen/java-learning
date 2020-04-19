/*
 * Created by JFormDesigner on Fri Apr 17 09:50:32 CST 2020
 */

package javaStudy.java.网络编程.显示URL中的HTML文件;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;

/**
 * @author unknown
 */
public class NetWin extends JFrame implements Runnable {
    public NetWin() {
        initComponents();
        thread = new Thread(this);
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (!thread.isAlive()) {
            thread = new Thread(this);
            thread.start();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        textField1 = new JTextField();
        label1 = new JLabel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();

        //======== this ========
        setVisible(true);
        setBackground(Color.white);
        setForeground(SystemColor.controlLtHighlight);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[638,fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[514]" +
            "[]" +
            "[]"));
        contentPane.add(textField1, "cell 9 0 1 3");

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u7f51\u5740");
        contentPane.add(label1, "cell 6 1 3 1");

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, "cell 14 1");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textPane1);
        }
        contentPane.add(scrollPane1, "cell 0 4 25 3,grow");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    @Override
    public void run() {
        textPane1.setText(null);
        try {
            url = new URL(textField1.getText().trim());
            textPane1.setPage(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField textField1;
    private JLabel label1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    Thread thread;
    URL url;
}
