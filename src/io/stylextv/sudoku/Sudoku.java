package io.stylextv.sudoku;

import io.stylextv.sudoku.board.Board;
import io.stylextv.sudoku.board.BoardGenerator;

public class Sudoku {
	
	private static final int NUMBER_AMOUNT = 30;
	
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		Board board = BoardGenerator.randomPartiallyFilledBoard(NUMBER_AMOUNT);
		
		System.out.println(System.currentTimeMillis() - time);
		System.out.println(board);
	}
	
}
