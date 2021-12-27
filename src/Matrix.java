import java.util.ArrayList;
import java.util.Arrays;

/* Matrix Class */

public class Matrix {
	// ArrayList of column vectors
	ArrayList<ArrayList<Double>> matrix;
	Integer[] dimensions = {0, 0};
	
	public Matrix(ArrayList<ArrayList<Double>> matrix) {
		// Set dimensions
		dimensions[0] = matrix.get(0).size();
		dimensions[1] = matrix.size();
		
		// Check if each column has the same size
		int i = 0;
		for (ArrayList<Double> column : matrix) {
			if (column.size() != dimensions[0]) {
				System.out.println("Error - Too many rows in column " + i);
				// Set matrix to zero matrix
				dimensions[0] = 1; dimensions[1] = 1;
				matrix.add(new ArrayList<>(Arrays.asList(0.0)));
				
				return;
			}
			i++;
		}
		
		this.matrix = matrix;
	}
		
	public void matrixMultiply(Matrix other) {
		// AB multiplication, where this.matrix is A and other.matrix is B
		if (this.dimensions[1] != other.dimensions[0])
			return;
		
		this.dimensions[1] = other.dimensions[1];

		ArrayList<ArrayList<Double>> new_matrix = new ArrayList<>();
		
		// for each column vector of other.matrix
		for (int i = 0; i < other.dimensions[1]; i++) {
			// ith column of AB = matrix A * ith column of B
			ArrayList<Double> ith_column = new ArrayList<>();
			// for each column of this.matrix
			for (int j = 0; j < this.dimensions[1]; j++) {
				// for each element of column
				for (int k = 0; k < this.dimensions[0]; k++) {
					
				}
			}
		}
	}
	
	// Transpose matrix
	public void transpose() {
		ArrayList<ArrayList<Double>> new_matrix = new ArrayList<>();
		
		// for each row
		for (int i = 0; i < this.dimensions[0]; i++) {
			// create a column with the row elements
			ArrayList<Double> column = new ArrayList<>();
			for (int j = 0; j < this.dimensions[1]; j++) {
				column.add(this.matrix.get(j).get(i));
			}
			
			new_matrix.add(column);
		}
		
		this.matrix = new_matrix;
	}
	
	public double determinant() {
		if (dimensions[0] != dimensions[1]) {
			System.out.println("Error - Determinant cannot be calculated for non-square matrix");
			return -1.0;
		}
		
		if (dimensions[0] == 2) {
			return matrix.get(0).get(0) * matrix.get(1).get(1) - 
					matrix.get(1).get(0) * matrix.get(0).get(1);
		}
		
		// TODO
		// IMPLEMENT DETERMINANT FOR NON-2x2 MATRICES
		System.out.println("Error - Currently not implemented for non-2x2 matrices");
		return -1.0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		
		if (obj instanceof Matrix) {
			Matrix other = (Matrix) obj;
			
			if (!this.dimensions.equals(other.dimensions))
				return false;
			
			// for each column
			for (int i = 0; i < this.dimensions[1]; i++) {
				// for each element in the column
				for (int j = 0; j < this.dimensions[0]; j++) {
					if (this.matrix.get(i).get(j) != other.matrix.get(i).get(j))
						return false;
				}
			}
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		int sum = 0;
		
		for (ArrayList<Double> column : matrix) {
			for (Double element : column) {
				sum += element;
			}
		}
		
		return sum;
	}
}
