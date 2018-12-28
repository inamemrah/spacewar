package spaceWar;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Space extends JPanel implements ActionListener,KeyListener {

	
	
	
	int arkaplan_x=0,arkaplan_y=0,arkaplan_gen=1200,arkaplan_yuk=650;
	int player_x=0,player_y=250,player_gen=150,player_yuk=120;
	int gemi_x1,gemi_y1,gemi_gen1,gemi_yuk1;
	int gemi_x2,gemi_y2,gemi_gen2,gemi_yuk2;
	int gemi_x3,gemi_y3,gemi_gen3,gemi_yuk3;
	int gemi_x4,gemi_y4,gemi_gen4,gemi_yuk4;
	
	int mermi_x1,mermi_y1,mermi_gen1,mermi_yuk1;
	
	int ciz=1;
	int mermiyon=1;
	int mermiyon2=1;
	
	Image arkaplan;
	Image player;
	Image gemi1;
	Image gemi2;
	Image gemi3;
	Image gemi4;
	int a;
	int yon=0;
	Image mermi;
	
	Timer zaman=new Timer(30,this);
	Random r = new Random();
	String yazim="";
	int puan =0;
	int kontrol=1;
	int sayac=0;
	double hýz=1;
	
	
	
	public Space(){
		
		super();
		gemi_x1=600;
		gemi_y1=250;
		gemi_gen1=100;
		gemi_yuk1=80;
		
		gemi_x2=gemi_x1+r.nextInt(500)+200; 
		gemi_y2=r.nextInt(550)+200;
		gemi_gen2=130;
		gemi_yuk2=100;
		
		gemi_x3=gemi_x2+r.nextInt(500)+200; 
		gemi_y3=r.nextInt(550)+30;
		gemi_gen3=140;
		gemi_yuk3=100;
		
		gemi_x4=gemi_x3+r.nextInt(500)+200; 
		gemi_y4=r.nextInt(450)+150;
		gemi_gen4=180;
		gemi_yuk4=80;
		
		mermi_x1=-20;;
		mermi_y1=150;
		mermi_gen1=40;
		mermi_yuk1=20;
		

		arkaplan=Toolkit.getDefaultToolkit().getImage("src/harita.png");
		player=Toolkit.getDefaultToolkit().getImage("src/player.png");
		gemi1=Toolkit.getDefaultToolkit().getImage("src/a.png");
		gemi2=Toolkit.getDefaultToolkit().getImage("src/b.png");
		gemi3=Toolkit.getDefaultToolkit().getImage("src/c.png");
		gemi4=Toolkit.getDefaultToolkit().getImage("src/d.png");
		
		mermi=Toolkit.getDefaultToolkit().getImage("src/mermi1.png");
		
		
		zaman.start();
		
		
		
	}
	
	public void paint(Graphics g)
	{
		

		super.paintComponent(g);
		 g.drawImage(arkaplan, arkaplan_x, arkaplan_y, arkaplan_gen,arkaplan_yuk,null);
		 g.drawImage(player,player_x, player_y, player_gen,player_yuk,null);
		 g.drawImage(gemi1, gemi_x1, gemi_y1,gemi_gen1,gemi_yuk1,null);
		 g.drawImage(gemi2, gemi_x2, gemi_y2, gemi_gen2, gemi_yuk2, null);
		 g.drawImage(gemi3, gemi_x3,gemi_y3,gemi_gen3, gemi_yuk3, null);
		 g.drawImage(gemi4, gemi_x4, gemi_y4, gemi_gen4, gemi_yuk4, null);
		 if(ciz>1){
		 g.drawImage(mermi, mermi_x1, mermi_y1, mermi_gen1, mermi_yuk1, null);
	
		 }
		 g.setColor(Color.WHITE);
		 
		 if(kontrol>1){
				
				int art = 0; art++;
				if (art==1){
					kontrol=1;
					}
				}
				

		 String puan_string = Integer.toString(puan);
		 g.setFont(new Font ("Comin Sans Ms", Font.ITALIC,50));
		 g.drawString(puan_string, 600, 50);
		 g.setFont(new Font ("Comin Sans Ms", Font.ITALIC,50));
		 g.drawString(yazim,250, 350);
 
		 	 
		 String sayacyaz=Integer.toString(sayac);
		 g.drawString(sayacyaz, 50, 50);
		 
		 sayac++;

		 if(sayac%1000==0){
			 
			 hýz+=0.50;
		
		 }

	
		 
		
	}
	
	
	
		 @Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			 
			 	Rectangle arkaplan = new Rectangle(arkaplan_x,arkaplan_y,arkaplan_gen,arkaplan_yuk);
					Rectangle player =new Rectangle(player_x ,player_y,player_gen-50,player_yuk-50);
					Rectangle gemi1 = new Rectangle(gemi_x1,gemi_y1,gemi_gen1-25,gemi_yuk1-25);
					Rectangle gemi2 = new Rectangle(gemi_x2,gemi_y2,gemi_gen2-25,gemi_yuk2-25);
					Rectangle gemi3 = new Rectangle(gemi_x3,gemi_y3,gemi_gen3-25,gemi_yuk3-25);
					Rectangle gemi4 = new Rectangle(gemi_x4,gemi_y4,gemi_gen4-25,gemi_yuk4-25);
					Rectangle mermi =new Rectangle(mermi_x1,mermi_y1,mermi_gen1+25,mermi_yuk1+25);
				
				Random hareket = new Random();
				 yon++;
				 if(yon%10==0){
					 
						a=hareket.nextInt(2);
						
					 
				 }
			
				for(int i =0;i<=5;i++){
					
					if(	 player.intersects(gemi4) || player.intersects(gemi3) ||player.intersects(gemi2) ||player.intersects(gemi1)) 
					{
						zaman.stop();
						

						 if (kontrol==1)
							 
						 {
						 kontrol++;
						 
						 }
						
						yazim=" Oyun Bitti Yeniden Baþlayýnýz !!!";
						 
						
					
					}	
					
					
					else{
					
						gemi_x1-=hýz;
						gemi_x2-=hýz;
						gemi_x3-=hýz;
						gemi_x4-=hýz;
						
						 if(mermi_x1>=0){
								mermi_x1+=2.5;
								}
						
					}
					if(gemi_x1>0){
						if(a==0)gemi_y1++;
						if(a==1)gemi_y1--;
					}
					if(gemi_x2>0){
						if(a==1)gemi_y2++;
						if(a==0)gemi_y2--;
					}
					if(gemi_x3>0){
						if(a==0)gemi_y3++;
						if(a==1)gemi_y3--;
					}
					if(gemi_x4>0){
						if(a==1)gemi_y4++;
						if(a==0)gemi_y4--;
					}
					
					
					}

				
				if(gemi1.intersects(mermi)){
					
					gemi_x1=1500;
					mermi_x1=1500;
					mermiyon2=102;
					puan+=10;
					
				}
               	if(gemi2.intersects(mermi)){
					
        			gemi_x2=gemi_x1+r.nextInt(500)+200;
					gemi_y2=r.nextInt(400)+200;
					mermi_x1=1500;
					mermiyon2=102;
					puan+=18;
				}
	            if(gemi3.intersects(mermi)){
					
	            	gemi_x3=gemi_x2+r.nextInt(500)+200; 
					gemi_y3=r.nextInt(600)+30;
					mermi_x1=1500;
					mermiyon2=102;
					puan+=23;
				}
	            if(gemi4.intersects(mermi)){
					
					gemi_x4=gemi_x3+r.nextInt(500)+200; 
					gemi_y4=r.nextInt(450)+150;
					mermi_x1=1500;
					mermiyon2=102;
					puan+=32;
				}
	

				
						
				if(mermi_x1>1500)
				{
					mermi_x1=1500;
					mermi_y1=150;
					mermi_gen1=120;
					mermi_yuk1=30;
				}
				
				if(gemi_x1<0){ 
					
					gemi_x1=1500;
					gemi_y1=160;
					gemi_gen1=85;
					gemi_yuk1=50;
				}
				if(gemi_x2<0){
					gemi_x2=gemi_x1+r.nextInt(500)+200; 
					gemi_y2=r.nextInt(400)+200;
					gemi_gen2=100;
					gemi_yuk2=60;
				}
				if(gemi_x3<0){
					gemi_x3=gemi_x2+r.nextInt(500)+200; 
					gemi_y3=r.nextInt(600)+30;
					gemi_gen3=100;
					gemi_yuk3=100;
				}
				if(gemi_x4<0){
					gemi_x4=gemi_x3+r.nextInt(500)+200; 
					gemi_y4=r.nextInt(450)+150;
					gemi_gen4=180;
					gemi_yuk4=80;
				}
				
				
				if(mermiyon>0){
					mermiyon++;
					}
				
				if(mermiyon==100){
					
					
					mermi_x1=-50;
					mermiyon=0;
					
					
				}
				else if(mermiyon2==102){
					
					
					mermi_x1=-50;
					mermiyon2=0;					
					
				}
				
				repaint();
				
			}
	
	
	
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			
			player_y-=90;
			
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			
			player_y+=90;
			
			
		}
       if(e.getKeyCode() == KeyEvent.VK_RIGHT){
    	   player_x+=45;
    	   if(player_x == 180){
    		   
    		   player_x=135;
    	   }
    	 
    	   
       }
       if(e.getKeyCode() == KeyEvent.VK_LEFT){
    	   
     	  player_x-=45;
     	 if(player_x == -45){
  		   
  		   player_x=0;
  	   }
     	   
        }
       
		
	
		if (player_y<0){
			player_y=0;
		}
		
		if (player_y>530){
			player_y=530;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			
			ciz++;
			if(mermi_x1<0)
			{
				mermi_x1=player_x+player_gen;
				mermi_y1=player_y;
			
				mermiyon=1;
			}	
				
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	


	

}
