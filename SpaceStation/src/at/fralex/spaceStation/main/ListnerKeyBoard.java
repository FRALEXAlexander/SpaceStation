package at.fralex.spaceStation.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class ListnerKeyBoard implements KeyListener{

	
	public final Set<Character> pressed = new HashSet<Character>();
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		 pressed.add(e.getKeyChar());
		 
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		pressed.remove(e.getKeyChar());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
