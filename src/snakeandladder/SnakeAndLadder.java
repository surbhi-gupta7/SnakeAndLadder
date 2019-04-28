/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author SAURABH
 */
public class SnakeAndLadder extends javax.swing.JFrame {

    /**
     * @param args the command line arguments
     */                 
    JDesktopPane d1;
    JMenuBar mb;
    JMenu gmenu,vmenu;
    JTextArea rules,about;
    public SnakeAndLadder(){
                setIconImage(new ImageIcon(this.getClass().getResource("icon.jpg"))
				.getImage());
                setSize(800,800);
                setTitle("Snake and Ladder");
      
        
                d1= new JDesktopPane() ;
		add(d1);
		
		mb=new JMenuBar();
		setJMenuBar(mb);
		gmenu = new JMenu("New");
		
		JMenuItem sitem1, sitem2, sitem3,sitem4;
		gmenu.add(sitem1 = new JMenuItem("Play game level 1"));
		gmenu.add(sitem2= new JMenuItem("Play game level 2"));
		gmenu.add(sitem3 =new JMenuItem("Rules"));
		gmenu.add(sitem4 = new JMenuItem("About"));
		
		gmenu.add(gmenu);
		mb.add(gmenu);
                sitem1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameFrame f = new gameFrame();
                              
				d1.add(f);

			}

                });
		sitem2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Level2 l = new Level2();
				d1.add(l);

			}
		});
		sitem3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
                             JOptionPane.showMessageDialog(null, "Rules for level-1 ----------------------------\n"
                                + "Rule 1-roll dice \n"
                                + "Rule 2-first player to get beyond 100 wins \n"
                                + "Rules for level-2-------------------------------- \n"
                                +"Rule 1-Game is of 5 min \n "
                                +"Rule 2-After 2 min game rule changes: \n "
                                + "      Either you can move your pin forward or your oponents pin backward on every roll of dice\n"
                                     +"Rule 3- after 5 minutes who so ever is ahead wins the game\n");
                        rules= new JTextArea(
                        );
                        d1.add(rules);
				

			}
		});
		sitem4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			  JOptionPane.showMessageDialog(null,"Hi.. \nAdmin:Surbhi\n"
                                 + "Technology- java");
                         d1.add(about);
			}
		});
    }
    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SnakeAndLadder().setVisible(true);
                
            }
        });
        // TODO code application logic here
    }
}
