package lmvz;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.Random;


public class Tests extends JFrame {

    private static int questions= -1;
    ArrayList<Country> list;
    Country [] used;

    Random random = new Random();
    int time;
    Timer timer;
    private int [] answers;
    private int left;
    private Country [] askedCountries;
    private String [][] askedCapitals;
    JSlider jSlider;
    private JLabel jCountry;
    private JPanel resPanel;
    ButtonGroup buttonGroup;
    private JRadioButton [] options;

    public void closeFrame() {
        processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }



    public Tests(){
        super(" Тесты");
        askedCountries = new Country [5];
        askedCapitals = new String[5][];
        answers = new int[5];
        list = Data.readData();
        time=0;
        left=5;
        timer = new Timer(1170,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(time++<100){
                    jSlider.setValue(time);
                }
                else {
                    timer.stop();
                    int score=0;
                    for(int i=0;i<answers.length;++i)
                        if(answers[i]==1)
                            ++score;
                    setFinish(score);
                }
            }
        });
        timer.start();

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                closingFrame(e);
            }
        });
        initComponents();
        setQuestion(true);

//        ArrayList<Country> list = new ArrayList<Country>();
//        list.add(new Country("Нидерланды","Амстердам","Все хорошо","../LMVZ12/res/amsterdam.png"));
//        list.add(new Country("Германия","Берлин","Все хорошо","../LMVZ12/res/berlin.png"));
//        list.add(new Country("Украина","Киев","Плохо все...","../LMVZ12/res/kiev.jpg"));
//        list.add(new Country("Великобритания","Лондон","Все хорошо","../LMVZ12/res/london.png"));
//        list.add(new Country("Франция","Париж","Все хорошо","../LMVZ12/res/paris.jpg"));
//        list.add(new Country("Чехия","Прага","Все хорошо","../LMVZ12/res/prague.png"));
//        list.add(new Country("Италия","Рим","Все хорошо","../LMVZ12/res/rome.png"));
//        list.add(new Country("Польша","Варшава","Все хорошо","../LMVZ12/res/warszawa.png"));
//        list.add(new Country("США","Вашингтон","Все хорошо","../LMVZ12/res/washington.jpg"));
//        Data.writeData(list);
    }

    public void closingFrame(WindowEvent e) {
        if (e.getID()==WindowEvent.WINDOW_CLOSING) {
            this.dispose();
        }
    }

    private void initComponents(){
        setLayout(null);

        JPanel jPanel = (JPanel)getContentPane();
        jPanel.setPreferredSize(new Dimension(600,340));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(50, 48, 52));
        panel.setSize(new Dimension(580, 320));
        panel.setLocation(10, 10);
        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.BLACK, Color.WHITE,Color.BLACK, Color.WHITE));
        panel.setLayout(null);
        jPanel.add(panel);

        jSlider = new JSlider();
        jSlider.setSize(300, 30);
        jSlider.setLocation(20 + 265 - jSlider.getWidth() / 2, 10);
        jSlider.setValue(0);
        jSlider.setEnabled(false);
        panel.add(jSlider);

        resPanel = new JPanel(){
            Image background = getToolkit().createImage("../LMVZ12/res/tests/resBack.png");
            Image light = getToolkit().createImage("../LMVZ12/res/tests/resActive.png");
            Image right = getToolkit().createImage("../LMVZ12/res/tests/resGreen.png");
            Image wrong = getToolkit().createImage("../LMVZ12/res/tests/resRed.png");

            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(background,0,0,this.getWidth(),this.getHeight(),this);
                for(int i=0;i<5;++i){
                    if(answers[i]==1)
                        g.drawImage(right,i*61,3,50,50,this);
                    else if(answers[i]==-1)
                        g.drawImage(wrong,i*61,3,50,50,this);

                }
                g.drawImage(light,questions*61,3,50,50,this);
            }
        };
        resPanel.setSize(300,50);
        resPanel.setLocation(20 + 265 - resPanel.getWidth() / 2, 40);
        resPanel.setOpaque(false);
        panel.add(resPanel);

        JLabel jTime = new JLabel("Время:");
        jTime.setSize(60,30);
        jTime.setLocation(50, 10);
        jTime.setFont(new Font("Georgia", Font.BOLD, 14));
        jTime.setForeground(new Color(244, 172, 72));
        panel.add(jTime);

        JLabel jProgress = new JLabel("Прогресс:");
        jProgress.setSize(80,30);
        jProgress.setLocation(30, 50);
        jProgress.setFont(new Font("Georgia", Font.BOLD, 14));
        jProgress.setForeground(new Color(244, 172, 72));
        panel.add(jProgress);

        JLabel jQuestion = new JLabel("Выберите столицу в стране:");
        jQuestion.setSize(225,30);
        jQuestion.setLocation(230 - jQuestion.getWidth() / 2, resPanel.getY() + 60);
        jQuestion.setFont(new Font("Georgia", Font.BOLD, 14));
        jQuestion.setForeground(new Color(244, 172, 72));
        panel.add(jQuestion);

        jCountry = new JLabel("");
        jCountry.setSize(150,30);
        jCountry.setLocation(jQuestion.getX() + jQuestion.getWidth() + 2, resPanel.getY() + 60);
        jCountry.setFont(new Font("Georgia", Font.BOLD, 14));
        jCountry.setForeground(new Color(244, 172, 72));
        panel.add(jCountry);


        buttonGroup = new ButtonGroup();
        options = new JRadioButton [4];
        for(int i=0;i<options.length;++i){
            options[i]=new JRadioButton();
            options[i].setSize(150, 30);
            options[i].setFont(new Font("Georgia", Font.BOLD, 14));
            options[i].setForeground(new Color(244, 172, 72));
            options[i].addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    JRadioButton source = (JRadioButton)e.getSource();
                    if(source.isSelected())
                        source.setForeground(new Color(122, 184, 233));
                    else
                        source.setForeground(new Color(244, 172, 72));
                }
            });
            panel.add(options[i]);
            buttonGroup.add(options[i]);
        }

        options[0].setSize(150, 30);
        options[0].setLocation(130, 150);

        options[1].setSize(150, 30);
        options[1].setLocation(130, 200);

        options[2].setSize(210, 30);
        options[2].setLocation(290, 150);

        options[3].setSize(210, 30);
        options[3].setLocation(290, 200);

        JPanel borderPanel = new JPanel();
        borderPanel.setOpaque(false);
        borderPanel.setSize(320,100);
        borderPanel.setLocation(120,140);
        borderPanel.setBorder(new BevelBorder(BevelBorder.LOWERED,Color.WHITE,Color.BLACK,Color.WHITE,Color.BLACK));
        panel.add(borderPanel);

        JButton previousButton = new JButton("Назад");
        previousButton.setSize(120, 40);
        previousButton.setLocation(80, 260);
        previousButton.setFont(new Font("Georgia", Font.BOLD, 14));
        previousButton.setToolTipText("<html>Нажмите эту кнопку, чтобы <p> перейти к предидущему вопросу.");
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setQuestion(false);
            }
        });
        panel.add(previousButton);

        JButton selectButton = new JButton("Ответить");
        selectButton.setSize(120, 40);
        selectButton.setLocation(220, 260);
        selectButton.setFont(new Font("Georgia", Font.BOLD, 14));
        selectButton.setToolTipText("<html>Нажмите эту кнопку, если вы <p> уверены в выбранном варианте.");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = null;
                for (int i = 0; i < 4; ++i)
                    if (options[i].isSelected()) {
                        s = options[i].getText();
                        break;
                    }

                if (answers[questions] == 0 && s != null) {
                    if (askedCountries[questions].capital == s) {
                        answers[questions] = 1;
                    } else {
                        answers[questions] = -1;
                    }
                    if(--left==0){
                        int score=0;
                        for(int i=0;i<answers.length;++i)
                            if(answers[i]==1)
                                ++score;
                        resPanel.repaint();
                        setFinish(score);
                    } else {
                        setQuestion(true);
                        resPanel.repaint();
                    }
                }
            }
        });
        panel.add(selectButton);

        JButton nextButton = new JButton("Дальше");
        nextButton.setSize(120, 40);
        nextButton.setLocation(360, 260);
        nextButton.setFont(new Font("Georgia", Font.BOLD, 14));
        nextButton.setToolTipText("<html>Нажмите эту кнопку, чтобы <p> перейти к следующему вопросу.");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setQuestion(true);
            }
        });
        panel.add(nextButton);



        setResizable(false);
        pack();
        this.setVisible(true);
    }

    private void setQuestion(boolean next){
        if(next)
            ++questions;
        else
            --questions;

        if(questions==5)
            questions=0;
        if(questions==-1)
            questions=4;

        if(askedCountries[questions]==null){
            used = new Country [5];
            for(int i=0; i<4; ++i){
                used[i]=list.get(random.nextInt(list.size()));
                list.remove(used[i]);
            }
            jCountry.setText(used[0].name);
            int right = random.nextInt(3);
            int num = 1;
            for(int i=0;i<4;++i){
                if(i==right)
                    options[i].setText(used[0].capital);
                else
                    options[i].setText(used[num++].capital);
            }
            list.add(used[1]);
            list.add(used[2]);
            list.add(used[3]);
            askedCountries[questions]=used[0];
            askedCapitals[questions] = new String [4];
            for(int i=0;i<4;++i){
                askedCapitals[questions][i] = options[i].getText();
            }
        }
        else {
            jCountry.setText(askedCountries[questions].name);
            for (int i=0;i<4;++i)
                options[i].setText(askedCapitals[questions][i]);
        }
        resPanel.repaint();
        buttonGroup.clearSelection();
    }


    private void setFinish(int score){
        timer.stop();
        ResultDialog dialog = new ResultDialog(this,score);
        if(dialog.execute()){
            new Runnable() {
                @Override
                public void run() {
                    new MainFrame();
                    closeFrame();
                }
            }.run();
        }
    }
}

