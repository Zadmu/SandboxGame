package main;

import static org.lwjgl.opengl.GL11.*;

import maths.Vector4f;

public class Renderer {

	public static void clear(){
		glClear(GL_COLOR_BUFFER_BIT);
	}
	
	public static void setClearColor(float r, float g, float b, float a){
		glClearColor(r, g, b, a);
	}		
	
	public static void setClearColor(Vector4f color){
		glClearColor(color.x, color.y, color.z, color.w);
	}	
	
}
