package main;

import static org.lwjgl.opengl.GL11.*;

public class Renderer {

	public static void clear(){
		glClear(GL_COLOR_BUFFER_BIT);
	}
	
	public static void setClearColor(float r, float g, float b, float a){
		glClearColor(r, g, b, a);
	}	
}
