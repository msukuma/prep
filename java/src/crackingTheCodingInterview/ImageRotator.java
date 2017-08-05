package crackingTheCodingInterview;

import java.util.Arrays;

import util.Printer;

public class ImageRotator {
	public static class Cell {
		int[][] img;
		int row; 
		int col;
		
		public Cell(int[][] img, int row, int col){
			this.img = img;
			this.row = row;
			this.col = col;
		}
		
		public void swap(Cell c){
			int tmp = img[row][col];
			img[row][col] = img[c.row][c.col];
			img[c.row][c.col] = tmp;
//			Printer.printMatrix(img);
		}
		
		public String toString(){
			return "Row: " + row +" Col: " + col +" Value: "+ img[row][col] +"\n";
		}
	}
	
	int[][] img;
	int rot = 0;
	
	public ImageRotator(){
		
	}
	
	private void rotateBorder(Cell tlc, Cell trc, Cell blc, Cell brc){
		int rm  = trc.col - tlc.col;
		
		for (int i = 0; i < rm; i++) {
//			Printer.puts("tlc: "+ tlc +"blc: "+ blc+ "brc: "+ brc + "trc: " + trc,  30);
			tlc.swap(blc);
			blc.swap(brc);
			brc.swap(trc);
//			Printer.printMatrix(img);
			
			tlc.col++;
			blc.row--;
			brc.col--;
			trc.row++;
		}

//		Printer.puts("tlc: "+ tlc +"blc: "+ blc+ "brc: "+ brc + "trc: " + trc,  30);
		tlc.row++;
		tlc.col -= (rm - 1);
		blc.row += (rm - 1);
		blc.col++;
		brc.row--;
		brc.col += (rm - 1);
		trc.row -= (rm - 1);
		trc.col--;
//		Printer.puts("tlc: "+ tlc +"blc: "+ blc+ "brc: "+ brc + "trc: " + trc,  30);
		if(trc.col - tlc.col > 0){
			rotateBorder(tlc, trc, blc, brc);
		}
	
	}
	
	public void rotate(int[][] image){
		img = image;
		int rm = img.length - 1;
		Printer.printMatrix(img);
		Cell tlc = new Cell(img, 0,0);
		Cell trc = new Cell(img, 0,rm); 
		Cell blc = new Cell(img, rm,0);
		Cell brc = new Cell(img, rm,rm);
		
		rotateBorder(tlc, trc, blc, brc);
		Printer.printMatrix(img);
		Printer.seperator(50);
	}
	
	public static void main(String[] args) {
		ImageRotator ir = new ImageRotator();
		int[][] image1 = {
				{1,2},
				{3,4},
		};
		
		int[][] image2 = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		int[][] image3 = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
		int[][] image4 = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
		};
		
		ir.rotate(image1);
		ir.rotate(image2);
		ir.rotate(image3);
		ir.rotate(image4);
	}
}
