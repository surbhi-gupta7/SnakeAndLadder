/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladder;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author SAURABH
 */
public class MyButton extends JLabel{
    
    private Image image;
    
    private final Rectangle innerArea = new Rectangle();
    
    public MyButton(Image image){
        this.image = image;
        //repaint();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(image!=null){
            SwingUtilities.calculateInnerArea(this, innerArea);
            g.drawImage(image,0,0,getWidth(),getHeight(),this);
        }
    }
}
