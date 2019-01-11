/**
 * Tests the Matrix class
 * @author Jakin Ng
 * @version 01.07.2019
 */
public class MatrixTester 
{
	public static void main(String[] args)
	{
		tester3();
	}
	
	/**
	 * Tests the Matrix class
	 */
	public static void tester()
	{
		Matrix mat1 = new Matrix(3, 4);
		System.out.println(mat1);
		
		double[][] mat2Arr = {{1, 2, 3}, {1, 3, 3}, {1, 2, 3}, {2, 3, 4}};
		Matrix mat2 = new Matrix(mat2Arr);
		System.out.println(mat2);
		System.out.println("rows: " + mat2.getRows());
		System.out.println("columns: " + mat2.getColumns());
		mat2.setRows(5);
		System.out.println(mat2);
		mat2.setRows(3);
		System.out.println(mat2);
		mat2.setColumns(4);
		System.out.println(mat2);
		mat2.setColumns(3);
		System.out.println(mat2);
		mat2Arr = new double[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
		mat2.setElements(mat2Arr);
		System.out.println(mat2);
	}
	
	public static void tester2()
	{
		double[][] mat2Arr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
		Matrix mat2 = new Matrix(mat2Arr);
		System.out.println(mat2.equals(3));
		System.out.println(mat2.equals(new String("hello")));
		double[][] mat3Arr = {{1, 2, 3}, {1, 3, 3}, {1, 2, 3}, {2, 3, 4}};
		Matrix mat3 = new Matrix(mat3Arr);
		double[][] mat4Arr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
		Matrix mat4 = new Matrix(mat4Arr);
		System.out.println(mat2.equals(mat3));
		System.out.println(mat2.equals(mat4));
	}
	
	public static void math()
	{
		Matrix mat1 = new Matrix(2, 2);
		Matrix mat2 = new Matrix(1, 2);
		mat2.identity(2);
		Matrix mat3 = new Matrix(new double[][] {{1, 2}, {3, 4}});
		System.out.println(MatrixMath.add(mat1, mat2));
		System.out.println(MatrixMath.add(mat1, mat3));
		System.out.println(MatrixMath.add(mat2, mat3));
		mat3.transpose();
		System.out.println(mat3);
	}
	
	public static void math2()
	{
		Matrix mat1 = new Matrix(3, 2);
		Matrix mat2 = new Matrix(2, 2);
		Matrix mat3 = new Matrix(new double[][] {{1, 2}, {1, 3}, {1, 2}});
		Matrix mat4 = new Matrix(new double[][] {{1, 1}, {1, 1}, {1, 1}});
		System.out.println(MatrixMath.add(mat1, mat3));
		System.out.println(MatrixMath.add(mat3, mat4));
		System.out.println(MatrixMath.add(mat2, mat1));
		mat3.transpose();
		System.out.println(mat3);
	}
	
	public static void math3()
	{
		Matrix mat1 = new Matrix(3, 2);
		Matrix mat2 = new Matrix(2, 2);
		Matrix mat3 = new Matrix(new double[][] {{1, 2}, {1, 3}, {1, 2}});
		Matrix mat4 = new Matrix(new double[][] {{1, 1}, {1, 1}, {1, 1}});
		System.out.println(MatrixMath.subtract(mat1, mat3));
		System.out.println(MatrixMath.subtract(mat3, mat4));
		System.out.println(MatrixMath.subtract(mat2, mat1));
		System.out.println(MatrixMath.multiply(2, mat3));
	}
	
	public static void math4()
	{
		Matrix zero = new Matrix(2, 2);
		Matrix id = new Matrix(0, 0);
		id.identity(2);
		Matrix mat3 = new Matrix(new double[][] {{1, 2}, {1, 2}});
		System.out.println(MatrixMath.multiply(zero, mat3));
		System.out.println(MatrixMath.multiply(id, mat3));
		System.out.println(MatrixMath.multiply(mat3, id));
		
		Matrix mat4 = new Matrix(new double[][] {{0, 1}, {0, 1}, {0, 1}});
		System.out.println(MatrixMath.multiply(mat3, mat4));
		System.out.println(MatrixMath.multiply(mat4, mat3));
	}
	
	public static void tester3()
	{
		Matrix zero = new Matrix(2, 2);
		Matrix different = new Matrix(new double[][] {{1, 2}, {2, 1}});
		System.out.println(zero.determinant() + " " + different.determinant());
		different.deleteRow(0);
		System.out.println(different); 
	}
}