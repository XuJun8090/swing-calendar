package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * swing 练习
 *
 */
public class App {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //private static Point startp = null;
    //private Point endp = null;

    @Getter
    @Setter
    private String date1 = null;
    @Getter
    @Setter
    private String date2 = null;

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    public static void main(String[] args) {

        final JFrame f = new JFrame("日历测试");
        f.setLayout(null);
        f.setBounds(30,50, 400,450);

        JLabel label = new JLabel("起始时间");
        label.setBounds(10, 80, 200, 30);
        //label.setSize(new Dimension(20, 30));
        f.getContentPane().add(label);

        JLabel labe2 = new JLabel("结束时间");
        labe2.setBounds(10, 130, 200, 30);
        //label.setSize(new Dimension(20, 30));
        f.getContentPane().add(labe2);

        final JTextField filed1 = new JTextField();
        final JTextField filed2 = new JTextField();
        filed1.setBounds(100, 80, 200, 30);
        filed2.setBounds(100, 130, 200, 30);

        // 定义日历控件面板类
        CalendarPanel p = new CalendarPanel(filed1, "yyyy/MM/dd");
        p.initCalendarPanel();

        JLabel l = new JLabel("日历面板");
        p.add(l);
        f.getContentPane().add(p);
        f.getContentPane().add(filed1);
        f.getContentPane().add(filed2);
        //  f.setSize(400, 300);
        f.setBackground(Color.WHITE);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        CalendarPanel p2 = new CalendarPanel(filed2, "yyyy/MM/dd");
        p2.initCalendarPanel();
        f.getContentPane().add(p2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labe3 = new JLabel("详细描述");
        labe3.setBounds(10, 180, 80, 30);
        //label.setSize(new Dimension(20, 30));
        f.getContentPane().add(labe3);
        final TextField filed3 = new TextField("输入描述");
        filed3.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
        //  field1.setColumns(10);
        filed3.setBounds(100, 180, 200, 30);
        f.getContentPane().add(filed3);
        Button button = new Button("button");
        button.setBounds(120, 330, 80, 30);
        f.getContentPane().add(button);

        JLabel labe4 = new JLabel("城市选择");
        labe4.setBounds(10, 230, 80, 30);

        //label.setSize(new Dimension(20, 30));
        f.getContentPane().add(labe4);

        final JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setBounds(100, 230, 80, 30);
        comboBox.addItem("上海");
        comboBox.addItem("陕西");
        comboBox.addItem("山西");
        comboBox.addItem("广州");
        comboBox.addItem("云南");
        f.getContentPane().add(comboBox);

        JLabel labe5 = new JLabel("测试");
        labe5.setBounds(10, 280, 80, 30);

        f.getContentPane().add(labe5);
        final TextField filed5 = new TextField("输入描述");
        filed5.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
        //  field1.setColumns(10);
        filed5.setBounds(100, 280, 200, 30);
        f.getContentPane().add(filed5);

        Button button2 = new Button("浏览");
        button2.setBounds(300, 280, 80, 30);
        f.getContentPane().add(button2);



        // 不显示  放到最后
        labe4.setVisible(true);
        f.setVisible(true);


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int option = fileChooser.showOpenDialog(f);
                if(option ==JFileChooser.APPROVE_OPTION){
                    File file =  fileChooser.getSelectedFile();
                    filed5.setText(file.getAbsolutePath());
                    System.out.println("=====================");
                    System.out.println(filed5.getText());
                }
            }
        });

        button.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("run。。。。。。");
                String tex1 =  filed1.getText();
                String tex2 =  filed2.getText();
                System.out.println("tex1。。。。。。" + tex1);
                System.out.println("tex2。。。。。。" + tex2);
                System.out.println("run。。。。。。");

                App chooser = new App();
                chooser.setDate1(tex1);
                chooser.setDate2(tex2);
                Date dates1 = format.parse(chooser.getDate1());
                Date dates2 = format.parse(chooser.getDate2());

                String fils3 = filed3.getText();
                System.out.println("dates1: " + dates1);
                System.out.println("dates2: " + dates2);
                System.out.println("fils3: " + fils3);
                String comm = comboBox.getSelectedItem().toString();
                System.out.println("comm: " + comm);
                long ll = dates2.getTime() - dates1.getTime();
                int h = (int)ll/1000/60/60;
                JOptionPane.showMessageDialog(null, "时间差：" + h + " 小时","这是消息对话框的标题",JOptionPane.INFORMATION_MESSAGE );
                //JOptionPane.showMessageDialog((null, "MessageDialog", "这是消息对话框的标题", JOptionPane.INFORMATION_MESSAGE));
            }
        });
    }
}
