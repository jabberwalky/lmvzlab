package lmvz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: denis
 * Date: 9/29/13
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
abstract public class AlphaTimer {
    private static float incrementer;
    private static float newAlpha;
    private static Timer alphaChanger;
    private static ImagePanel firstImagePanel;
    private static ImagePanel secondImagePanel;

    public static void stopTimer(){
        alphaChanger.stop();
    }

    public static void initTimer(ImagePanel imagePanel1, ImagePanel imagePanel2){
        final ImagePanel localImagePanel = imagePanel1;
        firstImagePanel = imagePanel1;
        secondImagePanel = imagePanel2;
        incrementer = -0.03f;
        newAlpha = -1;

        alphaChanger = new Timer(70, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {}

    });
        alphaChanger.setInitialDelay(4000);

    alphaChanger.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            newAlpha = localImagePanel.getAlpha() + incrementer;
            if (newAlpha <= 0.0f) {
                newAlpha = 0.0f;
                incrementer = -incrementer;
            } else if (newAlpha >= 1.0f) {
                newAlpha = 1f;
                incrementer = -incrementer;
            }
            localImagePanel.setAlpha(newAlpha);
            if(checkTurning())
                return;
        }
    });
    alphaChanger.start();
    }

    private static boolean checkTurning(){
        if(newAlpha+incrementer>=1.0f || newAlpha+incrementer<=0.0f){
            if(newAlpha+incrementer>=1.0f)
                secondImagePanel.setImage(MainFrame.setNewImage());
            if(newAlpha+incrementer<=0.0f)
                firstImagePanel.setImage(MainFrame.setNewImage());
            alphaChanger.setDelay(4000);
            return true;
        }
        else {
            alphaChanger.setDelay(70);
        }
        return false;
        }
}
