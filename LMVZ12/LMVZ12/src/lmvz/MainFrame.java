package lmvz;

/**
 * Created with IntelliJ IDEA.
 * User: denis
 * Date: 9/28/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */


import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class MainFrame extends JFrame {

    private static int number = 0;
    private static ArrayList<Country> imageList = Data.readData();

    public static Image setNewImage(){
        if(number==imageList.size())
            number = 0;
        return imageList.get(number++).getImage();
    }


    public MainFrame(){
        super(" Столицы стран");
        /**
         * Оформление программы
         */
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e){
           e.printStackTrace();
        }

        initComponents();
    }

    public static void main(String [] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    private JButton jButtonSpr;
    private JButton jButtonTes;
    private JButton jButtonMap;
    private JButton jButtonJou;
    private JButton jButtonExi;
    private JMenu jMenuFile;
    private JMenu jMenuEdit;
    private JMenuBar jMenuBar;
    private JPanel jPanelFon;
    private ImagePanel jPanelBack;
    private ImagePanel jPanelFore;
    private ImagePanel jPanelGlass;

    private void initComponents() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                closingFrame(e);
            }
        });
        setResizable(false);
        jPanelFon = new JPanel();
        jPanelBack = new ImagePanel();
        jPanelFore = new ImagePanel();
        jPanelGlass = new ImagePanel();
        jButtonSpr = prepareJButton(new JButton("Справочник"));

        jButtonSpr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Runnable() {
                    @Override
                    public void run() {
                        new Dictionary2();
                        closeFrame();
                    }
                }.run();

            }
        });

        jButtonTes = prepareJButton(new JButton("Тесты"));
        jButtonTes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Runnable() {
                    @Override
                    public void run() {
                        new Tests();
                        closeFrame();
                    }
                }.run();
            }
        });

        jButtonMap = prepareJButton(new JButton("Карта"));
        jButtonJou = prepareJButton(new JButton("Журнал"));
        jButtonExi = prepareJButton(new JButton("Выход"));

        jButtonExi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jMenuBar = new JMenuBar();
        jMenuFile = new JMenu();
        jMenuEdit = new JMenu();

        jPanelFon.setBackground(new Color(235, 236, 233));
        jPanelFore.setOpaque(false);
        jPanelGlass.setOpaque(false);


        jPanelFore.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE,Color.BLACK,Color.WHITE,Color.BLACK));
        jPanelBack.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE,Color.BLACK,Color.WHITE,Color.BLACK));

        jPanelFore.setImage(imageList.get(number++).getImage());
        jPanelBack.setImage(imageList.get(number++).getImage());

        setGlassPanel();

        setForePanel();

        setBackPanel();

        setFonPanel();

        setBasicPanel();


        jMenuFile.setText("Файл");
        jMenuBar.add(jMenuFile);

        jMenuEdit.setText("Редактировать");
        jMenuBar.add(jMenuEdit);

        setJMenuBar(jMenuBar);

        pack();

        AlphaTimer.initTimer(jPanelFore, jPanelBack);
    }

    public void closingFrame(WindowEvent e) {
        if (e.getID()==WindowEvent.WINDOW_CLOSING) {
            this.dispose();
        }
    }

    public void closeFrame() {
        processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private JButton prepareJButton(JButton jButton){
        jButton.setFocusPainted(false);
        jButton.setBackground(new Color(26, 89, 178));
        jButton.setFont(new Font("Georgia", Font.BOLD, 16));
        jButton.setForeground(new Color(246, 246, 246));
        return jButton;
    }

    private void setGlassPanel(){
        GroupLayout jPanelGlassLayout = new GroupLayout(jPanelGlass);
        jPanelGlass.setLayout(jPanelGlassLayout);
        jPanelGlassLayout.setHorizontalGroup(
                jPanelGlassLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelGlassLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanelGlassLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButtonSpr, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonTes, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonMap, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonJou, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonExi, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(550, Short.MAX_VALUE))
        );
        jPanelGlassLayout.setVerticalGroup(
                jPanelGlassLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelGlassLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jButtonSpr)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonTes)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonMap)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonJou)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonExi)
                                .addContainerGap(180, Short.MAX_VALUE))
        );
    }

    private void setForePanel(){
        GroupLayout jPanelForeLayout = new GroupLayout(jPanelFore);
        jPanelFore.setLayout(jPanelForeLayout);
        jPanelForeLayout.setHorizontalGroup(
                jPanelForeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelForeLayout.createSequentialGroup()
                                .addComponent(jPanelGlass, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelForeLayout.setVerticalGroup(
                jPanelForeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelForeLayout.createSequentialGroup()
                                .addComponent(jPanelGlass, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void setBackPanel(){
        GroupLayout jPanelBackLayout = new GroupLayout(jPanelBack);
        jPanelBack.setLayout(jPanelBackLayout);
        jPanelBackLayout.setHorizontalGroup(
                jPanelBackLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelBackLayout.createSequentialGroup()
                                .addComponent(jPanelFore, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBackLayout.setVerticalGroup(
                jPanelBackLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelBackLayout.createSequentialGroup()
                                .addComponent(jPanelFore, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void setFonPanel(){
        GroupLayout jPanelFonLayout = new GroupLayout(jPanelFon);
        jPanelFon.setLayout(jPanelFonLayout);
        jPanelFonLayout.setHorizontalGroup(
                jPanelFonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanelBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanelFonLayout.setVerticalGroup(
                jPanelFonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanelBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

    private void setBasicPanel(){
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelFon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelFon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
}


