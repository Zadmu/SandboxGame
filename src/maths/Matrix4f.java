package maths;

public class Matrix4f {

	public float[] elements = new float[4 * 4];

	public static Matrix4f identity() {
		Matrix4f result = new Matrix4f();
		result.elements[0 + 0 * 4] = 1;
		result.elements[1 + 1 * 4] = 1;
		result.elements[2 + 2 * 4] = 1;
		result.elements[3 + 3 * 4] = 1;
		return result;
	}

	public Matrix4f multiply(Matrix4f other) {
		float[] data = new float[4 * 4];
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				float sum = 0.0f;
				for (int e = 0; e < 4; e++)
					sum += elements[e + row * 4] * other.elements[col + e * 4];
				data[col + row * 4] = sum;
			}
		}
		elements = data;
		return this;
	}
	
	public static Matrix4f orthographic(float left, float right, float bottom, float top, float near, float far){
		Matrix4f result = identity();
		
		result.elements[0 + 0 * 4] = 2.0f / (right - left);
		
		result.elements[1 + 1 * 4] = 2.0f / (top - bottom);
		
		result.elements[2 + 2 * 4] = 2.0f / (near - far);
		
		result.elements[3 + 0 * 4] = (left + right) / (left - right);
		result.elements[3 + 1 * 4] = (bottom + top) / (bottom - top);
		result.elements[3 + 2 * 4] = (far + near) / (far - near);
		
		return result;
	}
	
	public static Matrix4f perspective(float fov, float aspectRatio, float near, float far){
		Matrix4f result = identity();
		
		float q = 1.0f / (float)Math.tan(Math.toRadians(0.5f * fov));
		float a = q / aspectRatio;
		
		float b = (near + far) / (near - far);
		float c = (2.0f * near + far) / (near - far);
		
		result.elements[0 + 0 * 4] = a;
		result.elements[1 + 1 * 4] = q;
		result.elements[2 + 2 * 4] = b;
		result.elements[3 + 3 * 4] = -1.0f;
		result.elements[4 + 4 * 4] = c;
		
		return result;
	}
	
	public static Matrix4f translate(Vector3f translation) {
		Matrix4f result = identity();
		
		result.elements[3 + 0 * 4] = translation.x;
		result.elements[3 + 1 * 4] = translation.y;
		result.elements[3 + 2 * 4] = translation.z;
		
		return result;
	}
	
	public static Matrix4f scale(Vector3f scale){
		Matrix4f result = identity();
		
		result.elements[0 + 0 * 4] = scale.x;
		result.elements[1 + 1 * 4] = scale.y;
		result.elements[2 + 2 * 4] = scale.z;
		
		return result;
	}

	
}
