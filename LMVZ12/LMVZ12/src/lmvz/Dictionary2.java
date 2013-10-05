package lmvz;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.*;
import javax.swing.event.ListSelectionListener;

/**
 * Created with IntelliJ IDEA.
 * User: denis
 * Date: 10/4/13
 * Time: 8:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Dictionary2 extends JFrame {
    String [] array = {"Великобритания" , "Германия" , "Италия" , "Нидерланды" , "Польша" ,  "Украина" , "Франция"  , "Чехия" };
    JList<String> list = new JList (array);

    JLabel label1 = new JLabel();
    JPanel panel = new JPanel();
    JTextPane textPane = new JTextPane();
    JLabel label2 = new JLabel();
    ImagePanel image = new ImagePanel();
    JLabel label3 = new JLabel();
    JTextArea textArea = new JTextArea();
    public Dictionary2(){
        super("Cловарь");
        initComponents();
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
                if(list.getSelectedValue() == "Великобритания")
                {
                    label3.setText("Лондон");
                }
                else  if(list.getSelectedValue() == "Германия" )
                {
                    label3.setText("Берлин");
                }
                else  if(list.getSelectedValue() == "Италия" )
                {
                    label3.setText("Рим");
                }
                else  if(list.getSelectedValue() == "Нидерланды" )
                {
                    label3.setText("Амстердам");
                }
                else  if(list.getSelectedValue() == "Польша" )
                {
                    label3.setText("Варшава");
                }
                else  if(list.getSelectedValue() == "Украина" )
                {
                    label3.setText("Киев");
                }
                else  if(list.getSelectedValue() == "Франция" )
                {
                    label3.setText("Париж");
                }
                else  if(list.getSelectedValue() == "Чехия" )
                {
                    label3.setText("Прага");
                }
            }
        }) ;


      }


    private void initComponents(){
        setLayout(null);
        JMenu jMenuFile ;
        JMenu jMenuEdit;
        JMenuBar jMenuBar;


        //JList<Country> list = new JList();
     // String [] array = {"Германия" , "Нидерланды" , "Польша" , "Украина" , "Чехия" };
       // JList<String> list = new JList (array);

        jMenuBar = new JMenuBar();
        jMenuFile = new JMenu();
        jMenuEdit = new JMenu();

        panel.setBackground(new Color(255, 244, 243));
        panel.setSize(new Dimension(570, 480));
        panel.setLocation(10, 10);
        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE));
        panel.setLayout(null);
        textPane.setLocation(40, 65);
        textPane.setSize(100, 20);
        textPane.setBorder(BorderFactory.createLineBorder(Color.black)) ;
        label1.setSize(150, 15);
        label1.setLocation(45, 30);
        label1.setText("Поиск :");
        label2.setSize(150, 15);
        label2.setLocation(40, 110);
        label2.setText("Выберите страну:");
        list.setLayoutOrientation(JList.VERTICAL);
        list.setBackground(new Color(255, 206, 17));
        list.setSize(new Dimension(110, 250));
        list.setLocation(40, 150);
        list.setBorder(BorderFactory.createLineBorder(Color.black)) ;
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        label3.setSize(220, 50);
        label3.setBorder(BorderFactory.createLineBorder(Color.black)) ;
        label3.setLocation(250, 30);
        label3.setText("Здесь может быть ваш текст");
        image.setSize(300,150);
        image.setLocation(220,85);
        image.setBackground(Color.black);
        textArea.setLocation(220 , 240);
        textArea.setSize(305,165);
        textArea.setBackground(Color.green);


        add(panel);
        panel.add(label1);
        panel.add(list);
        panel.add(textPane);
        panel.add(label2);
        panel.add(label3);
        panel.add(image);
        panel.add(textArea);
        jMenuFile.setText("Файл");
        jMenuBar.add(jMenuFile);


        jMenuEdit.setText("Редактировать");
        jMenuBar.add(jMenuEdit);

        setJMenuBar(jMenuBar);

        pack();

        setResizable(false);
        this.setPreferredSize(new Dimension(600, 500));
        pack();

        this.setVisible(true);


    }


}
