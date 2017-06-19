package main.level.component;

import maths.Matrix4f;

public class TransformComponent extends Component{

	public Matrix4f transform;
	
	public TransformComponent(Matrix4f transform){
		this.transform = transform;
	}
	
}
