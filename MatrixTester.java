/**
 * Tests the Matrix class
 * @author Jakin Ng
 * @version 01.07.2019
 */
public class MatrixTester 
{
	public static void main(String[] args)
	{
		basicTest();
		setters();
		toStrTest();
		equalsTest();
		deleteColumnTest();
		deleteRowTest();
		idTest();
		transposeTest();
		detTest();
		addTest();
		subtractTest();
		scalarMultTest();
		matMultTest();
	}
	
	/**
	 * Tests constructors and getters of the Matrix class
	 */
	public static void basicTest()
	{
		//testing constructors
		Matrix mat1 = new Matrix	(2, 3);
		System.out.println("Matrix 1:\n" + mat1);
		Matrix mat2 = new Matrix(new double[][] {{1, 2}, {3, 4}});
		System.out.println("Matrix 2:\n" + mat2);
		
		//testing getters for mat1
		System.out.println("Rows: " + mat1.getRows());
		System.out.println("Columns: " + mat1.getColumns());
		System.out.println("Elements: ");
		for (double[] row : mat1.getElements())
		{
			for (double elt : row)
				System.out.print(elt + " ");
			System.out.println();
		}
		
		//testing getters for mat2
		System.out.println("Rows: " + mat2.getRows());
		System.out.println("Columns: " + mat2.getColumns());
		System.out.println("Elements: ");
		for (double[] row : mat2.getElements())
		{
			for (double elt : row)
				System.out.print(elt + " ");
			System.out.println();
		}
	}
	
	/**
	 * Tests the setters of the Matrix class
	 */
	public static void setters()
	{
		//original matrix
		Matrix mat = new Matrix(new double[][] {{1, 2}, {3, 4}});
		System.out.println("Original matrix: \n " + mat);
		//set rows to 1 (smaller)
		mat.setRows(1);
		System.out.println("Matrix after setting rows to 1: \n" + mat);
		//set rows to 2 (bigger, should be zeroes)
		mat.setRows(2);
		System.out.println("Matrix after setting rows to 2 again: \n" + mat);
		//new matrix
		mat.setElements(new double[][] {{2, 3}, {4, 5}});
		System.out.println("Matrix after setting to a new set of elements: \n" + mat);
		//setting columns smaller then bigger
		mat.setColumns(1);
		System.out.println("Matrix after setting columns to 1: \n" + mat);
		mat.setColumns(2);
		System.out.println("Matrix after setting columns to 2 again: \n" + mat);
	}
	
	/**
	 * Tests the toString method
	 */
	public static void toStrTest()
	{
		//empty matrix to string
		Matrix mat = new Matrix(new double[][] {});
		System.out.println("Empty matrix: \n" + mat);
		//various sizes of matrices
		mat.setElements(new double[][] {{0}});
		System.out.println("1x1 matrix: \n" + mat);
		mat.setElements(new double[][] {{1}, {2}});
		System.out.println("2x1 matrix: \n" + mat);
		mat.setElements(new double[][] {{1, 2}});
		System.out.println("1x2 matrix: \n" + mat);
		mat.setElements(new double[][] {{1, 2}, {2, 1}});
		System.out.println("2x2 matrix: \n" + mat);
		//negative matrix
		mat.setElements(new double[][] {{-1, -3}, {-1, -2}});
		System.out.println("Matrix with negative values: \n" + mat);
	}
	
	/**
	 * Tests the equals method
	 */
	public static void equalsTest()
	{
		//test if they point to the same object
		Matrix mat = new Matrix(1, 1);
		Matrix mat2 = mat;
		System.out.println("mat2 was set to mat. \n" + mat.equals(mat2));
		mat2 = new Matrix(1, 1);
		//they have the same PIVs
		System.out.println("mat2 is a new Matrix equivalent to mat. \n" + mat.equals(mat2));
		mat2 = new Matrix(new double[][] {{1, 2}});
		//not equal
		System.out.println("mat2 is a new Matrix not equivalent to mat. \n" + mat.equals(mat2));
		//first few rows equal
		mat2 = new Matrix(2, 1);
		System.out.println("mat2 is equal to mat for the first row"
				+ " but it has another row. \n" + mat.equals(mat2));
		//empty
		mat2 = new Matrix(0, 0);
		mat = new Matrix(0, 0);
		System.out.println("mat and mat2 are both empty. \n" + mat.equals(mat2));
		//one element difference
		mat = new Matrix(new double[][] {{1, 2}, {2, 3}});
		mat2 = new Matrix(new double[][] {{1, 2}, {2, 4}});
		System.out.println("mat and mat2 are 2x2 matrices with one element off. \n" + mat.equals(mat2));
	}
	
