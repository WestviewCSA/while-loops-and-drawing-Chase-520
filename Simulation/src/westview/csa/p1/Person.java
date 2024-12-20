package westview.csa.p1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.ImageIcon;

public class Person {
	
	//static variable to keep track of population
	public static int population =0;
	
	protected int status = 0;
	protected int width = 40, height = 50;
	protected int x, y;							//position of the object
	private int speedX = 3;						//speed in x-dir
	private int speedY = 4;						//speed in y-dir
	
	private int infectTime = 5000; //5000 ms = 5s
	private int deadTime = 10000;
	/*
	 * make the person bounce around the screens
	 */
	
	
	
	public void update() {
		this.x += speedX;
		this.y += speedY;
		
		if(this.x<=0 || this.x >920) {
			speedX *= -1;
		}
		if(this.y<=0||this.y>360) {
			speedY *= -1;
		}
		
		//if sick, count down once reach 0 or less simulate healing or zombie
		if(this.status==4) {
			infectTime -= 20;
			if(infectTime==0) {
				double ran = Math.random();
				if(ran>=.5) {
					this.status=1;
				}
				else if(ran>.1) {
					this.status=5;
				}
				else {
					this.status=2;
					this.speedX=0;
					this.speedY=0;
				}
			}		
		}
		
		//if already dead
		if(this.status==2) {
			deadTime-=20;
			if(deadTime==0) {
				if(Math.random()>.5) {
					this.status=3;
				}
				else {
					this.status=5;
				}
				this.speedX=(int)(Math.random()*5);
				this.speedY=(int)(Math.random()*5);
			}
		}
	}
	
	public boolean colliding(Person otherPerson) {
		//dertermine if this object is colliding with the otherperson object
		Rectangle rMe = new Rectangle(this.x,this.y,width,height);
		Rectangle rYo = new Rectangle(otherPerson.x,otherPerson.y,otherPerson.width,otherPerson.height);
			
		//infection
		if(rMe.intersects(rYo)) {
			//70% chance infection
			if(Math.random()<=.10) {
				if(this.status==4) {
					// if sick
					if(otherPerson.status==0) {
						otherPerson.status=4;
					}
					
				}
				else if(otherPerson.status==4) {
					if(this.status==0) {
						this.status=4;
					}
				}
			}
		}
		return (rMe.intersects(rYo));
		
			
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
	
	//overload the constructor (add another one)
	public Person(int status,int x,int y) {
		//call the default constructor with the this keyword
		this(); //invokes the corresponding constructor
		
		//set the values of the other attributes
		this.status = status;
		this.x=x;
		this.y=y;
		
	}
	
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
		x = (int)(Math.random()*960);
		y = (int)(Math.random()*400);
		
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
