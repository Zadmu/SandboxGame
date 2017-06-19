package main.level;

import main.Camera;
import main.Renderer;

public class CameraEntity extends Entity{
	
	private Camera camera;
	private Player player;
	
	public CameraEntity(){
		camera = new Camera(-8.0f, 8.0f, -4.5f, 4.5f);
		Renderer.setCamera(camera);
	}
	
	protected void init(){
		player = level.findEntity(Player.class);
	}
	
	public void update(){
		camera.setPosition(player.getPlayerPosition());
	}
	
	public Camera getCamera() {
		return camera;
	}
	
}
