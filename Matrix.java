/**
 * Represents a Matrix
 * @author Jakin Ng
 * @version 01.07.2019
 */
public class Matrix 
{
	private int rows;
	private int columns;
	private double[][] elements;
	
	/**
	 * Creates a new Matrix with all zeroes
	 * @param rows The number of rows of the Matrix
	 * @param columns The number of columns of the Matrix
	 */
	public Matrix(int rows, int columns)
	{
		this.rows = rows;
		this.columns = columns;
		elements = new double[rows][columns];
	}
	
	/**
	 * Creates a new Matrix with elements equal to matElts
	 * @param matElts The elements of the new Matrix
	 * Precondition: matElts is a rectangular 2-D array and is non-empty
	 */
	public Matrix(double[][] matElts)
	{
		rows = matElts.length;
		if (rows != 0)
			columns = matElts[0].length;
		//constructing a new array so it points to a different object
		elements = new double[rows][columns];
		//adding the new numbers
		for (int i = 0; i < matElts.length; i++)
		{
			for (int j = 0; j < matElts[i].length; j++)
			{
				elements[i][j] = matElts[i][j];
			}
		}
	}
	
	/**
	 * Returns the number of rows of this Matrix
	 * @return The number of rows of this Matrix
	 */
	public int getRows() 
	{
		return rows;
	}

	/**
	 * Sets rows to newRows
	 * If newRows > rows, it fills the extra rows with zeroes
	 * Otherwise it simply deletes the excess rows
	 * @param newRows The new number of rows of the matrix
	 */
	public void setRows(int newRows) 
	{
		//creates a new object filled with zeroes with the right dims
		double[][] newArray = new double[newRows][columns];
		//if we want fewer rows, we transfer all the elements we
		//still want over to the newArray
		if (newRows <= rows)
		{
			for (int i = 0; i < newRows; i++)
				for (int j = 0; j < columns; j++)
					newArray[i][j] = elements[i][j];
		}
		//otherwise we transfer all the elements we have
		//the rest are automatically zeroes
		else
		{
			for (int i = 0; i < rows; i++)
				for (int j = 0; j < columns; j++)
					newArray[i][j] = elements[i][j];
		}
		//updates our PIVs
		elements = newArray;
		rows = newRows;
	}

	/**
	 * Returns the number of columns in this Matrix
	 * @return The number of columns 
	 */
	public int getColumns() 
	{
		return columns;
	}

	/**
	 * Sets columns to newCols
	 * @param columns The new number of columns
	 * If newCols > columns, it fills the new columns with zeroes
	 * Otherwise it simply gets rid of the excess rows
	 */
	public void setColumns(int newCols) 
	{
		//creates a new object filled with zeroes with the right dims
		double[][] newArray = new double[rows][newCols];
		//if we want fewer columns, we transfer all the elements we
		//still want over to the newArray
		if (newCols <= columns)
		{
			for (int i = 0; i < rows; i++)
				for (int j = 0; j < newCols; j++)
					newArray[i][j] = elements[i][j];
		}
		//otherwise we transfer all the elements we have
		//the rest are automatically zeroes
		else
		{
			for (int i = 0; i < rows; i++)
				for (int j = 0; j < columns; j++)
					newArray[i][j] = elements[i][j];
		}
		//updates our PIVs
		elements = newArray;
		columns = newCols;
	}

	/**
	 * Returns the elements of the matrix
	 * @return The elements of the matrix
	 */
	public double[][] getElements() 
	{
		return elements;
	}

	/**
	 * Sets elements to newElts of the matrix
	 * @param newElts The new elements of the matrix
	 */
	public void setElements(double[][] newElts) 
	{
		rows = newElts.length;
		columns = newElts[0].length;
		//constructing a new array so it points to a different object
		elements = new double[rows][columns];
		//adding the new numbers
		for (int i = 0; i < newElts.length; i++)
		{
			for (int j = 0; j < newElts[i].length; j++)
			{
				elements[i][j] = newElts[i][j];
			}
		}
	}
	
	/**
	 * Converts this Matrix to a String
	 */
	@Override
	public String toString()
	{
		String matStr = "{";
		for (int i = 0; i < elements.length; i++)
		{
			for (int j = 0; j < elements[i].length; j++)
			{
				if (i == elements.length - 1 && j == elements[i].length - 1) 
					matStr += elements[i][j];
				else if (i != 0 && j == 0)
					matStr += " " + elements[i][j] + ", ";
				else
					matStr += elements[i][j] + ", ";
			}
			if (i != elements.length - 1)
				matStr += "\n";
		}
		matStr += "}";
		return matStr;
	}
	
	/**
	 * Checks to see if this Matrix has equal elements to other
	 */
	@Override
	public boolean equals(Object other)
	{
		//if other isn't a Matrix they aren't equal
		if (!(other instanceof Matrix))
			return false;
		else
		{
			//we are working with otherElts' PIVs
			double[][] otherElts = ((Matrix)other).getElements();
			int otherRows = ((Matrix)other).getRows();
			int otherCols = ((Matrix)other).getColumns();
			//if different dimensions, not equal
			if (rows != otherRows || columns != otherCols)
				return false;
			else
			{
				boolean equals = true;
				for (int i = 0; i < rows; i++)
					for (int j = 0; j < columns; j++)
						if (elements[i][j] != otherElts[i][j])
							equals = false;
				return equals;
			}
		}
	}
	
	/**
	 * Deletes the row of index delete from elements
	 * @param delete The index of the row to delete
	 */
	public void deleteRow(int delete)
	{
		double[][] deleted = new double[rows - 1][columns];
		for (int i = 0; i < rows; i++) {
			System.out.println(i);
			for (int j = 0; j < columns; j++)
			{
				if (i < delete) 
					deleted[i][j] = elements[i][j];
				else if (i > delete) 
					deleted[i - 1][j] = elements[i][j]; 
			}
		}
		rows = rows - 1;
		elements = deleted;
	}
	
	/**
	 * Converts this Matrix to the n by n identity matrix
	 * @param n The row/column number of the new matrix
	 */
	public void identity(int n)
	{
		double[][] idArr = new double[n][n];
		//goes down the diagonal
		for (int i = 0; i < n; i++)
			idArr[i][i] = 1;
		elements = idArr;
		rows = n	;
		columns = n;
	}
	
	/**
	 * Replaces this Matrix with the transpose of this matrix
	 */
	public void transpose()
	{
		double[][] tPoseArr = new double[columns][rows];
		for (int i = 0; i < columns; i++)
			for (int j = 0; j < rows; j++)
				tPoseArr[i][j] = elements[j][i];
		elements = tPoseArr;
		int newCols = rows;
		rows = columns;
		columns = newCols;
	}
	
	/**
	 * Returns the determinant of this Matrix
	 * @return The determinant of this Matrix
	 */
	public double determinant()
	{
		if (rows != 2 || columns != 2) 
		{
			throw new java.lang.RuntimeException("Cannot compute determinant.");
		}
		else
		{
			return elements[0][0] * elements[1][1] - 
					elements[1][0] * elements[0][1];
		}
	}
}