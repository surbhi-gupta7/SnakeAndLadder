/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladder;

import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author SAURABH
 */
public class Test {
    Test(){
        try{
            URL url = this.getClass().getClassLoader().getResource("D:\\New folder\\Game\\bust_22.WAV");
            AudioInputStream audioIN = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIN);
            clip.start();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Test();
    }
}
