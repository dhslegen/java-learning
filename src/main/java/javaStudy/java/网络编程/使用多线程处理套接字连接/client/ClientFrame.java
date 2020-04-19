/*
 * Created by JFormDesigner on Sun Apr 19 12:18:09 CST 2020
 */

package javaStudy.java.网络编程.使用多线程处理套接字连接.client;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class ClientFrame extends JFrame {
    public ClientFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
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
            "[919,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[485]"));

        //---- label1 ----
        label1.setText("\u8f93\u51652\u6b21\u9879\u7cfb\u6570");
        contentPane.add(label1, "cell 6 0");
        contentPane.add(textField1, "cell 7 0");

        //---- button1 ----
        button1.setText("\u8fde\u63a5\u670d\u52a1\u5668");
        contentPane.add(button1, "cell 3 1");

        //---- label2 ----
        label2.setText("\u8f93\u51651\u6b21\u9879\u7cfb\u6570");
        contentPane.add(label2, "cell 6 1");
        contentPane.add(textField2, "cell 7 1");

        //---- label3 ----
        label3.setText("\u8f93\u5165\u5e38\u6570\u9879");
        contentPane.add(label3, "cell 6 2");
        contentPane.add(textField3, "cell 7 2");

        //---- button2 ----
        button2.setText("\u6c42\u65b9\u7a0b\u7684\u8ddf");
        contentPane.add(button2, "cell 3 3");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1, "cell 6 3 2 1,growy");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
