package io.stylextv.sudoku.board;

public class BoardGenerator {
	
	private static final int FULL_BOARD_NUMBER_AMOUNT = 81;
	
	public static Board randomPartiallyFilledBoard(int numberAmount) {
		Board board = randomFilledBoard();
		if(!board.removeNumbers(FULL_BOARD_NUMBER_AMOUNT - numberAmount)) {
			
			throw new RuntimeException("Unable to remove that many numbers!");
		}
		
		return board;
	}
	
	public static Board randomFilledBoard() {
		Board board = new Board();
		if(!board.solveRandomly()) {
			
			throw new RuntimeException("Unable to solve empty board?!");
		}
		
		return board;
	}
	
}
