package main;

import org.lwjgl.glfw.GLFW;

import maths.Vector3f;
import maths.Vector4f;

public class Main {

	private Window window;
	private Camera camera;
	private Vector3f position = new Vector3f();
	private float speed = 0.2f;
	
	private void update(){
		if(window.isKeyPressed(GLFW.GLFW_KEY_RIGHT))
			position.x += speed;
		else if (window.isKeyPressed(GLFW.GLFW_KEY_LEFT))
			position.x -= speed;
		
		if(window.isKeyPressed(GLFW.GLFW_KEY_UP))
			position.y += speed;
		else if (window.isKeyPressed(GLFW.GLFW_KEY_DOWN))
			position.y -= speed;
		
		camera.setPosition(position);
		
	}
	
	private void render(){
		Renderer.setClearColor(Vector4f.FromRGB(150, 235, 122));
		Renderer.clear();

		float time = Renderer.getTime();
		Renderer.fillRect(7.5f * (float)Math.sin(time), 4.0f * (float)Math.cos(time), 1, 1, 0.0f,Vector4f.FromRGB(255, 235, 122));
		//Renderer.fillRect(4.0f, 0.0f, 2, 2, time * 100.0f, Vector4f.FromRGB(255, 0, 255));
		Renderer.fillRect(0.0f, -2.0f, 2, 2, 45.0f, Vector4f.FromRGB(242, 15, 15));
		Renderer.fillRect(0.0f, -4.0f, 2.5f, 4.0f, 0.0f, Vector4f.FromRGB(194, 163, 27));
		Renderer.fillRect(0.0f, -4.0f, 1f, 2.0f, 0.0f, Vector4f.FromRGB(239, 153, 27));
		
		Renderer.flush();
	}
	public Main() {
	}

	private void run() {
		window = new Window("Sandbox", 960, 540);
		Renderer.init();
		camera = new Camera(-8.0f, 8.0f, -4.5f, 4.5f);
		Renderer.setCamera(camera);
		
		while (!window.closed()) {
			
			update();
			render();
			
			window.update();
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();

	}

}
