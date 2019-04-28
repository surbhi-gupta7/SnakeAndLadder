/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladder;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author SAURABH
 */
public class Level2 extends JInternalFrame implements Runnable {
    int count=1;
	boolean suspendFlag;

    JButton Dice, d1;
    Boolean turn = true;
    int p1 = 0, p2 = 0, n;
    JLabel i, l1;
    JRadioButton o1,o2;
    JPanel p;
    MyPanel jp;
    HashMap<Integer, JLabel> hm;
    int a[] = {100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 80,
        79, 78, 77, 76, 75, 74, 73, 72, 71, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51,
        41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
        20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int sm[] = {17, 54, 62, 64, 87, 93, 95, 99};
    int st[] = {7, 34, 19, 60, 24, 73, 75, 78};
    int ls[] = {4, 9, 20, 28, 40, 51, 63, 71};
    int le[] = {14, 31, 38, 84, 59, 67, 81, 91};
    String f = "Sound/diceshake.WAV", f1 = "Sound/snake.WAV", f2 = "Sound/ladder.WAV", red = "/snakeandladder/redpin.png",
            green = "/snakeandladder/greenpin.png", rg = "/snakeandladder/rgpin.png";
    JLabel la,stpwth;

    public Level2() {
        setTitle("Game-level2");
        setSize(600, 600);
        setVisible(true);
        setClosable(true);
	setResizable(true);
        
		
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
        o1 = new JRadioButton("move mine");
        o1.setSelected(true);
        o1.setEnabled(false);
        p.add(o1);
        o2 = new JRadioButton("move oponent");
        o2.setEnabled(false);
       
        p.add(o2);
        ButtonGroup bg = new ButtonGroup();
		bg.add(o1);
		bg.add(o2);
        
        stpwth= new JLabel();
         stpwth.setBackground(Color.yellow);
      //  stpwth.setFont(getFont());
	p.add(stpwth);
        
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
                        @Override
                        public void run() {
                            try {
                                String path2 = "/snakeandladder/rolldice.gif";
                                i.setIcon(new ImageIcon(this.getClass().getResource(path2)));
                                Dice.setText("dice rolling");
                                sound(f);
                                Random r = new Random();
                                n = r.nextInt(7);
                                if (n == 0) {
                                    n = 1;
                                }
                                Dice.setText("Roll dice");
                                i.setIcon(new ImageIcon(this.getClass().getResource("/snakeandladder/" + n + ".png")));
                                if (turn == true) {
                                    l1.setText("player 2 turn");
                                    if(o1.isSelected()){
                                    
                                    player1();}
                                    else if(o2.isSelected()){
                                    player2new();
                                    }
                                    turn = false;


                                } else if (turn == false) {
                                    l1.setText("player 1 turn");
                                    if(o1.isSelected()){
                                    
                                    player2();
                                    }
                                    else if(o2.isSelected()){
                                    player1new();
                                    }

                                    turn = true;
                                }
                            } catch (Exception e1) {
                                System.out.println("1"+e1);
                                e1.printStackTrace();
                            }
                        }
                    }).start();


                } catch (Exception ex) {
                    System.out.println(ex);
                                ex.printStackTrace();
                }
                //To change body of generated methods, choose Tools | Templates.
            }
        });
    }


    @Override
    public void run() {
    try {
                   for(int i = 0; i <5; i++) {

                    for(int j = 00; j <60; j++) {

                stpwth.setText(Integer.toString(i)+":"+Integer.toString(j));
                Thread.sleep(1000);
                if(i==1){
                stpwth.setBackground(Color.red);}
                 if(i==2&& j==0){
                    JOptionPane.showMessageDialog(null, "Rules are changed!!!! now you can either move your pin forward or your oponents pin backward on every roll of the dice");
                    o1.setEnabled(true);
                    o2.setEnabled(true);
                }
                else if(i==4&&j==59){
                    if(p1>p2){
                        JOptionPane.showMessageDialog(null, "Player1 wins!!");
                        setVisible(false);
                         new SnakeAndLadder();
                         break;
                    }
                    else if(p1<p2){
                         JOptionPane.showMessageDialog(null, "Player2 wins!!");
                         setVisible(false);
                        new SnakeAndLadder();
                        break;
                    }
                }
                //System.out.println(i+":"+j);
                synchronized(this) {
                    while(suspendFlag) {
                    wait();
                    }
                 }
            }
        } 
     }
    catch (InterruptedException e) {

            }
    }
