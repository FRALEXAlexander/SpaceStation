package at.fralex.spaceStation.main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

public class Objects {

	protected int posX;
	protected int posY;
	protected ImageObserver iob;
	protected Map map;

	public Objects(Map Map) {
		map = Map;
	}

	protected void addCollission(int[][] collission) {
		System.out.println(collission[0][0]);
		for (int i = 0; i < collission.length; i++) {
			for (int j = 0; j < collission[i].length; j++) {
				int correction = 0;

				if (j % 2 == 0) {
					correction = posX;
				} else {
					correction = posY;
				}

				collission[i][j] = collission[i][j] + correction;
			}
			System.out.println(
					collission[i][0] + "|" + collission[i][1] + "|" + collission[i][2] + "|" + collission[i][3]);
			map.collision.add(collission[i]);
		}
	}

	protected void addCollission(int[] collission) {
		
		for (int i = 0; i < collission.length; i++) {

			int correction = 0;

			if (i % 2 == 0) {
				correction = posX;
			} else {
				correction = posY;
			}

			collission[i] = collission[i] + correction;
		}
			
		map.collision.add(collission);

	}

	protected void removeCollission(int[] collission) {
		map.collision.remove(collission);

	}

	protected void drawCollision(Graphics2D g2d, int[][] collission) {
		g2d.setColor(Color.RED);
		for (int i = 0; i < collission.length; i++) {

			g2d.fillRect(collission[i][0], collission[i][1], collission[i][2] - collission[i][0],
					collission[i][3] - collission[i][1]);
			;
		}
	}

	protected String setGraphic(String objectName, boolean[] openSides) {
		String graphic = objectName + "_";
		if (openSides.length == 4) {
			if (openSides[0]) {

				graphic += "Top";
			}
			if (openSides[1]) {

				graphic += "Right";
			}
			if (openSides[2]) {

				graphic += "Bottom";
			}
			if (openSides[3]) {

				graphic += "Left";
			}
		}
		
		
		return graphic + ".png";
	}
}
