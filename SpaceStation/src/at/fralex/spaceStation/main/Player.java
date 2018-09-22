package at.fralex.spaceStation.main;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player {

	private int[] player = { 200, 200 };
	private int speed = 5;
	private int playerSize = 50;

	public void drawPlayer(Graphics2D g2d, int x, int y) {

		g2d.setColor(Color.ORANGE);
		g2d.fillRect(x, y, playerSize, playerSize);
		// g2d.fillOval(x + width/4, y, width / 4 * 3, height);

	}

	public int getX() {

		return player[0];
	}

	public int getY() {

		return player[1];
	}

	public void update() {

		

		int deltaX = 0, deltaY = 0;

		if (!GamePanel.keyListner.pressed.isEmpty()) {

			for (int i = 0; i < GamePanel.keyListner.pressed.size(); i++) {
				if (GamePanel.keyListner.pressed.contains('d')) {
					deltaX += speed;
				}
				if (GamePanel.keyListner.pressed.contains('a')) {
					deltaX -= speed;
				}
				if (GamePanel.keyListner.pressed.contains('s')) {
					deltaY += speed;
				}
				if (GamePanel.keyListner.pressed.contains('w')) {
					deltaY -= speed;
				}
			}

		}

		if (deltaX < -speed) {
			deltaX = -speed;
		}
		if (deltaX > speed) {
			deltaX = speed;
		}
		if (deltaY < -speed) {
			deltaY = -speed;
		}
		if (deltaY > speed) {
			deltaY = speed;
		}

		player[0] += deltaX;
		player[1] += deltaY;

		player = collision(player);
		// System.out.println("player delta: "+deltaX +"|"+deltaY);
		// System.out.println("player Pos: " + player[0] + "|" + player[1]);

	}

	private int[] collision(int[] playerPos) {

		for (int i = 0; i < GamePanel.map.collision.size(); i++) {
			for (int j = 0; j < GamePanel.map.collision.get(i).length; j++) {

				if (player[0] < GamePanel.map.collision.get(i)[2]
						&& player[1] < GamePanel.map.collision.get(i)[3]
						&& player[0] + playerSize > GamePanel.map.collision.get(i)[0]
						&& player[1] + playerSize > GamePanel.map.collision.get(i)[1]) {

					if (player[0] + playerSize - GamePanel.map.collision.get(i)[0] <= speed) {
						playerPos[0] = playerPos[0] - (player[0] + playerSize - GamePanel.map.collision.get(i)[0]);
					}
					if (GamePanel.map.collision.get(i)[3] - player[1] <= speed) {
						playerPos[1] = playerPos[1] + (GamePanel.map.collision.get(i)[3] - player[1]);
					}

					if (player[1] + playerSize - GamePanel.map.collision.get(i)[1] <= speed) {
						playerPos[1] = playerPos[1] - (player[1] + playerSize - GamePanel.map.collision.get(i)[1]);
					}
					if (GamePanel.map.collision.get(i)[2] - player[0] <= speed) {
						playerPos[0] = playerPos[0] + (GamePanel.map.collision.get(i)[2] - player[0]);
					}

				}

			}
		}

		return playerPos;
	}

}