public void mysuspend() {
suspendFlag = true;
}
public synchronized void myresume() {
suspendFlag = false;
notify();
}
    public void sound(String filename) {
        try {
            File fi = new File(filename);
            URL dir = fi.toURL();
            AudioClip rfs = Applet.newAudioClip(dir);
            rfs.play();
            Thread.sleep(2500);
            rfs.stop();
        } catch (MalformedURLException | InterruptedException sd) {
            System.out.println("3"+sd);
        }
    }

    public void changepic(Integer p, JLabel lab, String path) {
        
        lab = hm.get(p);
        if(path==null){
        lab.setIcon(null);
        }
        else if(p==0){}
        else
        lab.setIcon(new ImageIcon(this.getClass().getResource(path)));
    }

    public void player1() throws InterruptedException, MalformedURLException {
        JLabel l = hm.get(p1);
        JLabel l2 = hm.get(p2);

        if (p1 != 0) {
            changepic(p1,l,null);
               }
        while (n > 0 && (p1 + n) <= 101) {

            p1 = p1 + 1;
            if (p1 == 101) {
                JOptionPane.showMessageDialog(null, "player1 wins!!!");
                setVisible(false);
                new SnakeAndLadder();

                break;
            }

            if (p2 != 0 && p1 == p2) {
                changepic(p1, l, rg);
               
            }
            changepic(p1, l, red);
            Thread.sleep(500);
            changepic(p1,l,null);
           
            n--;
        }

        for (int i = 0; i <= 7; i++) {
            if (p1 == sm[i]) {
                p1 = st[i];
                sound(f1);
            } else if (p1 == ls[i]) {
                p1 = le[i];
                sound(f2);
            }
        }

        if (p2 != 0 && p1 != p2 && p2 <= 100) {
            changepic(p2, l2, green);
                    }
        if (p1 <= 100) {
            if (p2 != 0 && p1 == p2) {
                changepic(p1, l, rg);
            } else {
                changepic(p1, l, red);
               
            }
        }
    }
public void player1new() throws InterruptedException, MalformedURLException {
        JLabel l = hm.get(p1);
        JLabel l2 = hm.get(p2);

        if (p1 != 0) {
            changepic(p1,l,null);
               }
        while (n > 0 && (p1 - n) >= 0) {

          
            if ((p1-n)< 0) {
                JOptionPane.showMessageDialog(null, "cannot move player1!!!");
                
                break;
            }
  p1 = p1 - 1;
            if (p2 != 0 && p1 == p2) {
                changepic(p1, l, rg);
               
            }
            changepic(p1, l, red);
            Thread.sleep(500);
            changepic(p1,l,null);
           
            n--;
        }

        for (int i = 0; i <= 7; i++) {
            if (p1 == sm[i]) {
                p1 = st[i];
                sound(f1);
            } else if (p1 == ls[i]) {
                p1 = le[i];
                sound(f2);
            }
        }

        if (p2 != 0 && p1 != p2 && p2 <= 100) {
            changepic(p2, l2, green);
                    }
        if (p1 <= 100) {
            if (p2 != 0 && p1 == p2) {
                changepic(p1, l, rg);
            } else {
                changepic(p1, l, red);
               
            }
        }
    }
    public void player2() throws InterruptedException, MalformedURLException {
        JLabel l = hm.get(p2);
        JLabel l2 = hm.get(p1);
        if (p2 != 0) {
           
            changepic(p2,l,null);
        }
        while (n > 0 && (p2 + n) <= 101) {
            p2 = p2 + 1;
            if (p2 == 101) {
                JOptionPane.showMessageDialog(null, "player2 wins!!!");
                setVisible(false);
                new SnakeAndLadder();
                break;

            }
           if (p1 != 0 && p1 == p2) {
                changepic(p2, l, rg);
            }
            changepic(p2, l, green);
            
            Thread.sleep(500);
              changepic(p2,l,null);
               n--;
        }


        for (int i = 0; i <= 7; i++) {
            if (p2 == sm[i]) {
                p2 = st[i];
                sound(f1);
            } else if (p2 == ls[i]) {
                p2 = le[i];
                sound(f2);
            }
        }

        if (p1 != 0 && p1 != p2 && p1 <= 100) {
            changepic(p1, l2, red);
            
        }
        if (p2 <= 100) {

            if (p1 != 0 && p1 == p2) {
                changepic(p2, l, rg);
                
            } else {
                changepic(p2, l, green);
               
            }
        }
    }

  public void player2new() throws InterruptedException, MalformedURLException {
        JLabel l = hm.get(p2);
        JLabel l2 = hm.get(p1);
        if (p2 != 0) {
           
            changepic(p2,l,null);
        }
        while (n > 0 && (p2 - n) >= 0) {
            
            if ((p2-n)<0 ) {
                JOptionPane.showMessageDialog(null, "cannot move player2");
                 break;

            }
            p2 = p2 - 1;
           if (p1 != 0 && p1 == p2) {
                changepic(p2, l, rg);
            }
            changepic(p2, l, green);
            
            Thread.sleep(500);
              changepic(p2,l,null);
               n--;
        }


        for (int i = 0; i <= 7; i++) {
            if (p2 == sm[i]) {
                p2 = st[i];
                sound(f1);
            } else if (p2 == ls[i]) {
                p2 = le[i];
                sound(f2);
            }
        }

        if (p1 != 0 && p1 != p2 && p1 <= 100) {
            changepic(p1, l2, red);
            
        }
        if (p2 <= 100) {

            if (p1 != 0 && p1 == p2) {
                changepic(p2, l, rg);
                
            } else {
                changepic(p2, l, green);
               
            }
        }
  }
}


