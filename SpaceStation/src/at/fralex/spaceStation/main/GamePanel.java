package at.fralex.spaceStation.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	public static ListnerKeyBoard keyListner = new ListnerKeyBoard();
	Timer timer = new Timer(30, this);
	public static Map map = new Map();
	Player player = new Player();

	public GamePanel() {

		this.setLayout(null);
		this.setFocusable(true);
		this.addKeyListener(keyListner);
		timer.start();

	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLUE);

		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

		

		
		map.drawMap(g2d, this, 0, 0, this.getWidth(), this.getHeight());
		player.drawPlayer(g2d, player.getX(), player.getY());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		player.update();
		this.repaint();

	}

}
