package lmvz;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: denis
 * Date: 10/5/13
 * Time: 4:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginWin extends JDialog{

    private  PersonalInfo result;
    private JLabel labelLast;
    private JLabel labelFirst;
    private JLabel labelClass;
    private JTextField textLast;
    private JTextField textFirst;
    private JTextField textClass;

    public LoginWin(JFrame f){

        super(f, "Авторизация");
        setModal(true);
        setResizable(false);
        JPanel first = (JPanel)getContentPane();
        first.setPreferredSize(new Dimension(400, 200));
        first.setLayout(null);

        JPanel second = new JPanel();
        second.setBounds(10,10,380,180);
        second.setLayout(new BorderLayout());
        second.setBorder(new BevelBorder(BevelBorder.RAISED,Color.BLACK,Color.WHITE,Color.BLACK,Color.WHITE));
        first.add(second);

        labelLast = new JLabel("Фамилия:");
        labelLast.setForeground(new Color(244, 172, 72));
        labelLast.setFont(new Font("Georgia", Font.BOLD, 14));
        labelFirst = new JLabel("Имя:");
        labelFirst.setForeground(new Color(244, 172, 72));
        labelFirst.setFont(new Font("Georgia", Font.BOLD, 14));
        labelClass = new JLabel("Класс:");
        labelClass.setForeground(new Color(244, 172, 72));
        labelClass.setFont(new Font("Georgia", Font.BOLD, 14));
        textLast = new JTextField();
        textLast.setPreferredSize(new Dimension(150,25));
        textFirst = new JTextField();
        textFirst.setPreferredSize(new Dimension(150,25));
        textClass = new JTextField();
        textClass.setPreferredSize(new Dimension(100,25));

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        panel1.setOpaque(false);
        panel1.add(labelLast);
        panel1.add(textLast);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        panel2.setOpaque(false);
        panel2.add(labelFirst);
        panel2.add(textFirst);

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        panel3.setOpaque(false);
        panel3.add(labelClass);
        panel3.add(textClass);


        JPanel center = new JPanel();
        center.setBackground(new Color(50, 48, 52));
        center.setLayout(new FlowLayout(FlowLayout.RIGHT,70,5));
        center.add(panel1);
        center.add(panel2);
        center.add(panel3);


        JPanel south = new JPanel();
        south.setBackground(new Color(50, 48, 52));
        south.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));

        second.add(center);
        second.add(south,BorderLayout.SOUTH);

        JButton buttonCancel = new JButton("Отмена");
        buttonCancel.setPreferredSize(new Dimension(100, 30));
        buttonCancel.setFont(new Font("Georgia", Font.BOLD, 14));
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result = new PersonalInfo(false);
                dispose();
            }
        });

        JButton buttonOk = new JButton("Вход");
        buttonOk.setPreferredSize(new Dimension(100, 30));
        buttonOk.setFont(new Font("Georgia", Font.BOLD, 14));
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Runnable() {
                    @Override
                    public void run() {
                        boolean runTest = true;
                        if(textLast.getText().length()==0){
                            runTest = false;
                            labelLast.setForeground(new Color(234, 81, 64));
                        }
                        else labelLast.setForeground(new Color(244, 172, 72));

                        if(textFirst.getText().length()==0){
                            runTest = false;
                            labelFirst.setForeground(new Color(234, 81, 64));
                        } else labelFirst.setForeground(new Color(244, 172, 72));
                        if(textClass.getText().length()==0){
                            runTest = false;
                            labelClass.setForeground(new Color(234, 81, 64));
                        } else labelClass.setForeground(new Color(244, 172, 72));

                        if(runTest){
                        result = new PersonalInfo(true,textLast.getText(),textFirst.getText(),textClass.getText());
                        dispose();
                        }
                    }
                }.run();
            }
        });

        JButton buttonTrial = new JButton("Пробный");
        buttonTrial.setPreferredSize(new Dimension(100, 30));
        buttonTrial.setFont(new Font("Georgia", Font.BOLD, 14));
        buttonTrial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result = new PersonalInfo(true);
                dispose();
            }
        });

        south.add(buttonCancel);
        south.add(buttonTrial);
        south.add(buttonOk);
        pack();
    }

    public PersonalInfo execute(){
        setVisible(true);
        return result;
    }
}

