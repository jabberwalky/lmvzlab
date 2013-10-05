package lmvz;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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
                    textArea.setText("Ло́ндон (англ. London ) — город и столица Соединённого Королевства Великобритании и Северной Ирландии. Административно образует регион Англии Большой Лондон, разделённый на 32 самоуправляемых района и Сити.\n" +
                            "Население — 8,3 млн человек (2012 год), второй по величине город Европы и крупнейший в Евросоюзе. Образует агломерацию «Большой Лондон» и более обширный метрополитенский район. Расположен на юго-востоке острова Великобритания, на равнине Лондонского бассейна, в устье Темзы вблизи Северного моря.");
                }
                else  if(list.getSelectedValue() == "Германия" )
                {
                    label3.setText("Берлин");
                    textArea.setText("Берли́н (нем. Berlin) — столица Германии, самый крупный и самый населённый город Германии. Берлин — второй по населению (после Лондона) и пятый по площади город Евросоюза.\n" +
                            "Берлин — одна из 16 земель в составе ФРГ. Город расположен на берегах рек Шпрее (с этим связано «прозвище» Берлина «Spree-Athen» — «Афины на Шпрее») и Хафель в центре федеральной земли Бранденбург, частью которой он не является (с 1920 года).");
                }
                else  if(list.getSelectedValue() == "Италия" )
                {
                    label3.setText("Рим");
                    textArea.setText("Рим (итал. Roma) — столица Италии, административный центр провинции Рим и области Лацио. Расположен на реке Тибр.\n" +
                            "Рим — один из старейших городов мира, древняя столица Римской империи. Ещё в Античности (III век н. э.) Рим стали часто называть Вечным (лат. Roma Aeterna). Одним из первых так назвал Рим римский поэт Альбий Тибулл (I век до н. э.) в своей второй элегии. Представления о «вечности» Рима во многом сохранились и после падения древнеримской цивилизации, принеся соответствующий эпитет в современные языки.");
                }
                else  if(list.getSelectedValue() == "Нидерланды" )
                {
                    label3.setText("Амстердам");
                    textArea.setText("Амстерда́м (нидерл. Amsterdam) — столица и крупнейший город Нидерландов. Является столицей королевства с 1814 года. Расположен в провинции Северная Голландия на западе страны в устье рек Амстел и Эй. Амстердам соединён с Северным морем каналом.\n" +
                            "По состоянию на 1 января 2012 года население муниципалитета Амстердам составляет 801 847 человек, вместе с пригородами (городской округ) — 2,3 млн жителей. Амстердам является частью агломерации Рандстад, которая является 6-й по величине в Европе.");
                }
                else  if(list.getSelectedValue() == "Польша" )
                {
                    label3.setText("Варшава");
                    textArea.setText("Варша́ва ) — столица и крупнейший по населению и по территории город в Польше.\n" +
                            "Город стал фактической столицей в 1596 году, когда после пожара Вавельского замка король Сигизмунд III перенёс свою резиденцию сюда, при этом столичный статус города был подтверждён только по Конституции 1791 года. Через город протекает река Висла.");
                }
                else  if(list.getSelectedValue() == "Украина" )
                {
                    label3.setText("Киев");
                    textArea.setText("Ки?ев (укр. Київ) — столица и самый крупный город Украины, город-герой. Расположен на реке Днепр; является центром Киевской агломерации. Киев — отдельная административно-территориальная единица Украины, культурный, политический, социально-экономический, транспортный, научный и правительственный центр страны, являющейся также одним из религиозных центров государства — в Киеве расположены центральные храмы УПЦ МП (Киево-Печерская лавра), УПЦ КП (Владимирский собор), УАПЦ (Андреевская церковь), УГКЦ (Собор Воскресения Христова). Киев также является административным центром Киевской области и Киево-Святошинского района Киевской области, хотя и не входит в их состав, имея особый правовой статус (см. раздел 5 данной статьи). Расположен на севере центральной части Украины. Киев — седьмой по населению город Европы после Стамбула, Москвы, Лондона, Санкт-Петербурга, Берлина и Мадрида.");
                }
                else  if(list.getSelectedValue() == "Франция" )
                {
                    label3.setText("Париж");
                    textArea.setText("Пари́ж — город и столица Франции; административный центр региона Иль-де-Франс. Образует коммуну и департамент, разделённый на 20 округов.\n" +
                            "Население — 2,2 млн человек (2010 год), шестой по величине город Европы. В пределах агломерации «Большой Париж» проживает 10,6 млн человек (2011 год). Расположен на севере Франции, на равнине Парижского бассейна, на берегах реки Сены.");
                }
                else  if(list.getSelectedValue() == "Чехия" )
                {
                    label3.setText("Прага");
                    textArea.setText("Пра́га — город и столица Чехии; административный центр Среднечешского края и двух его районов — Прага-Восток и Прага-Запад. Образует самостоятельную административную единицу страны.\n" +
                            "Население — 1,3 млн человек (2013 год), четырнадцатый по величине город в Евросоюзе. Расположена на берегах реки Влтавы вблизи её впадения в Лабу.\n" +
                            "Главный политический, экономический и культурный центр Чехии. Крупный туристический центр Европы: количество туристов в 2012 году превысило 5,4 млн человек.");
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
        JScrollPane scroll = new JScrollPane();


        panel.setBackground(new Color(50, 48, 52));
        panel.setSize(new Dimension(570, 480));
        panel.setLocation(10, 10);
        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.BLACK, Color.WHITE,Color.BLACK, Color.WHITE));
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
        list.setSelectedIndex(0);
        label3.setSize(220, 50);
        label3.setBorder(BorderFactory.createLineBorder(Color.black)) ;
        label3.setLocation(250, 30);
        label3.setText("Великобритания");
        label3.setFont(new Font("Georgia", Font.BOLD, 16));
        label3.setVerticalAlignment(SwingConstants.CENTER);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
       // label3.setText("Здесь может быть ваш текст");
        label3.setBackground(new Color(255, 206, 17));
        image.setSize(300,150);
        image.setLocation(220,85);
        image.setBackground(Color.black);
        textArea.setLocation(220 , 240);
        textArea.setSize(305,165);
        textArea.setBackground(Color.green);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setText("Ло́ндон (англ. London ) — город и столица Соединённого Королевства Великобритании и Северной Ирландии. Административно образует регион Англии Большой Лондон, разделённый на 32 самоуправляемых района и Сити.\n" +

              "Население — 8,3 млн человек (2012 год), второй по величине город Европы и крупнейший в Евросоюзе. Образует агломерацию «Большой Лондон» и более обширный метрополитенский район. Расположен на юго-востоке острова Великобритания, на равнине Лондонского бассейна, в устье Темзы вблизи Северного моря.");
        scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        add(panel);
        panel.add(label1);
        panel.add(list);
        panel.add(textPane);
        panel.add(label2);
        panel.add(label3);
        panel.add(image);
        panel.add(textArea);


        //textArea.add(scroll);
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
    public void closingFrame(WindowEvent e) {
        if (e.getID()==WindowEvent.WINDOW_CLOSING) {
            this.dispose();
        }
    }

}
