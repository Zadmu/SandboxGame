package main;

import static org.lwjgl.opengl.GL11.*;

import maths.Matrix4f;
import maths.Vector3f;
import maths.Vector4f;

public class Renderer {

	private static Shader shader;
	private static IndexBuffer rectangleIBO;
	private static float time = 0.0f;
	
	private static Camera camera;
	
	public static void init(){
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
		
		rectangleIBO = new IndexBuffer(indices);
		rectangleIBO.bind();
		
		Texture texture = new Texture("res/textures/wall.png");
		texture.bind();
		
		shader = new Shader("res/shaders/Basic.vert", "res/shaders/Basic.frag");
		shader.bind();
		
		shader.setUniform1i("tex", 0);
		shader.setUniform4f("u_Color", new Vector4f(Vector4f.FromRGB(150, 235, 122)));
	}
	
	public static void clear(){
		glClear(GL_COLOR_BUFFER_BIT);
	}
	
	public static void setClearColor(float r, float g, float b, float a){
		glClearColor(r, g, b, a);
	}		
	
	public static void setClearColor(Vector4f color){
		glClearColor(color.x, color.y, color.z, color.w);
	}	
	
	public static void setCamera(Camera camera){
		Renderer.camera = camera;
	}
	
	public static void fillRect(float x, float y, float width, float height, float angle, Vector4f color){
		float r = angle * ((float)Math.PI / 180.0f);
		
		Matrix4f translation = Matrix4f.translate(new Vector3f(x, y ,0));
		Matrix4f rotation = Matrix4f.rotate(r, new Vector3f(0 , 0, 1));
		Matrix4f scale = Matrix4f.scale(new Vector3f(width, height, 1));
		Matrix4f transform = translation.multiply(rotation).multiply(scale);
		
		Matrix4f projection = camera.getProjectionMatrix();
		Matrix4f view = camera.getViewMatrix();
		Matrix4f mvp = projection.multiply(view).multiply(transform);
		shader.setUniformMatrix4f("u_ModelViewProjectionMatrix", mvp);
		shader.setUniform4f("u_Color", color);
		rectangleIBO.draw();
	}
	
	public static void flush(){
		time += 0.01f;
		shader.setUniform1f("time", time);
	}
	
	public static float getTime(){
		return time;
	}
	
}
