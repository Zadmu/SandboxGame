package main;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.glfw.GLFWWindowSizeCallbackI;
import org.lwjgl.opengl.GL;

public class Window {

	private String title;
	private int width, height;
	
	private long handle;
	
	public Window(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		init();
	}
	
	private void init(){
		if (!glfwInit())
			System.err.println("Failed to initialize GLFW");
		
		handle = glfwCreateWindow(width, height, title, NULL, NULL);
		if (handle == NULL)
			System.err.println("Failed to create window");
		
		glfwSetWindowSizeCallback(handle, new GLFWWindowSizeCallbackI() {
			
			@Override
			public void invoke(long window, int width, int height) {
				glViewport(0, 0, width, height);
			}
		});
		
		glfwMakeContextCurrent(handle);
		glfwShowWindow(handle);
		
		GL.createCapabilities();
		System.out.println("OpenGL: " + glGetString(GL_VERSION));
	}
	
	public boolean closed(){
		return glfwWindowShouldClose(handle);
	}
	
	public void update(){
		glfwSwapBuffers(handle);
		glfwPollEvents();
	}
	
}
