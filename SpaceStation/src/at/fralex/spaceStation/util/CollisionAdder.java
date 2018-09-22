package at.fralex.spaceStation.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class CollisionAdder {

	static BufferedImage image;
	static ArrayList<int[]> collisionRaw = new ArrayList<int[]>();
	static ArrayList<int[][]> collisionEnd = new ArrayList<int[][]>();

	public static void main(String[] args) {

		try {
			image = ImageIO.read(new File("res/SpaceStationModule0/SpaceStationModule0_Left.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		for (int i = 0; i < image.getHeight(); i++) {

			for (int j = 0; j < image.getWidth(); j++) {
				int[] c = getRGBArray(image, i, j);

				if (c[0] == 64 && c[1] == 64 && c[2] == 64 && c[3] == 255) {
					int[] point = { i, j };
					collisionRaw.add(point);
				}

				// System.out.println(c[0] + " " + c[1] + " " + c[2] + " " + c[3]);

			}

		}
		int[] temp = new int[image.getWidth()];
		int lineTemp = 0;
		int rowTemp = 0;
		int indexTemp = 0;
		for (int i = 0; i < collisionRaw.size(); i++) {

			// System.out.println(collisionRaw.get(i)[0] + " " + collisionRaw.get(i)[1]);

			if (collisionRaw.get(i)[0] == lineTemp) {

				if (collisionRaw.get(i)[1] == rowTemp + 1) {
					temp[indexTemp] = collisionRaw.get(i)[1];
					rowTemp++;
				} else {
					rowTemp = collisionRaw.get(i)[1];
					temp[indexTemp] = collisionRaw.get(i)[1];

				}

				indexTemp++;

			} else {
				//printArray(temp);

				int[] t = null;

				for (int j = 0; j < temp.length; j++) {
					if (temp[j] == 0) {
						t = new int[j];
						break;
					}
				}
				
				
				for (int j = 0; j < t.length; j++) {
					
						t[j] = temp[j];
					
				}
				
				//printArray(t);
				

				int[][] newPoint = new int[2][];
				newPoint[0] = new int[1];
				newPoint[1] = new int[t.length];
				newPoint[0][0] = lineTemp;
				for (int j = 0; j < t.length; j++) {
					newPoint[1][j] = t[j];
				}

				collisionEnd.add(newPoint);
				
				printArray(collisionEnd);
				
				indexTemp = 0;
				lineTemp = collisionRaw.get(i)[0];
			}

		}

	}

	private static void printArray(ArrayList<int[][]> temp) {

		for (int i = 0; i < temp.size(); i++) {
			System.out.print(temp.get(i)[0][0]+":");
			for (int j = 0; j < temp.get(i)[1].length; j++) {
				System.out.print(" "+temp.get(i)[1][j] );
			}
			System.out.println();
		}
		

	}

	private static void printArray(int[] temp) {

		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();

	}

	public static int[] getRGBArray(BufferedImage image, int x, int y) {

		int p = image.getRGB(x, y);

		int[] color = new int[4];

		// get alpha
		color[3] = (p >> 24) & 0xff;

		// get red
		color[0] = (p >> 16) & 0xff;

		// get green
		color[1] = (p >> 8) & 0xff;

		// get blue
		color[2] = p & 0xff;

		return color;

	}

}
