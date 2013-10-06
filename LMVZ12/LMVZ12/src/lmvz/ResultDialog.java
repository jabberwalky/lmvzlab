package lmvz;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created with IntelliJ IDEA.
 * User: denis
 * Date: 10/5/13
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResultDialog extends JDialog {

    public ResultDialog(JFrame jFrame, int score){
        super(jFrame,"Результаты");
        initComponents(score);
    }

    private void initComponents(int score){


        setModal(true);
        setResizable(false);
        JPanel back = (JPanel)getContentPane();
        back.setPreferredSize(new Dimension(300,150));
        back.setLayout(null);
        JPanel second = new JPanel();
        second.setBounds(10,10,280,130);
        second.setLayout(new BorderLayout());
        second.setBorder(new BevelBorder(BevelBorder.RAISED,Color.BLACK,Color.WHITE,Color.BLACK,Color.WHITE));
        back.add(second);

        String [] result = {"Очень плохо","Плохо","Плохо","Средне","Хорошо","Отлично"};
        String s = "Ваша оценка — " + score;
        JLabel label = new JLabel(s);
        label.setForeground(new Color(244, 172, 72));
        label.setFont(new Font("Georgia", Font.BOLD, 14));
        JLabel res = new JLabel(result[score]);
        res.setForeground(new Color(244, 172, 72));
        res.setFont(new Font("Georgia", Font.BOLD, 14));

        JPanel center = new JPanel();
        center.setBackground(new Color(50, 48, 52));
        center.setLayout(new FlowLayout(FlowLayout.CENTER,100,15));
        JPanel south = new JPanel();
        south.setBackground(new Color(50, 48, 52));
        south.setLayout(new FlowLayout(FlowLayout.CENTER,10,15));
        second.add(center);
        second.add(south,BorderLayout.SOUTH);
        center.add(label);
        center.add(res);
        JButton button = new JButton("ОК");
        button.setPreferredSize(new Dimension(100,30));
        button.setFont(new Font("Georgia", Font.BOLD, 14));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Runnable() {
                    @Override
                    public void run() {
                        dispose();
                    }
                }.run();
            }
        });
        south.add(button);
        pack();
    }

    public boolean execute(){
        this.setVisible(true);
        return true;
    }
}
