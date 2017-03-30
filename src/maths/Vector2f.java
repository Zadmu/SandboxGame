package maths;

public class Vector2f {

	public float x, y;
	
	public Vector2f(){
	}

	public Vector2f(float scalar){
		this.x = scalar;
		this.y = scalar;
	}
	
	public Vector2f(float x, float y, float z){
		this.x = x;
		this.y = y;
	}
	
	public Vector2f(Vector2f other){
		x = other.x;
		y = other.y;
	}
	
	public Vector2f multiply(Vector2f other){
		x *= other.x;
		y *= other.y;
		return this;
	}
	
	public Vector2f divide(Vector2f other){
		x /= other.x;
		y /= other.y;
		return this;
	}
	
	public Vector2f add(Vector2f other){
		x += other.x;
		y += other.y;
		return this;
	}
	
	public Vector2f subtract(Vector2f other){
		x -= other.x;
		y -= other.y;
		return this;
	}
	
	public float dot(Vector2f other){
		return x* other.x + y * other.y;
	}
	
	public float magnitude(){
		return (float)Math.sqrt(x * x + y * y);
	}
	
	public float distance(Vector2f other){
		return new Vector2f(this).subtract(other).magnitude();
	}
	
	public Vector2f normalize(){
		float magnitude = magnitude();
		x /= magnitude;
		y /= magnitude;
		return this;
	}
	
	public boolean equals(Object object){
		if (!(object instanceof Vector2f))
			return false;
		
		Vector2f other = (Vector2f)object;
		return x == other.x && y == other.y;
	}
	
	public String toString(){
		return "(" + x + ", " + y + ")";
	}
	
}
