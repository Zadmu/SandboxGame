package main;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

public class VertexBuffer {

	private int id;
	
	public VertexBuffer(float[] data){
		init(data);
	}
	
	private void init(float[] data){
		id = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, id);
		glBufferData(GL_ARRAY_BUFFER, data, GL_STATIC_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}
	
	public void setAttribute(int index, int count, int type, int stride, int offset){
		glEnableVertexAttribArray(index);
		glVertexAttribPointer(index, count, type, false, stride, offset);
	}
	
	public void bind(){
		glBindBuffer(GL_ARRAY_BUFFER, id);
	}
	
	public void unbind(){
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}
	
}
