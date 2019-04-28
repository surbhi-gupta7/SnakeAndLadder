/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladder;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author SAURABH
 */
public class MyPanel extends JPanel{
    Image img;
    
    public MyPanel(){
        String path = "/snakeandladder/newboard.png";
        //System.out.println(path);
        ImageIcon ii = new ImageIcon(this.getClass().getResource(path));
        img = ii.getImage();
    }
    @Override
    public void paintComponent(Graphics g){
        if(img!=null){
            g.drawImage(img, 0,0,getWidth(),getHeight(),null);
        }else{
            super.paintComponent(g);
        }
    }
}
