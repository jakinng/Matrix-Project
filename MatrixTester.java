/**
 * Tests the Matrix class
 * @author Jakin Ng
 * @version 01.07.2019
 */
public class MatrixTester 
{
	public static void main(String[] args)
	{
	}
	
	/**
	 * Tests the add method of the MatrixMath class
	 */
	//HEY JAKIN TEST NEGATIVE NUMBERS TOSTRING
	//TRY-CATCH FOR MATRIX MATH??
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