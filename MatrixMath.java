/**
 * Performs mathematical operations using Matrix objects
 * @author Jakin Ng
 * @version 01.07.2019
 */
public class MatrixMath 
{
	/**
	 * Returns the sum of mat1 and mat2
	 * @param mat1 The first matrix to be added
	 * @param mat2 The second matrix to be added
	 * @return The sum of mat1 and mat2
	 * Precondition: mat1 and mat2 have the same dimensions
	 */
	public static Matrix add(Matrix mat1, Matrix mat2)
	{
		//if they cannot be added
		if (mat1.getRows() != mat2.getRows()
				|| mat1.getColumns() != mat2.getColumns())
		{
			throw new java.lang.RuntimeException("They do not have the same dimensions.");
		}
		else
		{
			//could use either mat1 or mat2 here
			int rows = mat1.getRows();
			int columns = mat1.getColumns();
			double[][] mat1Elts = mat1.getElements();
			double[][] mat2Elts = mat2.getElements();
			double[][] sumArr = new double[rows][columns];
			//iterating through and adding each position at a time
			for (int i = 0; i < rows; i++)
				for (int j = 0; j < columns; j++)
					sumArr[i][j] = mat1Elts[i][j] + mat2Elts[i][j];
			//returning our added array
			return new Matrix(sumArr);
		}
	}
	
	/**
	 * Returns the difference of mat1 and mat2
	 * @param mat1 The first matrix to subtract from
	 * @param mat2 The second matrix to be subtracted
	 * @return The difference
	 * Precondition: mat1 and mat2 have the same dimensions
	 */
	public static Matrix subtract(Matrix mat1, Matrix mat2)
	{
		//adding mat1 + -1 * mat2
		return add(mat1, multiply(-1, mat2));
	}
	
	/**
	 * Multiplies mat by scalar with scalar multiplication
	 * @param scalar The scalar multiplied by mat
	 * @param mat The Matrix multiplied by scalar
	 * @return The scaled matrix
	 */
	public static Matrix multiply(double scalar, Matrix mat)
	{
		//finding dimensions
		int rows = mat.getRows();
		int columns = mat.getColumns();
		double[][] multiplied = new double[rows][columns];
		//iterating through and adding each multiplied elt to multiplied
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				multiplied[i][j] = scalar * mat.getElements()[i][j];
		//returning the result
		return new Matrix(multiplied);
	}
	/**
	 * Multiplies mat1 by mat2 using matrix multiplication
	 * @param mat1 The first multiplied matrix (noncommutative)
	 * @param mat The second multiplied matrix
	 * @return The result of the multiplication
	 * Precondition: they can be multiplied
	 */
	public static Matrix multiply(Matrix mat1, Matrix mat2)
	{
		//if they cannot be multiplied
		if (mat1.getColumns() != mat2.getRows())
		{
			throw new java.lang.RuntimeException("They cannot be multiplied.");
		}
		else
		{
			//finding dimensions of final matrix
			int rows = mat1.getRows();
			int columns = mat2.getColumns();
			double[][] multiplied = new double[rows][columns];
			int sum; 
			//iterating through the rows of the final matrix
			for (int i = 0; i < rows; i++)
				//iterating through columns of final matrix
				for (int j = 0; j < columns; j++)
				{
					sum = 0;
					//getting the dot product of the row and the column
					for (int k = 0; k < mat1.getColumns(); k++)
						sum += mat1.getElements()[i][k] * mat2.getElements()[k][j];
					//adding the dot product
					multiplied[i][j] = sum;
				}
			//returning the multiplied matrix
			return new Matrix(multiplied);
		}
	}
}
