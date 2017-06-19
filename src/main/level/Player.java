package main.level;

import org.lwjgl.glfw.GLFW;

import main.Renderer;
import main.Window;
import main.level.component.TransformComponent;
import maths.Matrix4f;
import maths.Vector3f;
import maths.Vector4f;

public class Player extends Entity{

	private float speed = 0.2f;
	
	private Matrix4f transform;
	
	public Player() {
	}
	
	protected void init(){
		transform = Matrix4f.identity();
		add(new TransformComponent(transform));
	}
	
	public void update() {
		Window window = Window.getInstance();
		Vector3f position = transform.getTranslation();
		
		if(window.isKeyPressed(GLFW.GLFW_KEY_RIGHT))
			position.x += speed;
		else if (window.isKeyPressed(GLFW.GLFW_KEY_LEFT))
			position.x -= speed;
		
		if(window.isKeyPressed(GLFW.GLFW_KEY_UP))
			position.y += speed;
		else if (window.isKeyPressed(GLFW.GLFW_KEY_DOWN))
			position.y -= speed;
		
		transform.setTranslation(position);
	}
	
	public Vector3f getPlayerPosition(){
		return transform.getTranslation();
	}
	
	public void render() {
		Vector3f position = transform.getTranslation();
		Renderer.fillRect(position.x, position.y, 2, 2, 0, Vector4f.FromRGB(255, 255, 255));
	}
	
}