	/**
	 * Tests the deleteColumn method. 
	 */
	public static void deleteColumnTest()
	{
		//out of bounds
		Matrix mat = new Matrix(0, 0);
		System.out.println("Deletes column of empty matrix.");
		mat.deleteColumn(0);
		//deletes 1st column of 1x1
		mat = new Matrix(1, 1);
		System.out.println("Deletes 1st column of 1x1 matrix: \n" + mat);
		mat.deleteColumn(0);
		System.out.println("Column deleted. \n" + mat);
		mat = new Matrix(new double[][] {{1, 2}, {2, 1}});
		//Deletes 1st column of 2x2
		System.out.println("Deletes 1st column of 2x2 matrix: \n" + mat);
		mat.deleteColumn(0);
		System.out.println("Column deleted. \n" + mat);
		mat = new Matrix(new double[][] {{1, 2}, {2, 1}});
		//deletes 2nd column of 2x2
		System.out.println("Deletes 2nd column of 2x2 matrix: \n" + mat);
		mat.deleteColumn(1);
		System.out.println("Column deleted. \n" + mat);
		//deletes a column out of bounds
		mat = new Matrix(new double[][] {{1, 2}, {2, 1}});
		System.out.println("Tries to delete 3rd column of 2x2 matrix: \n" + mat);
		mat.deleteColumn(2);
		mat = new Matrix(new double[][] {{1, 2, 3}, {2, 1, 3}, {2, 3, 3}});
		//deletes middle column
		System.out.println("Deletes 2nd column of 3x3 matrix: \n" + mat);
		mat.deleteColumn(1);
		System.out.println("Column deleted. \n" + mat);
	}
	
	/**
	 * Tests the deleteRow method. 
	 */
	public static void deleteRowTest()
	{
		//out of bounds
		Matrix mat = new Matrix(0, 0);
		System.out.println("Deletes row of empty matrix.");
		mat.deleteRow(0);
		mat = new Matrix(1, 1);
		//tests various sizes and rows
		System.out.println("Deletes 1st row of 1x1 matrix: \n" + mat);
		mat.deleteRow(0);
		System.out.println("Row deleted. \n" + mat);
		mat = new Matrix(new double[][] {{1, 2}, {2, 1}});
		System.out.println("Deletes 1st row of 2x2 matrix: \n" + mat);
		mat.deleteRow(0);
		System.out.println("Row deleted. \n" + mat);
		mat = new Matrix(new double[][] {{1, 2}, {2, 1}});
		System.out.println("Deletes 2nd row of 2x2 matrix: \n" + mat);
		mat.deleteRow(1);
		System.out.println("Row deleted. \n" + mat);
		mat = new Matrix(new double[][] {{1, 2}, {2, 1}});
		System.out.println("Tries to delete 3rd row of 2x2 matrix: \n" + mat);
		mat.deleteRow(2);
		mat = new Matrix(new double[][] {{1, 2, 3}, {2, 1, 3}, {2, 3, 3}});
		System.out.println("Deletes 2nd row of 3x3 matrix: \n" + mat);
		mat.deleteRow(1);
		System.out.println("Row deleted. \n" + mat);
	}
	
	/**
	 * Tests the identity method
	 */
	public static void idTest()
	{
		//changes to different sizes of identity matrix
		Matrix mat = new Matrix(2, 3);
		mat.identity(0);
		System.out.println("identity(0): \n" + mat);
		mat.identity(1);
		System.out.println("identity(1): \n" + mat);
		mat.identity(2);
		System.out.println("identity(2): \n" + mat);
	}
	
