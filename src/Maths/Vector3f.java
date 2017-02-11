package Maths;

public class Vector3f {

	public float x, y, z;
	
	public Vector3f(){
	}

	public Vector3f(float scalar){
		this.x = scalar;
		this.y = scalar;
		this.z = scalar;
	}
	
	public Vector3f(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3f(Vector3f other){
		x = other.x;
		y = other.y;
		z = other.z;
	}
	
	public Vector3f multiply(Vector3f other){
		x *= other.x;
		y *= other.y;
		z *= other.z;
		return this;
	}
	
	public Vector3f divide(Vector3f other){
		x /= other.x;
		y /= other.y;
		z /= other.z;
		return this;
	}
	
	public Vector3f add(Vector3f other){
		x += other.x;
		y += other.y;
		z += other.z;
		return this;
	}
	
	public Vector3f subtract(Vector3f other){
		x -= other.x;
		y -= other.y;
		z -= other.z;
		return this;
	}
	
	public float dot(Vector3f other){
		return x* other.x + y * other.y + z * other.z;
	}
	
	public Vector3f cross(Vector3f other){
		return new Vector3f(y * other.z - z * other.y, z * other.x - x * other.z, x * other.y * other.x);
	}
	
	public float magnitude(){
		return (float)Math.sqrt(x * x + y * y + z *z);
	}
	
	public float distance(Vector3f other){
		return new Vector3f(this).subtract(other).magnitude();
	}
	
	public Vector3f normalize(){
		float magnitude = magnitude();
		x /= magnitude;
		y /= magnitude;
		z /= magnitude;
		return this;
	}
	
	public boolean equals(Object object){
		if (!(object instanceof Vector3f))
			return false;
		
		Vector3f other = (Vector3f)object;
		return x == other.x && y == other.y && z == other.z;
	}
	
	public String toString(){
		return "(" + x + ", " + y + ", " + z + ")";
	}
	
}
