package spaceWar;

import javax.swing.JFrame;

public class Main extends JFrame {
	public static	JFrame pencere=new JFrame("SPACE WAR");
	static JFrame baslangicframe = new JFrame("SPACE WAR");

	public static void main(String[] args) {


		Baslangic b =new Baslangic();		
		baslangicframe.add(b);
		baslangicframe.setSize(900, 600);
		baslangicframe.setResizable(false);
		baslangicframe.setVisible(true);
		baslangicframe.addKeyListener(b);
		baslangicframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
