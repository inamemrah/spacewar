package spaceWar;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import spaceWar.Space;

public class Baslangic extends JPanel implements KeyListener {
	
	Image kapak;
	int kapak_x,kapak_y,kapak_yuk,kapak_gen;
	
	ImageIcon icon;
	JButton basla = new JButton("Baþla");
	
	static JFrame baslangic = new JFrame("SPACE WAR");
	
	
	
	public Baslangic(){
		
		kapak_x=0;
		kapak_y=0;
		kapak_gen=900;
		kapak_yuk=600;
		
		kapak=Toolkit.getDefaultToolkit().getImage("src/kapakkkk.png");
		


		
	}
	
	public void paint (Graphics g)
	{
		g.drawImage(kapak,kapak_x,kapak_y,kapak_gen,kapak_yuk, null);
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			Main.baslangicframe.setVisible(false);
			Space space =new Space();		
			Main.pencere.add(space);
			Main.pencere.setSize(1200, 680);
			Main.pencere.setResizable(false);
			Main.pencere.setVisible(true);
			Main.pencere.addKeyListener(space);
			Main.pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