	/**
	 * Tests the transpose method
	 */
	public static void transposeTest()
	{
		//transposes various sizes
		Matrix mat = new Matrix(0, 0);
		System.out.println("Transposes an empty matrix: \n" + mat);
		mat.transpose();
		System.out.println(mat);
		mat = new Matrix(1, 1);
		System.out.println("Transposes a 1x1 matrix: \n" + mat);
		mat.transpose();
		System.out.println(mat);
		mat = new Matrix(1, 2);
		System.out.println("Transposes a 1x2 matrix: \n" + mat);
		mat.transpose();
		System.out.println(mat);
		mat = new Matrix(new double[][] {{1, 2, 3}, {2, 3, 4}});
		System.out.println("Transposes a 2x3 matrix: \n" + mat);
		mat.transpose();
		System.out.println(mat);
	}
	
	/**
	 * Tests the determinant method
	 */
	public static void detTest()
	{
		//empty matrix
		Matrix mat = new Matrix(0, 0);
		System.out.println(mat);
		System.out.println("Determinant of empty matrix: " + mat.determinant());
		//1x1 matrix
		mat = new Matrix(new double[][] {{3}});
		System.out.println(mat + "\nDeterminant: " + mat.determinant());
		//2x2 matrix 
		mat.setElements(new double[][] {{1, 2}, {3, 4}});
		System.out.println(mat + "\nDeterminant: " + mat.determinant());
		//3x3 matrix 
		mat.setElements(new double[][] {{1, 2, 3}, {3, 4, 4}, {4, 5, 6}});
		System.out.println(mat + "\nDeterminant: " + mat.determinant());
		//2x3 matrix
		mat.setElements(new double[][] {{1, 2, 5}, {3, 4, 6}});
		System.out.println(mat + "\nDeterminant: " + mat.determinant());
	}
	
	public static void addTest()
	{
		//tests empty matrices
		Matrix mat = new Matrix(0, 0);
		Matrix mat2 = new Matrix(0, 0);
		System.out.println(mat + " + " + mat2 + " = "
				+ MatrixMath.add(mat, mat2));
		//tests 1x1 matrices
		mat = new Matrix(new double[][] {{0}});
		mat2 = new Matrix(new double[][] {{1}});
		System.out.println(mat + " + " + mat2 + " = "
				+ MatrixMath.add(mat, mat2));
		mat = new Matrix(new double[][] {{0, 1}}); //1x2 matrices
		mat2 = new Matrix(new double[][] {{1, 2}});
		System.out.println(mat + " + " + mat2 + " = "
				+ MatrixMath.add(mat, mat2));
		mat = new Matrix(new double[][] {{3}, {1}}); //2x1 matrices
		mat2 = new Matrix(new double[][] {{2}, {-5}});
		System.out.println(mat + "\n+\n" + mat2 + "\n=\n"
				+ MatrixMath.add(mat, mat2));
		mat = new Matrix(new double[][] {{3, 1}, {2, 1}});
		mat2 = new Matrix(new double[][] {{1, 2}, {-1, -5}});
		System.out.println(mat + "\n+\n" + mat2 + "\n=\n"
				+ MatrixMath.add(mat, mat2));
		//tests matrices that we cannot add
		mat = new Matrix(new double[][] {{3, 1}, {2, 1}});
		mat2 = new Matrix(new double[][] {{1, 2}});
		System.out.println(mat + "\n+\n" + mat2 + "\n=\n"
				+ MatrixMath.add(mat, mat2));
	}
	
