package main;

import static org.lwjgl.opengl.GL11.*;

import maths.Matrix4f;
import maths.Vector3f;
import maths.Vector4f;

public class Main {

	private Window window;
	
	public Main() {
		
		Vector3f a = new Vector3f(2.0f);
		Vector3f b = new Vector3f(1, 2, 3);
		
		b.multiply(a);
		System.out.println(b);
	}
	
	private void run() {
		window = new Window("Sandbox", 960, 540);
		
		float[] vertices = new float[] {   // short 2 bytes, float integer 4 bytes, long double 8 bytes
				-0.5f, -0.5f, 0.0f, 0, 1,
				-0.5f, 0.5f, 0.0f, 0, 0,
				0.5f, 0.5f, 0.0f, 1, 0,
				0.5f, -0.5f, 0.0f, 1, 1
		};
		
		short [] indices = new short[] {
			0,1,2,
			2,3,0
		};
			
		VertexBuffer vbo = new VertexBuffer(vertices);
		vbo.bind();
		vbo.setAttribute(0, 3, GL_FLOAT, 5 * 4, 0);
		vbo.setAttribute(1, 2, GL_FLOAT, 5 * 4, 3 * 4);
		
		IndexBuffer ibo = new IndexBuffer(indices);
		ibo.bind();
		
		Texture texture = new Texture("res/textures/wall.png");
		texture.bind();
		
		Shader shader = new Shader("res/shaders/Basic.vert", "res/shaders/Basic.frag");
		shader.bind();
		
		shader.setUniform1i("tex", 0);
		shader.setUniform4f("u_Color", new Vector4f(Vector4f.FromRGB(150, 235, 122)));
		
		Matrix4f projection = Matrix4f.orthographic(-8.0f, 8.0f, -4.5f, 4.5f, -1, 1);
		
		float time = 0.0f;
		
		while (!window.closed()) {
			time += 0.01f;
			
			Matrix4f transform = Matrix4f.translate(new Vector3f(7.5f * (float)Math.sin(time), 4.0f * (float)Math.cos(time), 0));
			Matrix4f mvp = Matrix4f.identity().multiply(projection).multiply(transform);
			shader.setUniformMatrix4f("u_ModelViewProjectionMatrix", mvp);
			
			Renderer.setClearColor(Vector4f.FromRGB(253, 182, 032));
			Renderer.clear();
			
			shader.setUniform1f("time", time);
			//All rendering goes here
			ibo.draw();
			
			window.update();
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();

	}

}
