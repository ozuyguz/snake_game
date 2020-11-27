package snake_game;

import javax.swing.JFrame; 

public class Game_Frame extends JFrame {
	 
	Game_Frame(){ // constructor
		
		Game_Panel panel = new Game_Panel();
		
		this.add(panel);
		this.setTitle("Snake Game");
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack(); // it is going to take our jframe and fit it snugly around all of the components that we add to the jframe 
		this.setVisible(true); 
		this.setLocationRelativeTo(null); //window appear middle of our computer
		
		
	}

}
