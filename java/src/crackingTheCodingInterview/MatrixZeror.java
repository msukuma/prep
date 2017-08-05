package crackingTheCodingInterview;

import util.Printer;

public class MatrixZeror {
	int[][] m;
	int numRows;
	int numCols;
	boolean[] zeroCols;
	boolean[] zeroRows;
	
	public MatrixZeror(int[][] matrix){
		m = matrix;
		numRows = m.length;
		numCols = m[0].length;
		
		zeroRows = new boolean[numRows];
		zeroCols = new boolean[numCols];
	}
	
	public void zero(){
		Printer.printMatrix(m);
		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++) {
				if(m[r][c] == 0){
					zeroRows[r] = true;
					zeroCols[c] = true;
				}
			}
		}
		
		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++) {
				if (isZeroRow(r) || isZeroCol(c)) {
					m[r][c] = 0;
				}
			}
		}
		
		Printer.printMatrix(m);
	}
	
	private boolean isZeroRow(int row){
		return zeroRows[row];
	}
	
	private boolean isZeroCol(int col){
		return zeroCols[col];
	}
	
	private void zeroCol(int col){
		for (int row = 0; row < numRows; row++) {
			m[row][col] = 0;
		}
	}
	
	private void zeroRow(int row){
		for (int col = 0; col < numCols; col++) {
			m[row][col] = 0 ;
		}
	}
	
	public static void main(String[] args) {
		int[][] m = {
				{1,2,0,4},
				{5,0,7,8},
				{9,10,11,12},
				{13,0,15,16}
		};
		
		MatrixZeror mr = new MatrixZeror(m);
		mr.zero();
	}
}
