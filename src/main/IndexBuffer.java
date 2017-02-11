package main;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

public class IndexBuffer {
	
	private int id;
	private int count;
	
	public IndexBuffer(short[] indices){
		init(indices);
	}
	
	private void init(short[] indices){
		id = glGenBuffers();
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, id);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices, GL_STATIC_DRAW);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
		
		count = indices.length;
	}
	
	public void bind(){
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, id);
	}
	
	public void unbind(){
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
	}
	
	public void draw(){
		draw(count);
	}
	
	public void draw(int count){
		glDrawElements(GL_TRIANGLES, count, GL_UNSIGNED_SHORT, 0); //draw call
	}
	
}