package westview.csa.p1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
import javax.swing.ImageIcon;

public class Person {
	
	//static variable to keep track of population
	public static int population =0;
	
	protected int status = 6;
	protected int width = 40, height = 50;
	protected int x, y;							//position of the object
	private int speedX = 3;						//speed in x-dir
	private int speedY = 4;						//speed in y-dir
	
	/*
	 * make the person bounce around the screens
	 */
	
	
	
	public void update() {
		this.x += speedX;
		this.y += speedY;
		
		if(this.x<=0 || this.x >=600) {
			speedX *= -1;
		}
		if(this.y<=0||this.y>=300) {
			speedY *= -1;
		}
		
	}
	
	public boolean colliding(Person otherPerson) {
		return false;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		update();
		switch(status) {
			case 0:
				img = healthy;
				break;
			case 1:
				img = recovered;
				break;
			case 2: 
				img = dead;
				break;
			case 3:
				img = ghost;
				break;
			case 4:
				img = sick;
				break;
			case 5:
				img = zombie;
		}
		init(x,y);
		g2.drawImage( img,  tx,  null);
 	}

	/*
	 * Not used in this lab but needed
	 * 
	 */
	private AffineTransform tx;
	private Image healthy, recovered, dead, ghost, sick, zombie, img; 	

	public Person() {
		
		// increment population because an object is being created!
		this.population++;
		
		healthy 	= getImage("/images/"+"Healthy.png");    
		recovered 	= getImage("/images/"+"Recovered.png");  
		dead 		= getImage("/images/"+"Dead.png");  
		ghost 		= getImage("/images/"+"Ghost.png");  
		sick 		= getImage("/images/"+"Sick.png");  
		zombie 		= getImage("/images/"+"Zombie.png");  
		
		img = healthy;
		
		//alter these
		x = (int)(Math.random()*400);
		y = (int)(Math.random()*600);
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		
		init(x, y); 				//initialize the location of the image
									//use your variables
		
	}
	
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(width/122.0, height/161.0);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Person.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
