package main.level;

import java.util.Random;

import main.Renderer;
import maths.Vector3f;
import maths.Vector4f;

public class LevelController extends Entity{

	private int width, height;
	private int[] tiles;
	
	private float tileSize = 1.0f;
	private CameraEntity camera;
	
	public LevelController(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	protected void init(){	
		tiles = new int[width * height];
		Random random = new Random();
		for (int i = 0; i < width * height; i++) {
			tiles[i] = random.nextInt();
		}
		
		camera = level.findEntity(CameraEntity.class);
	}
	
	public void update() {
	}
	
	public void render() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				float xPos = x * tileSize;
				float yPos = y * tileSize;
				Renderer.fillRect(xPos, yPos, tileSize, tileSize, 0.0f, Vector4f.FromRGB(tiles[x + y * width]));
			}
		}
	}
}
