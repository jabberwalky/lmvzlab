package lmvz;

/**
 * Created with IntelliJ IDEA.
 * User: denis
 * Date: 9/28/13
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
import javax.swing.*;
import java.awt.*;

/**
 * Класс наследует панель, дополняя ее возможностью
 * отрисовывать изображение с заданой прозрачностью.
 */
public class ImagePanel extends JPanel {

    /**
     * Изображение, которое содержится на панели.
     */
    private Image image;

    /**
     * Насколько изображение на панели прозрачно (0 - полностью прозрачное,
     * 1 - полностью непрозрачное).
     */
    private float alpha = 1f;

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        repaint();
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        if(image != null){
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }

    }
}
