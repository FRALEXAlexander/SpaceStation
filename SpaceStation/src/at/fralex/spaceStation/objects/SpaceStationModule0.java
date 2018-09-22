package at.fralex.spaceStation.objects;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import at.fralex.spaceStation.main.Map;
import at.fralex.spaceStation.main.Objects;

public class SpaceStationModule0 extends Objects {

	private int[][] collission = { { 170, 20, 210, 30 }, { 200, 30, 220, 40 }, { 210, 40, 230, 50 },
			{ 220, 50, 240, 60 }, { 230, 60, 250, 70 }, { 240, 70, 250, 100 }, { 240, 170, 250, 210 },
			{ 230, 200, 240, 220 }, { 220, 210, 230, 230 }, { 210, 220, 220, 240 }, { 200, 230, 210, 250 },
			{ 170, 240, 200, 250 }, { 70, 240, 100, 250 }, { 60, 230, 70, 250 }, { 50, 220, 60, 240 },
			{ 40, 210, 50, 230 }, { 30, 200, 40, 220 }, { 20, 170, 30, 210 }, { 20, 60, 30, 100 }, { 30, 50, 40, 70 },
			{ 40, 40, 50, 60 }, { 50, 30, 60, 50 }, { 60, 20, 70, 40 }, { 60, 20, 100, 30 } };
	private int[][] changeableCollision = { { 90, 0, 180, 20 }, { 250, 90, 270, 180 }, { 90, 250, 180, 270 },
			{ 0, 90, 20, 180 }, };
	private boolean[] openSides = { false, false, false, false };
	public String GraphicName = "SpaceStationModule0.png";

	public SpaceStationModule0(Map map, int x, int y) {
		super(map);
		posX = x;
		posY = y;
		addCollission(collission);
		addCollission(changeableCollision);
	}

	public void changeConnection(String connection, boolean isConnected) {

		switch (connection) {
		case "top":
			if (isConnected && !openSides[0]) {
				removeCollission(changeableCollision[0]);
				openSides[0] = true;
			} else if (!isConnected && openSides[0]) {
				addCollission(changeableCollision[0]);
			}

			break;
		case "right":
			if (isConnected && !openSides[1]) {
				removeCollission(changeableCollision[1]);
				openSides[1] = true;
			} else if (!isConnected && openSides[1]) {
				addCollission(changeableCollision[1]);
				openSides[1] = false;
			}
			break;

		case "bottom":
			if (isConnected && !openSides[2]) {
				removeCollission(changeableCollision[2]);
				openSides[2] = true;
			} else if (!isConnected && openSides[2]) {
				addCollission(changeableCollision[2]);
				openSides[1] = false;
			}
			break;

		case "left":
			if (isConnected && !openSides[3]) {
				removeCollission(changeableCollision[3]);
				openSides[3] = true;
			} else if (!isConnected && openSides[3]) {
				addCollission(changeableCollision[3]);
				openSides[1] = false;
			}
			break;

		default:
			break;
		}
	}

	public void draw(Graphics2D g2d) {

		GraphicName = setGraphic("SpaceStationModule0", openSides);

		try {
			g2d.drawImage(ImageIO.read(new File("res/SpaceStationModule0/" + GraphicName)), posX, posY, iob);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
