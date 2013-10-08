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

    String [] array = {"Австралия" ,"Аргентина" ,"Бразилия" , "Великобритания" , "Германия" , "Египет" , "Италия" ,"Канада" , "Нидерланды", "Новая Зеландия" , "Польша" ,  "Украина" , "Франция"  , "Чехия" , "ЮАР" };
    JList<String> list = new JList (array);

   // JLabel label1 = new JLabel();
    JPanel panel = new JPanel();
    //JTextPane textPane = new JTextPane();
    String [] comboArray = {"Все" , "Австралия", "Африка" , "Евразия" , "Северная Америка" , "Южная Америка" };
    JComboBox <String> comboBox = new JComboBox(comboArray);
    JLabel label2 = new JLabel();
    ImagePanel image = new ImagePanel();
    JLabel label3 = new JLabel();
    JTextArea textArea = new JTextArea();
    Image london = getToolkit().createImage("../LMVZ12/res/гербы/london.png");
    Image berlin = getToolkit().createImage("../LMVZ12/res/гербы/berlin.png");
    Image rome = getToolkit().createImage("../LMVZ12/res/гербы/rome.png");
    Image amsterdam = getToolkit().createImage("../LMVZ12/res/гербы/amsterdam.png");
    Image warsaw = getToolkit().createImage("../LMVZ12/res/гербы/warsaw.png");
    Image kiev = getToolkit().createImage("../LMVZ12/res/гербы/kiev.png");
    Image paris = getToolkit().createImage("../LMVZ12/res/гербы/paris.png");
    Image prague = getToolkit().createImage("../LMVZ12/res/гербы/prague.png");
    public Dictionary2(){
        super("Cловарь");
        initComponents();

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
                if(list.getSelectedValue() == "Австралия")
                {
                    label3.setText("Канберра");
                    textArea.setText("Ка́нбе́рра (англ. Canberra) — столица Австралийского Союза (Австралии). С населением, превышающим 345 тысяч человек, Канберра является крупнейшим городом Австралии, расположенным внутри страны, а не на побережье. Город находится в северной части Австралийской столичной территории в 280 км к юго-западу от Сиднея и в 650 км к северо-востоку от Мельбурна. В 1908 году территория современной Канберры была выбрана в качестве будущей столицы Австралийского Союза, что стало компромиссом между соперничавшими между собой за этот статус двумя крупнейшими городами страны, Сиднеем и Мельбурном.");

                    repaint();
                }
                if(list.getSelectedValue() == "Аргентина")
                {
                    label3.setText("Буэнос-Айрес");
                    textArea.setText("Буэ́нос-А́йрес (исп. Buenos Aires, букв. «хороший воздух» или «добрые ветра») — город, столица Аргентины, административный, культурный и экономический центр страны и один из крупнейших городов Южной Америки. Буэнос-Айрес расположен в центрально-восточной части страны, на западном берегу крупнейшего залива-эстуария Рио-де-ла-Плата, являющегося продолжением устья второй по длине реки Южной Америки — Парана́. Своё современное укороченное название — «Буэнос-Айрес» город носит с XVII века. До этого город официально именовался следующим полным именем: исп. Ciudad de la Santísima Trinidad y Puerto de Nuestra Señora de Santa María de los Buenos Aires, букв. «Город Пресвятой Троицы и Порт нашей Госпожи Святой Марии Добрых Ветров»." );

                    repaint();
                }
                if(list.getSelectedValue() == "Бразилия")
                {
                    label3.setText("Бразилиа");
                    textArea.setText("Брази́лиа (порт. Brasília ), также в ряде источников Брази́лия — столица Федеративной Республики Бразилии и резиденция правительства Федерального округа. Согласно данным переписи населения, проведённой Бразильским институтом географии и статистики в 2010 году, население города составляет 2 562 963 человек, по этому показателю является четвёртым крупнейшим городом страны. По количеству ВВП на душу населения Бразилиа находится на втором месте (40 696 реалов), уступая только Витории (60 592 реалов)");
                    repaint();
                }

                if(list.getSelectedValue() == "Великобритания")
                {
                    label3.setText("Лондон");
                    textArea.setText("Ло́ндон (англ. London ) — город и столица Соединённого Королевства Великобритании и Северной Ирландии. Административно образует регион Англии Большой Лондон, разделённый на 32 самоуправляемых района и Сити.\n" +
                            "Население — 8,3 млн человек (2012 год), второй по величине город Европы и крупнейший в Евросоюзе. Образует агломерацию «Большой Лондон» и более обширный метрополитенский район. Расположен на юго-востоке острова Великобритания, на равнине Лондонского бассейна, в устье Темзы вблизи Северного моря.");
                    image.setImage(london);
                    repaint();
                }
                else  if(list.getSelectedValue() == "Германия" )
                {
                    label3.setText("Берлин");
                    textArea.setText("Берли́н (нем. Berlin) — столица Германии, самый крупный и самый населённый город Германии. Берлин — второй по населению (после Лондона) и пятый по площади город Евросоюза.\n" +
                            "Берлин — одна из 16 земель в составе ФРГ. Город расположен на берегах рек Шпрее (с этим связано «прозвище» Берлина «Spree-Athen» — «Афины на Шпрее») и Хафель в центре федеральной земли Бранденбург, частью которой он не является (с 1920 года).");
                    image.setImage(berlin);
                    repaint();
                }
                if(list.getSelectedValue() == "Египет")
                {
                    label3.setText("Каир");
                    textArea.setText("Каи́р (араб. القاهرة‎‎, al-Qāhira — «победоносная») — столица Египта, крупнейший город Арабского мира и Африки. Египтяне его часто называют مصر‎ — Маср, то есть тем же словом, что и всю страну Египет. В прошлом Каир также мог именоваться «Египтом» и на других языках, в частности, на Руси в XV—XVII вв.\n" +
                            "Население — 8 026 454 в самом городе и 17 856 000 — в агломерации .");
                    repaint();
                }
                else  if(list.getSelectedValue() == "Италия" )
                {
                    label3.setText("Рим");
                    textArea.setText("Рим (итал. Roma) — столица Италии, административный центр провинции Рим и области Лацио. Расположен на реке Тибр.\n" +
                            "Рим — один из старейших городов мира, древняя столица Римской империи. Ещё в Античности (III век н. э.) Рим стали часто называть Вечным (лат. Roma Aeterna). Одним из первых так назвал Рим римский поэт Альбий Тибулл (I век до н. э.) в своей второй элегии. Представления о «вечности» Рима во многом сохранились и после падения древнеримской цивилизации, принеся соответствующий эпитет в современные языки.");
                    image.setImage(rome);
                    repaint();
                }
                if(list.getSelectedValue() == "Канада")
                {
                    label3.setText("Оттава");
                    textArea.setText("Отта́ва (англ. Ottawa), фр. Ottawa) — столица Канады. Расположена в восточной части провинции Онтарио на берегу реки Оттавы, по которой проходит граница между провинциями Онтарио и Квебек. Оттава — четвёртый по величине город страны и второй по величине город Онтарио. Вместе с расположенным с квебекской стороны реки городом Гатино и рядом других муниципалитетов Оттава входит в Национальную столичную область.\n" +
                            "Население Оттавы — 883 тысячи жителей, вместе с Гатино — 1 миллион 236 тысяч (по данным переписи населения 2011 года). Городское управление осуществляет муниципальный совет во главе с мэром. Пост мэра с 1 декабря 2010 года занимает Джим Уотсон.");
                    repaint();
                }
                else  if(list.getSelectedValue() == "Нидерланды" )
                {
                    label3.setText("Амстердам");
                    textArea.setText("Амстерда́м (нидерл. Amsterdam) — столица и крупнейший город Нидерландов. Является столицей королевства с 1814 года. Расположен в провинции Северная Голландия на западе страны в устье рек Амстел и Эй. Амстердам соединён с Северным морем каналом.\n" +
                            "По состоянию на 1 января 2012 года население муниципалитета Амстердам составляет 801 847 человек, вместе с пригородами (городской округ) — 2,3 млн жителей. Амстердам является частью агломерации Рандстад, которая является 6-й по величине в Европе.");
                    image.setImage(amsterdam);
                    repaint();
                }
                if(list.getSelectedValue() == "Новая Зеландия")
                {
                    label3.setText("Веддингтон");
                    textArea.setText("Ве́ллингтон, Уэ́ллингтон (англ. Wellington) — столица Новой Зеландии, второй по численности населения город страны, крупнейшая столица среди стран Океании и самая южная столица в мире. Город расположен в регионе Веллингтон в южной части острова Северный. Маорийское название Веллингтона — Те Фанауи-а-Тара (маори Te Whanganui-a-Tara).");
                    repaint();
                }
                else  if(list.getSelectedValue() == "Польша" )
                {
                    label3.setText("Варшава");
                    textArea.setText("Варша́ва — столица и крупнейший по населению и по территории город в Польше.\n" +
                            "Город стал фактической столицей в 1596 году, когда после пожара Вавельского замка король Сигизмунд III перенёс свою резиденцию сюда, при этом столичный статус города был подтверждён только по Конституции 1791 года. Через город протекает река Висла.");
                    image.setImage(warsaw);
                    repaint();
                }
                else  if(list.getSelectedValue() == "Украина" )
                {
                    label3.setText("Киев");
                    textArea.setText("Киев (укр. Київ) — столица и самый крупный город Украины, город-герой. Расположен на реке Днепр; является центром Киевской агломерации. Киев — отдельная административно-территориальная единица Украины, культурный, политический, социально-экономический, транспортный, научный и правительственный центр страны, являющейся также одним из религиозных центров государства — в Киеве расположены центральные храмы УПЦ МП (Киево-Печерская лавра), УПЦ КП (Владимирский собор), УАПЦ (Андреевская церковь), УГКЦ (Собор Воскресения Христова). Киев также является административным центром Киевской области и Киево-Святошинского района Киевской области, хотя и не входит в их состав, имея особый правовой статус (см. раздел 5 данной статьи). Расположен на севере центральной части Украины. Киев — седьмой по населению город Европы после Стамбула, Москвы, Лондона, Санкт-Петербурга, Берлина и Мадрида.");
                    image.setImage(kiev);
                    repaint();
                }
                else  if(list.getSelectedValue() == "Франция" )
                {
                    label3.setText("Париж");
                    textArea.setText("Пари́ж — город и столица Франции; административный центр региона Иль-де-Франс. Образует коммуну и департамент, разделённый на 20 округов.\n" +
                            "Население — 2,2 млн человек (2010 год), шестой по величине город Европы. В пределах агломерации «Большой Париж» проживает 10,6 млн человек (2011 год). Расположен на севере Франции, на равнине Парижского бассейна, на берегах реки Сены.");
                    image.setImage(paris);
                    repaint();
                }
                else  if(list.getSelectedValue() == "Чехия" )
                {
                    label3.setText("Прага");
                    textArea.setText("Пра́га — город и столица Чехии; административный центр Среднечешского края и двух его районов — Прага-Восток и Прага-Запад. Образует самостоятельную административную единицу страны.\n" +
                            "Население — 1,3 млн человек (2013 год), четырнадцатый по величине город в Евросоюзе. Расположена на берегах реки Влтавы вблизи её впадения в Лабу.\n" +
                            "Главный политический, экономический и культурный центр Чехии. Крупный туристический центр Европы: количество туристов в 2012 году превысило 5,4 млн человек.");
                    image.setImage(prague);
                    repaint();
                }
                if(list.getSelectedValue() == "ЮАР")
                {
                    label3.setText("Аддис-Абеба");
                    textArea.setText("Адди́с-Абе́ба  — столица Эфиопии и Африканского союза, а также его предшественника — Организации африканского Единства. С населением 3 041 002 жителей (2012) является крупнейшим в мире городом, расположенным в стране, не имеющей выхода к морю. Имеет статус отдельного региона Эфиопии.\n" +
                            "Основан в 1886 году императором Менеликом II по просьбе его жены — императрицы Таиту.");
                    repaint();
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
       // JList<String> list = new JList (array);


        jMenuBar = new JMenuBar();
        jMenuFile = new JMenu();
        jMenuEdit = new JMenu();
        JScrollPane scroll = new JScrollPane();


        panel.setBackground(new Color(50, 48, 52));
        panel.setSize(new Dimension(570, 480));
        panel.setLocation(10, 10);
        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE));
        panel.setLayout(null);
        comboBox.setLocation(40,45);
        comboBox.setSize(150,20);
        comboBox.setSelectedIndex(0);
       // textPane.setLocation(40, 65);
       // textPane.setSize(100, 20);
       // textPane.setBorder(BorderFactory.createLineBorder(Color.black)) ;
       // label1.setSize(150, 15);
       // label1.setLocation(45, 30);
      //  label1.setText("Поиск :");
        label2.setSize(150, 15);
        label2.setLocation(40, 110);
        label2.setText("Выберите страну:");
        //label2.setBackground(new Color(152, 255, 190));
        repaint();
        list.setLayoutOrientation(JList.VERTICAL);
        list.setBackground(new Color(242, 100, 255));
        list.setSize(new Dimension(110, 250));
        list.setLocation(40, 150);
        list.setBorder(BorderFactory.createLineBorder(Color.black)) ;
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        label3.setSize(220, 50);
        label3.setBorder(BorderFactory.createLineBorder(Color.black)) ;
        label3.setLocation(250, 30);
        label3.setText("Канберра");
        label3.setFont(new Font("Georgia", Font.BOLD, 16));
        label3.setVerticalAlignment(SwingConstants.CENTER);
        label3.setHorizontalAlignment(SwingConstants.CENTER);

        label3.setBackground(new Color(152, 255, 190));
        image.setSize(300,150);
        image.setLocation(220,85);
       // image.setBackground(Color.black);
        image.setImage(london);

        image.repaint();
        //image.paintComponent(london);
        textArea.setLocation(220 , 240);
        textArea.setSize(305,165);
        textArea.setBackground(Color.green);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setText("Ка́нбе́рра (англ. Canberra) — столица Австралийского Союза (Австралии). С населением, превышающим 345 тысяч человек, Канберра является крупнейшим городом Австралии, расположенным внутри страны, а не на побережье. Город находится в северной части Австралийской столичной территории в 280 км к юго-западу от Сиднея и в 650 км к северо-востоку от Мельбурна. В 1908 году территория современной Канберры была выбрана в качестве будущей столицы Австралийского Союза, что стало компромиссом между соперничавшими между собой за этот статус двумя крупнейшими городами страны, Сиднеем и Мельбурном.");
        scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        add(panel);
     //   panel.add(label1);
        panel.add(comboBox);
        panel.add(list);
     //   panel.add(textPane);
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
