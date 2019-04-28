/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladder;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author SAURABH
 */
public class gameFrame extends JInternalFrame implements Runnable {
    

    JButton Dice, d1;
    Boolean turn = true;
    int p1 = 0, p2 = 0, n;
    JLabel i, l1;
    JPanel p;
    MyPanel jp;
    HashMap<Integer, JLabel> hm;
    int a[] = {100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 80,
        79, 78, 77, 76, 75, 74, 73, 72, 71, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51,
        41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
        20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    /**
     * Creates new form gameFrame
     */
    @SuppressWarnings("empty-statement")
    public gameFrame() {
        initComponents();
        setTitle("Game-level 1");
        setSize(600, 600);
        setVisible(true);
        setClosable(true);
	setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        setLayout(new BorderLayout());

        p = new JPanel();

        i = new JLabel("");
        String path1 = "/snakeandladder/dice.png";
        i.setIcon(new ImageIcon(this.getClass().getResource(path1)));

        p.add(i);
        l1 = new JLabel("");

        p.add(l1);

        Dice = new JButton("Roll Dice");
        p.add(Dice);

        add(p, BorderLayout.SOUTH);

        hm = new HashMap<Integer, JLabel>();
        jp = new MyPanel();
        jp.setLayout(new GridLayout(10, 10));

        int z = 0;
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                JLabel l = new JLabel("");
                jp.add(l);
                Integer iig = a[z];
                z++;
                hm.put(iig, l);
            }
        }
        add(jp);
   