	/**
	 * Tests the subtract method of the MatrixMath class
	 */
	public static void subtractTest()
	{
		Matrix mat = new Matrix(0, 0); //empty matrices
		Matrix mat2 = new Matrix(0, 0);
		System.out.println(mat + " - " + mat2 + " = "
				+ MatrixMath.subtract(mat, mat2));
		mat = new Matrix(new double[][] {{0}}); //1x1 matrices
		mat2 = new Matrix(new double[][] {{1}});
		System.out.println(mat + " - " + mat2 + " = "
				+ MatrixMath.subtract(mat, mat2));
		mat = new Matrix(new double[][] {{0, 1}}); //1x2 matrices
		mat2 = new Matrix(new double[][] {{1, 2}});
		System.out.println(mat + " - " + mat2 + " = "
				+ MatrixMath.subtract(mat, mat2));
		mat = new Matrix(new double[][] {{3}, {1}}); //2x1 matrices
		mat2 = new Matrix(new double[][] {{2}, {-5}});
		System.out.println(mat + "\n-\n" + mat2 + "\n=\n"
				+ MatrixMath.subtract(mat, mat2));
		mat = new Matrix(new double[][] {{3, 1}, {2, 1}}); //2x2 matrices
		mat2 = new Matrix(new double[][] {{1, 2}, {-1, -5}});
		System.out.println(mat + "\n-\n" + mat2 + "\n=\n"
				+ MatrixMath.subtract(mat, mat2));
		//tests matrices we cannot subtract
		mat = new Matrix(new double[][] {{3, 1}, {2, 1}});
		mat2 = new Matrix(new double[][] {{1, 2}});
		System.out.println(mat + "\n-\n" + mat2 + "\n=\n"
				+ MatrixMath.subtract(mat, mat2));
	}
	
	/**
	 * Tests the scalar version of the 
	 * multiply method of the MatrixMath class
	 */
	public static void scalarMultTest()
	{
		Matrix mat = new Matrix(0, 0); //empty matrix
		System.out.println("0 * " + mat + " = " + MatrixMath.multiply(0, mat));
		System.out.println("1 * " + mat + " = " + MatrixMath.multiply(1, mat));
		mat = new Matrix(new double[][] {{1}}); //1x1 matrix
		System.out.println("0 * " + mat + " = " + MatrixMath.multiply(0, mat));
		System.out.println("1 * " + mat + " = " + MatrixMath.multiply(1, mat));
		System.out.println("2 * " + mat + " = " + MatrixMath.multiply(2, mat));
		mat = new Matrix(new double[][] {{1, 2}, {3, 4}}); //2x2 matrix
		System.out.println("-1.5 * \n" + mat + " = \n" + MatrixMath.multiply(-1.5, mat));
		System.out.println("2 * \n" + mat + " = \n" + MatrixMath.multiply(2, mat));
		mat = new Matrix(new double[][] {{1, 2}}); //1x2 matrix
		System.out.println("-2.4 * " + mat + " = " + MatrixMath.multiply(-2.4, mat));
		System.out.println("2 * " + mat + " = " + MatrixMath.multiply(2, mat));
	}
	
	/**
	 * Tests the matrix version of the 
	 * multiply method of the MatrixMath class
	 */
	public static void matMultTest()
	{
		Matrix mat = new Matrix(0, 0); //empty matrix
		Matrix mat2 = new Matrix(0, 0);
		System.out.println("" + mat + mat2 + " = " + MatrixMath.multiply(mat, mat2));
		mat = new Matrix(new double[][] {{1, 2}, {2, 3}}); //2x2 by 2x2
		mat2 = new Matrix(new double[][] {{2, 3}, {3, 2}});
		System.out.println(mat + "* \n" + mat2 + " =\n" + MatrixMath.multiply(mat, mat2));
		mat = new Matrix(new double[][] {{1, 2}}); //1x2 by 2x1
		mat2 = new Matrix(new double[][] {{2}, {1}});
		System.out.println(mat + "* \n" + mat2 + " =\n" + MatrixMath.multiply(mat, mat2));
		mat = new Matrix(new double[][] {{1, 2}, {3, 4}, {2, 3}}); //3x2 by 2x4
		mat2 = new Matrix(new double[][] {{2, 3, 4, 5}, {1, 1, 2, 3}});
		System.out.println(mat + "* \n" + mat2 + " =\n" + MatrixMath.multiply(mat, mat2));
		//2x4 by 3x2
		System.out.println(mat2 + "* \n" + mat + " =\n" + MatrixMath.multiply(mat2, mat));
	}
}
