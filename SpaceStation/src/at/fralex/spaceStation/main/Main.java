package at.fralex.spaceStation.main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	
	public static GamePanel gamePanel = new GamePanel();
	
	public static void main(String[] args) {
		
		JFrame mainFrame = new JFrame();
		
		
		
		
		
		mainFrame.add(gamePanel);
		
		
		mainFrame.setSize(new Dimension(800,800));
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
