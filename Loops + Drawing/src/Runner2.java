import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Runner2 extends JPanel{
	
	// Practice using Loops, random #s and 
	// methods
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1));
		Color color1 = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		
		//h = 600, w = 800
		int h = 600;
		int w = 800;
		int space = 10;
		
		
		// top left
		int counter1 = 1;
		while(counter1<=h/space) {
			

			g2.drawLine(0, (counter1-1)*space,(counter1-1)*space, h);
			counter1 += 1;
		}
		
		//bottom left
		int counter2 = 0;
		while(counter2 < h/space) {
			
			g2.drawLine(0, h-(counter2)*space,(counter2)*space, 0);
			counter2 += 1;
		}
		
		//top right
		for(int i = 0; i<h/space;i++) {
			
			g2.drawLine(w, i*space, w-i*space, h);
		}
		
		//bottom right
		for(int i = 0; i<h/space;i++) {
			
			g2.drawLine(w, h - i*space, w-i*space, 0);
		}
		
		 
		//test comment

	
	
	}
	
	
	
	public static void main(String[] arg){
		Runner2 m = new Runner2();
	}
	
	public Runner2() {
		JFrame f = new JFrame("Method Use");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800,600);
		f.add(this);
		f.setVisible(true);
		
	}
}
