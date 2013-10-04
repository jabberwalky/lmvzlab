package lmvz;

import java.awt.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: denis
 * Date: 10/2/13
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Country implements Serializable {

    String name;
    String capital;
    String description;
    String image;

    public Country(String name, String capital, String description, String image){
        this.name = name;
        this.capital = capital;
        this.description = description;
        this.image = image;
    }

    public Image getImage(){
        return Toolkit.getDefaultToolkit().createImage(image);
    }

}