        new Thread(this).start();
        Dice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    new Thread(new Runnable() {
                        @SuppressWarnings("deprecation")
						@Override
                        public void run() {
                            try {
                                String path2 = "/snakeandladder/rolldice.gif";
                                i.setIcon(new ImageIcon(this.getClass().getResource(path2)));
                                Dice.setText("dice rolling");
                                
                               // File f = new File("Sound/diceshake.WAV");
                                File f = new File("D:\\Surbhi\\java classes\\snake and ladder\\snakeAndLadder\\Sound.WAV");
                                URL dir = f.toURL();
                                AudioClip rfs = Applet.newAudioClip(dir);
                                //  rfs.loop();
                                rfs.play();

                                Thread.sleep(2500);
                                rfs.stop();
                                Random r = new Random();
                                n = r.nextInt(7);
                                if (n == 0) {
                                    n = 1;
                                }
                                Dice.setText("Roll dice");
                                i.setIcon(new ImageIcon(this.getClass().getResource("/snakeandladder/" + n + ".png")));
                                if (turn == true) {
                                    l1.setText("player 2 turn");
                                    player1();
                                     turn = false;
                                    
                                     
                                } else if (turn == false) {
                                    l1.setText("player 1 turn");
                                   
                                    player2();
                                    turn = true;
                                }
                            } catch (Exception e1) {
                                System.out.println(e1);
                            }
                        }
                    }).start();


                } catch (Exception ex) {
                }
                //To change body of generated methods, choose Tools | Templates.
            }
        });
   
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();

        jInternalFrame1.setVisible(true);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_formInternalFrameClosing

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        
    }

    public void player1() throws InterruptedException, MalformedURLException {
        JLabel l = hm.get(p1);

        if (p1 != 0) {
            l.setIcon(null);
        }
        while (n > 0 && (p1 + n) <= 101) {
            
            p1 = p1 + 1;
            if(p1==101){
                JOptionPane.showMessageDialog(null, "player1 wins!!!");
                setVisible(false);
                new SnakeAndLadder();
                
                break;
            }
            
            l = hm.get(p1);
            if (p2 != 0 && p1 == p2) {
                l.setIcon(new ImageIcon(this.getClass().getResource("/snakeandladder/rgpin.png")));
              }
            l.setIcon(new ImageIcon(this.getClass().getResource("/snakeandladder/redpin.png")));
            Thread.sleep(500);
            l.setIcon(null);
            n--;
        }
      
        File f1 = new File("Sound/snake.WAV");
        URL dir1 = f1.toURL();
        AudioClip rfs1 = Applet.newAudioClip(dir1);
        File f2 = new File("Sound/ladder.WAV");
        URL dir2 = f2.toURL();
        AudioClip rfs2 = Applet.newAudioClip(dir2);


        switch (p1) {
            case 17:

                p1 = 7;
                rfs1.play();
                Thread.sleep(2500);
                rfs1.stop();
                break;
            case 54: {
                p1 = 34;
                rfs1.play();
                Thread.sleep(2500);
                rfs1.stop();
                break;
            }
            case 62: {
                p1 = 19;
                rfs1.play();
                Thread.sleep(2500);
                rfs1.stop();
                break;
            }
            case 64: {
                p1 = 60;
                rfs1.play();
                Thread.sleep(2500);
                rfs1.stop();
                break;
            }
            case 87: {
                p1 = 24;
                rfs1.play();
                Thread.sleep(2500);
                rfs1.stop();
                break;
            }
            case 93: {
                p1 = 73;
                rfs1.play();
                Thread.sleep(2500);
                rfs1.stop();
                break;
            }
            case 95: {
                p1 = 75;
                rfs1.play();
                Thread.sleep(2500);
                rfs1.stop();
                break;
            }
            case 99: {
                p1 = 78;
                rfs1.play();
                Thread.sleep(2500);
                rfs1.stop();
                break;
            }
            //ladder     
            case 4: {
                p1 = 14;
                rfs2.play();
                Thread.sleep(2500);
                rfs2.stop();
                break;
            }
            case 9: {
                p1 = 31;
                rfs2.play();
                Thread.sleep(2500);
                rfs2.stop();
                break;
            }
            case 20: {
                p1 = 38;
                rfs2.play();
                Thread.sleep(2500);
                rfs2.stop();
                break;
            }
            case 28: {
                p1 = 84;
                rfs2.play();
                Thread.sleep(2500);
                rfs2.stop();
                break;
            }
            case 40: {
                p1 = 59;
                rfs2.play();
                Thread.sleep(2500);
                rfs2.stop();
                break;
            }
            case 51: {
                p1 = 67;
                rfs2.play();
                Thread.sleep(2500);
                rfs2.stop();
                break;
            }
            case 63: {
                p1 = 81;
                rfs2.play();
                Thread.sleep(2500);
                rfs2.stop();
                break;
            }
            case 71: {
                p1 = 91;
                rfs2.play();
                Thread.sleep(2500);
                rfs2.stop();
                break;
            }
        }
if (p2 != 0 && p1 != p2 && p2<=100) {
            JLabel l1 = hm.get(p2);
            l1.setIcon(new ImageIcon(this.getClass().getResource("/snakeandladder/greenpin.png"))); 

        }
       if(p1<=100){
           if (p2 != 0 && p1 == p2) {
               
               l = hm.get(p2);
                l.setIcon(new ImageIcon(this.getClass().getResource("/snakeandladder/rgpin.png")));
            }
           else{
        l = hm.get(p1);
        l.setIcon(new ImageIcon(this.getClass().getResource("/snakeandladder/redpin.png")));
       }
    }
    }
    public void player2() throws InterruptedException, MalformedURLException {
        JLabel l = hm.get(p2);
  
        if (p2 != 0) {
            l.setIcon(null);
        }
        while (n > 0 && (p2 + n) <= 101) {
            p2 = p2 + 1;
            if(p2==101) {
                JOptionPane.showMessageDialog(null, "player2 wins!!!");
                setVisible(false);
             new SnakeAndLadder();
                break;
                
            }
            l = hm.get(p2);
            if (p1 != 0 && p1 == p2) {
                l.setIcon(new ImageIcon(this.getClass().getResource("/snakeandladder/rgpin.png")));
            }

            l.setIcon(new ImageIcon(this.getClass().getResource("/snakeandladder/greenpin.png")));
            Thread.sleep(500);
            l.setIcon(null);
            n--;
        }
         

        File f1 = new File("Sound/snake.WAV");
        URL dir1 = f1.toURL();
        AudioClip rfs1 = Applet.newAudioClip(dir1);
        File f2 = new File("Sound/ladder.WAV");
        URL dir2 = f2.toURL();
        AudioClip rfs2 = Applet.newAudioClip(dir2);


        switch (p2) {
            case 17: {
                p2 = 7;
                rfs1.play();
                Thread.sleep(2500);
                rfs1.stop();
                break;
            }
            case 54: {
                p2 = 34;
                rfs1.play();
                Thread.sleep(2500);
                rfs1.stop();
                break;
            }
            case 62: {
                p2 = 19;
                rfs1.play();
                Thread.sleep(2500);
                rfs1.stop();
                break;
            }
            case 64: {
                p2 = 60;
                rfs1.play();
                Thread.sleep(2000);
                rfs1.stop();
                break;
            }
            case 87: {
                p2 = 24;
                rfs1.play();
                Thread.sleep(2000);
                rfs1.stop();
                break;
            }
            case 93: {
                p2 = 73;
                rfs1.play();
                Thread.sleep(2000);
                rfs1.stop();
                break;
            }
            case 95: {
                p2 = 75;
                rfs1.play();
                Thread.sleep(2000);
                rfs1.stop();
                break;
            }
            case 99: {
                p2 = 78;
                rfs1.play();
                Thread.sleep(2000);
                rfs1.stop();
                break;
            }

            case 4: {
                p2 = 14;
                rfs2.play();
                Thread.sleep(2000);
                rfs2.stop();
                break;
            }
            case 9: {
                p2 = 31;
                rfs2.play();
                Thread.sleep(2500);
                rfs2.stop();
                break;
            }
            case 20: {
                p2 = 38;
                rfs2.play();
                Thread.sleep(2500);
                rfs2.stop();
                break;
            }
            case 28: {
                p2 = 84;
                rfs2.play();
                Thread.sleep(2500);
                rfs2.stop();
                break;
            }
            case 40: {
                p2 = 59;
                rfs2.play();
                Thread.sleep(2500);
                rfs2.stop();
                break;
            }
            case 51: {
                p2 = 67;
                rfs2.play();
                Thread.sleep(2500);
                rfs2.stop();
                break;
            }
            case 63: {
                p2 = 81;
                rfs2.play();
                Thread.sleep(2500);
                rfs2.stop();
                break;
            }
            case 71: {
                p2 = 91;
                rfs2.play();
                Thread.sleep(2500);
                rfs2.stop();
                break;
            }
             

        }
        if (p1 != 0 && p1 != p2&& p1<=100) {
            JLabel l1 = hm.get(p1);
            l1.setIcon(new ImageIcon(this.getClass().getResource("/snakeandladder/redpin.png")));
             

        }
        if(p2<=100){
           
            if (p1 != 0 && p1 == p2) {
                l = hm.get(p2);
                l.setIcon(new ImageIcon(this.getClass().getResource("/snakeandladder/rgpin.png")));
             
            }
        
            else{
             l = hm.get(p2);
             l.setIcon(new ImageIcon(this.getClass().getResource("/snakeandladder/greenpin.png")));
          
        }
     }
    }
       
}