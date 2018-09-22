package at.fralex.spaceStation.main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import at.fralex.spaceStation.objects.SpaceStationModule0;

public class Map {
	
	public ArrayList<int[]> collision = new ArrayList<int[]>() ;
	public ArrayList<Objects> objects = new ArrayList<Objects>();
	
	public SpaceStationModule0 m0 = new SpaceStationModule0(this, 100, 100);
	public SpaceStationModule0 m1 = new SpaceStationModule0(this, 370, 100);
	
	public Map() {
		
		
		
		m1.changeConnection("left", true);
	}
	
	

	public void drawMap(Graphics2D g2d,ImageObserver iob, int x, int y, int width, int height) {
		
		
		
		m0.draw(g2d);
		m1.draw(g2d);
		
	}



	
}
