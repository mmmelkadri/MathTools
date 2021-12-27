import java.util.ArrayList;
import java.util.Arrays;

public class Vector extends Matrix {
	ArrayList<Double> vector;
	String size_error = "Error - Vectors have different dimensions.";
	
	public Vector(ArrayList<Double> vector) {
		// if given an empty ArrayList, initialize as [0.0]
		super(new ArrayList<>(Arrays.asList(vector)));
		vector = this.matrix.get(0);
	}
	
	public double dotProduct(Vector other_vector) {
		if (vector.size() != other_vector.vector.size()) {
			System.out.println(size_error);
			return -1;
		}
		
		double dot_product = 0;
		
		for (int i = 0; i < vector.size(); i++)
			dot_product += vector.get(i) * other_vector.vector.get(i);
		
		return dot_product;
	}
	
	public double angle(Vector other_vector) {
		if (vector.size() != other_vector.vector.size()) {
			System.out.println(size_error);
			return -1;
		}
		
		return Math.acos(this.dotProduct(other_vector)/
				(this.dotProduct(this) * other_vector.dotProduct(other_vector)));
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
