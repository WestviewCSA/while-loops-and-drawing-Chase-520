import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Runner extends JPanel{
	
	// Practice using Loops, random #s and 
	// methods
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        
		 
		//1) draw a concentric rectangle that's 10pixels from all sides of the "gray"
		//portion of the GUI
		g2.drawRect(10, 10, 765, 540);
		
		
		//2) Draw a horizontal line to bisect the Rectangle
		g2.drawLine(10, 270, 775, 270);
		
		
		//3) Draw a vertical line to bisect the shape again
		g2.drawLine(765/2, 10, 765/2,550 );
		
		
		//4) small rectangles on top-left
		//g2.drawLine(765/4, 10, 765/4, 550/2-10);
			
		/* 
		 * int var = 0; 						<---- control variable
		 * while(var < 10){ 					<---- condition to run the loop
		 *   
		 *   //any repeating code
		 *   
		 *   var++;								<---- update control variable
		 *   
		 * }
		 */
		
		int var = 0;
		while(var<100) {
			int r1 = (int)(Math.random()*255);
			int g1 = (int)(Math.random()*255);
			int b1 = (int)(Math.random()*255);
			Color newcolor = new Color(r1,g1,b1);
			g2.setColor(newcolor);
			//bottom right
			g2.drawLine((int)(Math.random()*(765/2)+765/2+10), (int)(Math.random()*(270)+280), (int)(Math.random()*(765/2)+765/2+10), (int)(Math.random()*(270)+280));
			
			//bottom left
			//int side = (int)(Math.random()*20+25);
			int side = 50;
			g2.fillRect((int)(10 + Math.random()*(765/2-side-10)), (int)(280+Math.random()*(270-side)), side, side);
			
			// top right
			int radius = (int)(Math.random()*200);
			g2.drawOval((765/2) + (int)(Math.random()*(765/2-radius)), 10 + (int)(Math.random()*(270-radius-10)), radius, radius);
			
			var++;
		}
		
		//top left
		int del_x = 50;
		int del_y = 50;
		int width = 100;
		int tlx =  70;
		int trx = tlx + width;
		Color color1 = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		g2.setColor(color1);
		g2.fillRect(tlx, 50, width, width);
		
		Color color2 = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		g2.setColor(color2);
		Polygon parra1 = new Polygon();
		parra1.addPoint(tlx, 50);
		parra1.addPoint(tlx, 50+ width);
		parra1.addPoint(tlx+del_x, 50+ width + del_y);
		parra1.addPoint(tlx+del_x, 50 + del_y);
		g2.fillPolygon(parra1);
		
		Color color3 = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		g2.setColor(color3);
		Polygon parra2 = new Polygon();
		parra2.addPoint(trx, 50);
		parra2.addPoint(trx, 50+ width);
		parra2.addPoint(trx+del_x, 50+ width + del_y);
		parra2.addPoint(trx+del_x, 50 + del_y);
		g2.fillPolygon(parra2);
		
		
		
		Color color4 = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		g2.setColor(color4);
		g2.fillRect(tlx+del_x, 50+del_y, width, width);
		
		
		
		 

	
	
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] arg) {
		Runner m = new Runner();
	}
	
	public Runner() {
		JFrame f = new JFrame("Method Use");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800,600);
		f.add(this);
		f.setVisible(true);
		
	}
}
