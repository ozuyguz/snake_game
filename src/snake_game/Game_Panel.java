package snake_game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent; 

import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.Iterator;
import java.util.Random; //An instance of this class is used to generate a stream of pseudorandom numbers.


public class Game_Panel extends JPanel implements ActionListener{
	
	static final int Screen_width = 600;
	static final int Screen_height = 600;
	static final int Unit_size = 25;
	static final int Game_units = (Screen_width*Screen_height)/Unit_size;
	static final int Delay = 75;
	
	// arrays -> these arrays are going to hold all of the coordinatees for all the body parts of our snake including the head of the snake 
	 
	final int x[] = new int[Game_units]; // cannot be bigger than game itself and that is x for coordinates
	final int y[] = new int[Game_units]; // that is for y coordinates
	
	int bodyParts = 6; // initial body parts of snake
	int applesEaten;
	int appleX; //x coordinates of apple
	int appleY; // y coordinates of apple
	char direction = 'R'; // right => snake begin by going right
	boolean running = false;
	Timer timer;
	Random random;
	
	
	Game_Panel(){ // constructor 
		random = new Random();
		this.setPreferredSize(new Dimension(Screen_width, Screen_height)); // size of panel
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter()); 
		startGame(); // when we finish constructing this game panel => call startGame method 
		
		
	}
	
	public void startGame() {
		
		newApple(); // call newApple method
		running = true;
		timer = new Timer(Delay, this); 
		timer.start();
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		draw(g);		
	}
	
	public void draw(Graphics g) {
		
		for(int i=0; i < Screen_height/Unit_size; i++) {
			
			g.drawLine(i*Unit_size, 0, i*Unit_size, Screen_height);
			g.drawLine(0, i*Unit_size, Screen_width, i*Unit_size);
		}
			g.setColor(Color.red); // these two lines for drawing apple
			g.fillOval(appleX, appleY, Unit_size, Unit_size);
			
			
			for(int i = 0; i<bodyParts; i++) {
				if(i==0) {
					g.setColor(Color.black); // head of snake
					g.fillRect(x[i], y[i], Unit_size, Unit_size);
				} 
				else {
					g.setColor(new Color(53, 255, 13)); // different shade of green
					g.fillRect(x[i], y[i], Unit_size, Unit_size);
				}
			}
	}
	
	public void newApple() {
		
		appleX = random.nextInt((int)(Screen_width/Unit_size))*Unit_size; // Screen_width/Unit_size -> range
		appleY = random.nextInt((int)(Screen_height/Unit_size))*Unit_size; // Multiply this by the unit size because we want this Apple to be placed evenly within one of these item spots 
	
	}
	
	public void move() {
		
		for(int i = bodyParts;i>0;i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(direction) {
		case 'U':
			y[0] = y[0] - Unit_size;
			break;
		case 'D':
			y[0] = y[0] + Unit_size;
			break;
		case 'L':
			x[0] = x[0] - Unit_size;
			break;
		case 'R':
			x[0] = x[0] + Unit_size;
			break;
		}
		
	}
	
	public void checkApple() {
		
	}
	
	public void checkCollisions() {
		
	}
	
	public void gameOver(Graphics g) {
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if (running) {
			move();
			checkApple();
			checkCollisions();
		} 
		 
		 repaint(); //if this no longer running we are going to call the repaing method
			
		
	}
	
	
	public class MyKeyAdapter extends KeyAdapter { //inner class
		@Override 
		public void keyPressed(KeyEvent e) { // invoked when a key has been pressed 
			
		}
		
	}

}
