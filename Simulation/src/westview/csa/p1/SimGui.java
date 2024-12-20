package westview.csa.p1;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class SimGui extends JPanel implements ActionListener, MouseListener{
	/* change these two numbers to alter the size of the JFrame */
	private int screenWidth = 960;		 
	private int screenHeight = 400;
	private int numOfPeople = 200;
	//Person p = new Person();
	Background bg = new Background();
	
	// collection of person objects 1d array
	int maxPopulation = 1000;
	Person[] people = new Person[maxPopulation];
	
	
	
	public void paint(Graphics g) {
		 super.paintComponent(g);
		 bg.paint(g);
		 //p.paint(g);
		 
		 /*
		  * use an enhanced for-loop to visit all the objects
		  * and call their paint method
		  */
		
		 System.out.println(Person.population);
		 for(int i=0;i<Person.population-1;i++) {
			 people[i].paint(g);
			 
		 }
		 //nested loop
		 for(int i=0;i<Person.population;i++) {
			 for(int j=i+1;j<Person.population;j++) {
				 if(people[i].colliding(people[j])) {
					 System.out.println("Colliding");
				 }
			 }
		 }
	}
	
	
	
	/**
	 * The code below sets up the GUI. Not required to change.
	 */
	//Constructor for the GUI class
	Timer animationTimer; //animation timer
	public SimGui() {
		
		// setup the people array
		for(int i=0;i<this.numOfPeople;i++) {
			people[i] = new Person();
		}
		
		
		
		JFrame frame = new JFrame("Simulation");
		frame.setSize(screenWidth, screenHeight);
		
		animationTimer = new Timer(16, this);
		frame.add(this);
		frame.addMouseListener(this);
		animationTimer.start();
		
		//center the jframe
		frame.setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - screenWidth/2),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2 - screenHeight/2) );
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		// Run the GUI program
		new SimGui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("clicked");
		
		//add one sick person
		//1) create a person object
		//2)add it to the people array
		Person p = new Person(4,e.getX(),e.getY());
		people[Person.population-1] = p;
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
