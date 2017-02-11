package maths;

public class Vector4f {

	public float x, y, z, w;
	
	public Vector4f(){
	}

	public Vector4f(float scalar){
		this.x = scalar;
		this.y = scalar;
		this.z = scalar;
		this.w = scalar;
	}
	
	public Vector4f(float x, float y, float z, float w){
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public Vector4f(Vector4f other){
		x = other.x;
		y = other.y;
		z = other.z;
		w = other.w;
	}
	
	public Vector4f multiply(Vector4f other){
		x *= other.x;
		y *= other.y;
		z *= other.z;
		w *= other.w;
		return this;
	}
	
	public Vector4f divide(Vector4f other){
		x /= other.x;
		y /= other.y;
		z /= other.z;
		w /= other.w;
		return this;
	}
	
	public Vector4f add(Vector4f other){
		x += other.x;
		y += other.y;
		z += other.z;
		w += other.w;
		return this;
	}
	
	public Vector4f subtract(Vector4f other){
		x -= other.x;
		y -= other.y;
		z -= other.z;
		w -= other.w;
		return this;
	}
	
	public float dot(Vector4f other){
		return x* other.x + y * other.y + z * other.z + w* other.w;
	}
	
	public float magnitude(){
		return (float)Math.sqrt(x * x + y * y + z * z + w * w);
	}
	
	public float distance(Vector4f other){
		return new Vector4f(this).subtract(other).magnitude();
	}
	
	public Vector4f normalize(){
		float magnitude = magnitude();
		x /= magnitude;
		y /= magnitude;
		z /= magnitude;
		w /= magnitude;
		return this;
	}
	
	public boolean equals(Object object){
		if (!(object instanceof Vector4f))
			return false;
		
		Vector4f other = (Vector4f)object;
		return x == other.x && y == other.y && z == other.z && w == other.w;
	}
	
	public String toString(){
		return "(" + x + ", " + y + ", " + z + ", " + w + ")";
	}
	
}
