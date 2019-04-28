/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladder;
import java.applet.*;
import java.net.*;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *
 * @author SAURABH
 */
public class TestSound extends JFrame{
    TestSound(){
        setSize(400, 400);
        setVisible(true);
        try{
            File f1 = new File("Sound/diceshake.WAV");
        URL dir = f1.toURL();
        AudioClip rfs = Applet.newAudioClip(dir);
        rfs.loop();
        rfs.play();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args)throws Exception{
        System.out.println("Hello");
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
         new TestSound();
            }
        });
    }
}
