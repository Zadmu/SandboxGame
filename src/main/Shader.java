package main;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

import java.util.HashMap;
import java.util.Map;

import maths.Matrix4f;
import maths.Vector2f;
import maths.Vector3f;
import maths.Vector4f;

public class Shader {
	
	private int shaderID;
	private Map<String, Integer> locationCache = new HashMap<String, Integer>();

	public Shader(String vertexPath, String fragmentPath) {
		String vertexSrc = FileUtils.readFile(vertexPath);
		String fragmentSrc = FileUtils.readFile(fragmentPath);
		
		shaderID = compile(vertexSrc, fragmentSrc);
		if (shaderID == -1)
			System.err.println("Failed to create shader!");
	}

	private int compile(String vertexSrc, String fragmentSrc) {
		int program = glCreateProgram();
		int vertex = glCreateShader(GL_VERTEX_SHADER);
		int fragment = glCreateShader(GL_FRAGMENT_SHADER);

		glShaderSource(vertex, vertexSrc);
		glCompileShader(vertex);
		if (glGetShaderi(vertex, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Failed to compile vertex shader!");
			System.err.println(glGetShaderInfoLog(vertex));
			glDeleteShader(vertex);
			return -1;
		}
		
		glShaderSource(fragment, fragmentSrc);
		glCompileShader(fragment);
		if (glGetShaderi(fragment, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Failed to compile fragment shader!");
			System.err.println(glGetShaderInfoLog(fragment));
			glDeleteShader(fragment);
			return -1;
		}
		
		glAttachShader(program, vertex);
		glAttachShader(program, fragment);
		glLinkProgram(program);
		glValidateProgram(program);
		
		glDeleteShader(vertex);
		glDeleteShader(fragment);
		
		return program;
	}

	public void bind(){
		glUseProgram(shaderID);
	}
	
	public void unbind(){
		glUseProgram(0);
	}

	public int getID() {
		return 0;
	}
	
	private int getUniformLocation(String name){
		if (locationCache.containsKey(name))
			return locationCache.get(name);
		
		int location = glGetUniformLocation(shaderID, name);
		if (location == -1)
			System.err.println("Could not find the uniform name '" + name + "'!");
		locationCache.put(name, location);
		return location;
	}
	
	public void setUniform1i(String name, int value){
		glUniform1i(getUniformLocation(name),value);
	}
	
	public void setUniform1f(String name, float value){
		glUniform1f(getUniformLocation(name),value);
	}
	
	public void setUniform2f(String name, Vector2f value){
		glUniform2f(getUniformLocation(name), value.x, value.y);
	}
	
	public void setUniform3f(String name, Vector3f value){
		glUniform3f(getUniformLocation(name), value.x, value.y, value.z);
	}
	
	public void setUniform4f(String name, Vector4f value){
		glUniform4f(getUniformLocation(name), value.x, value.y, value.z, value.w);
	}
	
	public void setUniformMatrix4f(String name, Matrix4f value){
		glUniformMatrix4fv(getUniformLocation(name), true, value.elements);
	}
	
}
