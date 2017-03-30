package main;

import maths.Matrix4f;
import maths.Vector3f;

public class Camera {

	private Matrix4f projectionMatrix;
	private Matrix4f viewMatrix;
	
	public Camera(float left, float right, float bottom, float top){
		projectionMatrix = Matrix4f.orthographic(left, right, bottom, top, -1.0f, 1.0f);
		viewMatrix = Matrix4f.identity();
	}
	
	public Matrix4f getProjectionMatrix(){
		return projectionMatrix;
	}
	
	public Matrix4f getViewMatrix(){
		return viewMatrix;
	}

	public void setPosition(Vector3f position) {
		viewMatrix = Matrix4f.translate(position.negate());
	}

}
