package io.stylextv.sudoku.board;

import java.util.Random;

public class Board {
	
	private static final int LENGTH = 9;
	private static final int BOX_LENGTH = 3;
	
	private static final int SMALLEST_NUMBER = 1;
	private static final int LARGEST_NUMBER = 9;
	private static final int MISSING_NUMBER = 0;
	
	private static final int EMPTY_BOARD_NUMBER_AMOUNT = 0;
	private static final int FULL_BOARD_NUMBER_AMOUNT = LENGTH * LENGTH;
	
	private static final int UNCONSTRAINED_NUMBER_CONSTRAINT_AMOUNT = 0;
	private static final int[][][][] CONSTRAINED_NUMBER_POSITIONS = new int[][][][] {
			{
					{ {1, 0}, {0, 1}, {2, 0}, {0, 2}, {3, 0}, {0, 3}, {4, 0}, {0, 4}, {5, 0}, {0, 5}, {6, 0}, {0, 6}, {7, 0}, {0, 7}, {8, 0}, {0, 8}, {1, 1}, {1, 2}, {2, 1}, {2, 2} },
					{ {0, 0}, {1, 1}, {2, 1}, {0, 2}, {3, 1}, {0, 3}, {4, 1}, {0, 4}, {5, 1}, {0, 5}, {6, 1}, {0, 6}, {7, 1}, {0, 7}, {8, 1}, {0, 8}, {1, 0}, {1, 2}, {2, 0}, {2, 2} },
					{ {0, 0}, {1, 2}, {0, 1}, {2, 2}, {3, 2}, {0, 3}, {4, 2}, {0, 4}, {5, 2}, {0, 5}, {6, 2}, {0, 6}, {7, 2}, {0, 7}, {8, 2}, {0, 8}, {1, 0}, {1, 1}, {2, 0}, {2, 1} },
					{ {0, 0}, {1, 3}, {0, 1}, {2, 3}, {0, 2}, {3, 3}, {4, 3}, {0, 4}, {5, 3}, {0, 5}, {6, 3}, {0, 6}, {7, 3}, {0, 7}, {8, 3}, {0, 8}, {1, 4}, {1, 5}, {2, 4}, {2, 5} },
					{ {0, 0}, {1, 4}, {0, 1}, {2, 4}, {0, 2}, {3, 4}, {0, 3}, {4, 4}, {5, 4}, {0, 5}, {6, 4}, {0, 6}, {7, 4}, {0, 7}, {8, 4}, {0, 8}, {1, 3}, {1, 5}, {2, 3}, {2, 5} },
					{ {0, 0}, {1, 5}, {0, 1}, {2, 5}, {0, 2}, {3, 5}, {0, 3}, {4, 5}, {0, 4}, {5, 5}, {6, 5}, {0, 6}, {7, 5}, {0, 7}, {8, 5}, {0, 8}, {1, 3}, {1, 4}, {2, 3}, {2, 4} },
					{ {0, 0}, {1, 6}, {0, 1}, {2, 6}, {0, 2}, {3, 6}, {0, 3}, {4, 6}, {0, 4}, {5, 6}, {0, 5}, {6, 6}, {7, 6}, {0, 7}, {8, 6}, {0, 8}, {1, 7}, {1, 8}, {2, 7}, {2, 8} },
					{ {0, 0}, {1, 7}, {0, 1}, {2, 7}, {0, 2}, {3, 7}, {0, 3}, {4, 7}, {0, 4}, {5, 7}, {0, 5}, {6, 7}, {0, 6}, {7, 7}, {8, 7}, {0, 8}, {1, 6}, {1, 8}, {2, 6}, {2, 8} },
					{ {0, 0}, {1, 8}, {0, 1}, {2, 8}, {0, 2}, {3, 8}, {0, 3}, {4, 8}, {0, 4}, {5, 8}, {0, 5}, {6, 8}, {0, 6}, {7, 8}, {0, 7}, {8, 8}, {1, 6}, {1, 7}, {2, 6}, {2, 7} }
			},
			{
					{ {0, 0}, {1, 1}, {2, 0}, {1, 2}, {3, 0}, {1, 3}, {4, 0}, {1, 4}, {5, 0}, {1, 5}, {6, 0}, {1, 6}, {7, 0}, {1, 7}, {8, 0}, {1, 8}, {0, 1}, {0, 2}, {2, 1}, {2, 2} },
					{ {0, 1}, {1, 0}, {2, 1}, {1, 2}, {3, 1}, {1, 3}, {4, 1}, {1, 4}, {5, 1}, {1, 5}, {6, 1}, {1, 6}, {7, 1}, {1, 7}, {8, 1}, {1, 8}, {0, 0}, {0, 2}, {2, 0}, {2, 2} },
					{ {0, 2}, {1, 0}, {1, 1}, {2, 2}, {3, 2}, {1, 3}, {4, 2}, {1, 4}, {5, 2}, {1, 5}, {6, 2}, {1, 6}, {7, 2}, {1, 7}, {8, 2}, {1, 8}, {0, 0}, {0, 1}, {2, 0}, {2, 1} },
					{ {0, 3}, {1, 0}, {1, 1}, {2, 3}, {1, 2}, {3, 3}, {4, 3}, {1, 4}, {5, 3}, {1, 5}, {6, 3}, {1, 6}, {7, 3}, {1, 7}, {8, 3}, {1, 8}, {0, 4}, {0, 5}, {2, 4}, {2, 5} },
					{ {0, 4}, {1, 0}, {1, 1}, {2, 4}, {1, 2}, {3, 4}, {1, 3}, {4, 4}, {5, 4}, {1, 5}, {6, 4}, {1, 6}, {7, 4}, {1, 7}, {8, 4}, {1, 8}, {0, 3}, {0, 5}, {2, 3}, {2, 5} },
					{ {0, 5}, {1, 0}, {1, 1}, {2, 5}, {1, 2}, {3, 5}, {1, 3}, {4, 5}, {1, 4}, {5, 5}, {6, 5}, {1, 6}, {7, 5}, {1, 7}, {8, 5}, {1, 8}, {0, 3}, {0, 4}, {2, 3}, {2, 4} },
					{ {0, 6}, {1, 0}, {1, 1}, {2, 6}, {1, 2}, {3, 6}, {1, 3}, {4, 6}, {1, 4}, {5, 6}, {1, 5}, {6, 6}, {7, 6}, {1, 7}, {8, 6}, {1, 8}, {0, 7}, {0, 8}, {2, 7}, {2, 8} },
					{ {0, 7}, {1, 0}, {1, 1}, {2, 7}, {1, 2}, {3, 7}, {1, 3}, {4, 7}, {1, 4}, {5, 7}, {1, 5}, {6, 7}, {1, 6}, {7, 7}, {8, 7}, {1, 8}, {0, 6}, {0, 8}, {2, 6}, {2, 8} },
					{ {0, 8}, {1, 0}, {1, 1}, {2, 8}, {1, 2}, {3, 8}, {1, 3}, {4, 8}, {1, 4}, {5, 8}, {1, 5}, {6, 8}, {1, 6}, {7, 8}, {1, 7}, {8, 8}, {0, 6}, {0, 7}, {2, 6}, {2, 7} }
			},
			{
					{ {0, 0}, {1, 0}, {2, 1}, {2, 2}, {3, 0}, {2, 3}, {4, 0}, {2, 4}, {5, 0}, {2, 5}, {6, 0}, {2, 6}, {7, 0}, {2, 7}, {8, 0}, {2, 8}, {0, 1}, {0, 2}, {1, 1}, {1, 2} },
					{ {0, 1}, {2, 0}, {1, 1}, {2, 2}, {3, 1}, {2, 3}, {4, 1}, {2, 4}, {5, 1}, {2, 5}, {6, 1}, {2, 6}, {7, 1}, {2, 7}, {8, 1}, {2, 8}, {0, 0}, {0, 2}, {1, 0}, {1, 2} },
					{ {0, 2}, {2, 0}, {1, 2}, {2, 1}, {3, 2}, {2, 3}, {4, 2}, {2, 4}, {5, 2}, {2, 5}, {6, 2}, {2, 6}, {7, 2}, {2, 7}, {8, 2}, {2, 8}, {0, 0}, {0, 1}, {1, 0}, {1, 1} },
					{ {0, 3}, {2, 0}, {1, 3}, {2, 1}, {2, 2}, {3, 3}, {4, 3}, {2, 4}, {5, 3}, {2, 5}, {6, 3}, {2, 6}, {7, 3}, {2, 7}, {8, 3}, {2, 8}, {0, 4}, {0, 5}, {1, 4}, {1, 5} },
					{ {0, 4}, {2, 0}, {1, 4}, {2, 1}, {2, 2}, {3, 4}, {2, 3}, {4, 4}, {5, 4}, {2, 5}, {6, 4}, {2, 6}, {7, 4}, {2, 7}, {8, 4}, {2, 8}, {0, 3}, {0, 5}, {1, 3}, {1, 5} },
					{ {0, 5}, {2, 0}, {1, 5}, {2, 1}, {2, 2}, {3, 5}, {2, 3}, {4, 5}, {2, 4}, {5, 5}, {6, 5}, {2, 6}, {7, 5}, {2, 7}, {8, 5}, {2, 8}, {0, 3}, {0, 4}, {1, 3}, {1, 4} },
					{ {0, 6}, {2, 0}, {1, 6}, {2, 1}, {2, 2}, {3, 6}, {2, 3}, {4, 6}, {2, 4}, {5, 6}, {2, 5}, {6, 6}, {7, 6}, {2, 7}, {8, 6}, {2, 8}, {0, 7}, {0, 8}, {1, 7}, {1, 8} },
					{ {0, 7}, {2, 0}, {1, 7}, {2, 1}, {2, 2}, {3, 7}, {2, 3}, {4, 7}, {2, 4}, {5, 7}, {2, 5}, {6, 7}, {2, 6}, {7, 7}, {8, 7}, {2, 8}, {0, 6}, {0, 8}, {1, 6}, {1, 8} },
					{ {0, 8}, {2, 0}, {1, 8}, {2, 1}, {2, 2}, {3, 8}, {2, 3}, {4, 8}, {2, 4}, {5, 8}, {2, 5}, {6, 8}, {2, 6}, {7, 8}, {2, 7}, {8, 8}, {0, 6}, {0, 7}, {1, 6}, {1, 7} }
			},
			{
					{ {0, 0}, {1, 0}, {3, 1}, {2, 0}, {3, 2}, {3, 3}, {4, 0}, {3, 4}, {5, 0}, {3, 5}, {6, 0}, {3, 6}, {7, 0}, {3, 7}, {8, 0}, {3, 8}, {4, 1}, {4, 2}, {5, 1}, {5, 2} },
					{ {0, 1}, {3, 0}, {1, 1}, {2, 1}, {3, 2}, {3, 3}, {4, 1}, {3, 4}, {5, 1}, {3, 5}, {6, 1}, {3, 6}, {7, 1}, {3, 7}, {8, 1}, {3, 8}, {4, 0}, {4, 2}, {5, 0}, {5, 2} },
					{ {0, 2}, {3, 0}, {1, 2}, {3, 1}, {2, 2}, {3, 3}, {4, 2}, {3, 4}, {5, 2}, {3, 5}, {6, 2}, {3, 6}, {7, 2}, {3, 7}, {8, 2}, {3, 8}, {4, 0}, {4, 1}, {5, 0}, {5, 1} },
					{ {0, 3}, {3, 0}, {1, 3}, {3, 1}, {2, 3}, {3, 2}, {4, 3}, {3, 4}, {5, 3}, {3, 5}, {6, 3}, {3, 6}, {7, 3}, {3, 7}, {8, 3}, {3, 8}, {4, 4}, {4, 5}, {5, 4}, {5, 5} },
					{ {0, 4}, {3, 0}, {1, 4}, {3, 1}, {2, 4}, {3, 2}, {3, 3}, {4, 4}, {5, 4}, {3, 5}, {6, 4}, {3, 6}, {7, 4}, {3, 7}, {8, 4}, {3, 8}, {4, 3}, {4, 5}, {5, 3}, {5, 5} },
					{ {0, 5}, {3, 0}, {1, 5}, {3, 1}, {2, 5}, {3, 2}, {3, 3}, {4, 5}, {3, 4}, {5, 5}, {6, 5}, {3, 6}, {7, 5}, {3, 7}, {8, 5}, {3, 8}, {4, 3}, {4, 4}, {5, 3}, {5, 4} },
					{ {0, 6}, {3, 0}, {1, 6}, {3, 1}, {2, 6}, {3, 2}, {3, 3}, {4, 6}, {3, 4}, {5, 6}, {3, 5}, {6, 6}, {7, 6}, {3, 7}, {8, 6}, {3, 8}, {4, 7}, {4, 8}, {5, 7}, {5, 8} },
					{ {0, 7}, {3, 0}, {1, 7}, {3, 1}, {2, 7}, {3, 2}, {3, 3}, {4, 7}, {3, 4}, {5, 7}, {3, 5}, {6, 7}, {3, 6}, {7, 7}, {8, 7}, {3, 8}, {4, 6}, {4, 8}, {5, 6}, {5, 8} },
					{ {0, 8}, {3, 0}, {1, 8}, {3, 1}, {2, 8}, {3, 2}, {3, 3}, {4, 8}, {3, 4}, {5, 8}, {3, 5}, {6, 8}, {3, 6}, {7, 8}, {3, 7}, {8, 8}, {4, 6}, {4, 7}, {5, 6}, {5, 7} }
			},
			{
					{ {0, 0}, {1, 0}, {4, 1}, {2, 0}, {4, 2}, {3, 0}, {4, 3}, {4, 4}, {5, 0}, {4, 5}, {6, 0}, {4, 6}, {7, 0}, {4, 7}, {8, 0}, {4, 8}, {3, 1}, {3, 2}, {5, 1}, {5, 2} },
					{ {0, 1}, {4, 0}, {1, 1}, {2, 1}, {4, 2}, {3, 1}, {4, 3}, {4, 4}, {5, 1}, {4, 5}, {6, 1}, {4, 6}, {7, 1}, {4, 7}, {8, 1}, {4, 8}, {3, 0}, {3, 2}, {5, 0}, {5, 2} },
					{ {0, 2}, {4, 0}, {1, 2}, {4, 1}, {2, 2}, {3, 2}, {4, 3}, {4, 4}, {5, 2}, {4, 5}, {6, 2}, {4, 6}, {7, 2}, {4, 7}, {8, 2}, {4, 8}, {3, 0}, {3, 1}, {5, 0}, {5, 1} },
					{ {0, 3}, {4, 0}, {1, 3}, {4, 1}, {2, 3}, {4, 2}, {3, 3}, {4, 4}, {5, 3}, {4, 5}, {6, 3}, {4, 6}, {7, 3}, {4, 7}, {8, 3}, {4, 8}, {3, 4}, {3, 5}, {5, 4}, {5, 5} },
					{ {0, 4}, {4, 0}, {1, 4}, {4, 1}, {2, 4}, {4, 2}, {3, 4}, {4, 3}, {5, 4}, {4, 5}, {6, 4}, {4, 6}, {7, 4}, {4, 7}, {8, 4}, {4, 8}, {3, 3}, {3, 5}, {5, 3}, {5, 5} },
					{ {0, 5}, {4, 0}, {1, 5}, {4, 1}, {2, 5}, {4, 2}, {3, 5}, {4, 3}, {4, 4}, {5, 5}, {6, 5}, {4, 6}, {7, 5}, {4, 7}, {8, 5}, {4, 8}, {3, 3}, {3, 4}, {5, 3}, {5, 4} },
					{ {0, 6}, {4, 0}, {1, 6}, {4, 1}, {2, 6}, {4, 2}, {3, 6}, {4, 3}, {4, 4}, {5, 6}, {4, 5}, {6, 6}, {7, 6}, {4, 7}, {8, 6}, {4, 8}, {3, 7}, {3, 8}, {5, 7}, {5, 8} },
					{ {0, 7}, {4, 0}, {1, 7}, {4, 1}, {2, 7}, {4, 2}, {3, 7}, {4, 3}, {4, 4}, {5, 7}, {4, 5}, {6, 7}, {4, 6}, {7, 7}, {8, 7}, {4, 8}, {3, 6}, {3, 8}, {5, 6}, {5, 8} },
					{ {0, 8}, {4, 0}, {1, 8}, {4, 1}, {2, 8}, {4, 2}, {3, 8}, {4, 3}, {4, 4}, {5, 8}, {4, 5}, {6, 8}, {4, 6}, {7, 8}, {4, 7}, {8, 8}, {3, 6}, {3, 7}, {5, 6}, {5, 7} }
			},
			{
					{ {0, 0}, {1, 0}, {5, 1}, {2, 0}, {5, 2}, {3, 0}, {5, 3}, {4, 0}, {5, 4}, {5, 5}, {6, 0}, {5, 6}, {7, 0}, {5, 7}, {8, 0}, {5, 8}, {3, 1}, {3, 2}, {4, 1}, {4, 2} },
					{ {0, 1}, {5, 0}, {1, 1}, {2, 1}, {5, 2}, {3, 1}, {5, 3}, {4, 1}, {5, 4}, {5, 5}, {6, 1}, {5, 6}, {7, 1}, {5, 7}, {8, 1}, {5, 8}, {3, 0}, {3, 2}, {4, 0}, {4, 2} },
					{ {0, 2}, {5, 0}, {1, 2}, {5, 1}, {2, 2}, {3, 2}, {5, 3}, {4, 2}, {5, 4}, {5, 5}, {6, 2}, {5, 6}, {7, 2}, {5, 7}, {8, 2}, {5, 8}, {3, 0}, {3, 1}, {4, 0}, {4, 1} },
					{ {0, 3}, {5, 0}, {1, 3}, {5, 1}, {2, 3}, {5, 2}, {3, 3}, {4, 3}, {5, 4}, {5, 5}, {6, 3}, {5, 6}, {7, 3}, {5, 7}, {8, 3}, {5, 8}, {3, 4}, {3, 5}, {4, 4}, {4, 5} },
					{ {0, 4}, {5, 0}, {1, 4}, {5, 1}, {2, 4}, {5, 2}, {3, 4}, {5, 3}, {4, 4}, {5, 5}, {6, 4}, {5, 6}, {7, 4}, {5, 7}, {8, 4}, {5, 8}, {3, 3}, {3, 5}, {4, 3}, {4, 5} },
					{ {0, 5}, {5, 0}, {1, 5}, {5, 1}, {2, 5}, {5, 2}, {3, 5}, {5, 3}, {4, 5}, {5, 4}, {6, 5}, {5, 6}, {7, 5}, {5, 7}, {8, 5}, {5, 8}, {3, 3}, {3, 4}, {4, 3}, {4, 4} },
					{ {0, 6}, {5, 0}, {1, 6}, {5, 1}, {2, 6}, {5, 2}, {3, 6}, {5, 3}, {4, 6}, {5, 4}, {5, 5}, {6, 6}, {7, 6}, {5, 7}, {8, 6}, {5, 8}, {3, 7}, {3, 8}, {4, 7}, {4, 8} },
					{ {0, 7}, {5, 0}, {1, 7}, {5, 1}, {2, 7}, {5, 2}, {3, 7}, {5, 3}, {4, 7}, {5, 4}, {5, 5}, {6, 7}, {5, 6}, {7, 7}, {8, 7}, {5, 8}, {3, 6}, {3, 8}, {4, 6}, {4, 8} },
					{ {0, 8}, {5, 0}, {1, 8}, {5, 1}, {2, 8}, {5, 2}, {3, 8}, {5, 3}, {4, 8}, {5, 4}, {5, 5}, {6, 8}, {5, 6}, {7, 8}, {5, 7}, {8, 8}, {3, 6}, {3, 7}, {4, 6}, {4, 7} }
			},
			{
					{ {0, 0}, {1, 0}, {6, 1}, {2, 0}, {6, 2}, {3, 0}, {6, 3}, {4, 0}, {6, 4}, {5, 0}, {6, 5}, {6, 6}, {7, 0}, {6, 7}, {8, 0}, {6, 8}, {7, 1}, {7, 2}, {8, 1}, {8, 2} },
					{ {0, 1}, {6, 0}, {1, 1}, {2, 1}, {6, 2}, {3, 1}, {6, 3}, {4, 1}, {6, 4}, {5, 1}, {6, 5}, {6, 6}, {7, 1}, {6, 7}, {8, 1}, {6, 8}, {7, 0}, {7, 2}, {8, 0}, {8, 2} },
					{ {0, 2}, {6, 0}, {1, 2}, {6, 1}, {2, 2}, {3, 2}, {6, 3}, {4, 2}, {6, 4}, {5, 2}, {6, 5}, {6, 6}, {7, 2}, {6, 7}, {8, 2}, {6, 8}, {7, 0}, {7, 1}, {8, 0}, {8, 1} },
					{ {0, 3}, {6, 0}, {1, 3}, {6, 1}, {2, 3}, {6, 2}, {3, 3}, {4, 3}, {6, 4}, {5, 3}, {6, 5}, {6, 6}, {7, 3}, {6, 7}, {8, 3}, {6, 8}, {7, 4}, {7, 5}, {8, 4}, {8, 5} },
					{ {0, 4}, {6, 0}, {1, 4}, {6, 1}, {2, 4}, {6, 2}, {3, 4}, {6, 3}, {4, 4}, {5, 4}, {6, 5}, {6, 6}, {7, 4}, {6, 7}, {8, 4}, {6, 8}, {7, 3}, {7, 5}, {8, 3}, {8, 5} },
					{ {0, 5}, {6, 0}, {1, 5}, {6, 1}, {2, 5}, {6, 2}, {3, 5}, {6, 3}, {4, 5}, {6, 4}, {5, 5}, {6, 6}, {7, 5}, {6, 7}, {8, 5}, {6, 8}, {7, 3}, {7, 4}, {8, 3}, {8, 4} },
					{ {0, 6}, {6, 0}, {1, 6}, {6, 1}, {2, 6}, {6, 2}, {3, 6}, {6, 3}, {4, 6}, {6, 4}, {5, 6}, {6, 5}, {7, 6}, {6, 7}, {8, 6}, {6, 8}, {7, 7}, {7, 8}, {8, 7}, {8, 8} },
					{ {0, 7}, {6, 0}, {1, 7}, {6, 1}, {2, 7}, {6, 2}, {3, 7}, {6, 3}, {4, 7}, {6, 4}, {5, 7}, {6, 5}, {6, 6}, {7, 7}, {8, 7}, {6, 8}, {7, 6}, {7, 8}, {8, 6}, {8, 8} },
					{ {0, 8}, {6, 0}, {1, 8}, {6, 1}, {2, 8}, {6, 2}, {3, 8}, {6, 3}, {4, 8}, {6, 4}, {5, 8}, {6, 5}, {6, 6}, {7, 8}, {6, 7}, {8, 8}, {7, 6}, {7, 7}, {8, 6}, {8, 7} }
			},
			{
					{ {0, 0}, {1, 0}, {7, 1}, {2, 0}, {7, 2}, {3, 0}, {7, 3}, {4, 0}, {7, 4}, {5, 0}, {7, 5}, {6, 0}, {7, 6}, {7, 7}, {8, 0}, {7, 8}, {6, 1}, {6, 2}, {8, 1}, {8, 2} },
					{ {0, 1}, {7, 0}, {1, 1}, {2, 1}, {7, 2}, {3, 1}, {7, 3}, {4, 1}, {7, 4}, {5, 1}, {7, 5}, {6, 1}, {7, 6}, {7, 7}, {8, 1}, {7, 8}, {6, 0}, {6, 2}, {8, 0}, {8, 2} },
					{ {0, 2}, {7, 0}, {1, 2}, {7, 1}, {2, 2}, {3, 2}, {7, 3}, {4, 2}, {7, 4}, {5, 2}, {7, 5}, {6, 2}, {7, 6}, {7, 7}, {8, 2}, {7, 8}, {6, 0}, {6, 1}, {8, 0}, {8, 1} },
					{ {0, 3}, {7, 0}, {1, 3}, {7, 1}, {2, 3}, {7, 2}, {3, 3}, {4, 3}, {7, 4}, {5, 3}, {7, 5}, {6, 3}, {7, 6}, {7, 7}, {8, 3}, {7, 8}, {6, 4}, {6, 5}, {8, 4}, {8, 5} },
					{ {0, 4}, {7, 0}, {1, 4}, {7, 1}, {2, 4}, {7, 2}, {3, 4}, {7, 3}, {4, 4}, {5, 4}, {7, 5}, {6, 4}, {7, 6}, {7, 7}, {8, 4}, {7, 8}, {6, 3}, {6, 5}, {8, 3}, {8, 5} },
					{ {0, 5}, {7, 0}, {1, 5}, {7, 1}, {2, 5}, {7, 2}, {3, 5}, {7, 3}, {4, 5}, {7, 4}, {5, 5}, {6, 5}, {7, 6}, {7, 7}, {8, 5}, {7, 8}, {6, 3}, {6, 4}, {8, 3}, {8, 4} },
					{ {0, 6}, {7, 0}, {1, 6}, {7, 1}, {2, 6}, {7, 2}, {3, 6}, {7, 3}, {4, 6}, {7, 4}, {5, 6}, {7, 5}, {6, 6}, {7, 7}, {8, 6}, {7, 8}, {6, 7}, {6, 8}, {8, 7}, {8, 8} },
					{ {0, 7}, {7, 0}, {1, 7}, {7, 1}, {2, 7}, {7, 2}, {3, 7}, {7, 3}, {4, 7}, {7, 4}, {5, 7}, {7, 5}, {6, 7}, {7, 6}, {8, 7}, {7, 8}, {6, 6}, {6, 8}, {8, 6}, {8, 8} },
					{ {0, 8}, {7, 0}, {1, 8}, {7, 1}, {2, 8}, {7, 2}, {3, 8}, {7, 3}, {4, 8}, {7, 4}, {5, 8}, {7, 5}, {6, 8}, {7, 6}, {7, 7}, {8, 8}, {6, 6}, {6, 7}, {8, 6}, {8, 7} }
			},
			{
					{ {0, 0}, {1, 0}, {8, 1}, {2, 0}, {8, 2}, {3, 0}, {8, 3}, {4, 0}, {8, 4}, {5, 0}, {8, 5}, {6, 0}, {8, 6}, {7, 0}, {8, 7}, {8, 8}, {6, 1}, {6, 2}, {7, 1}, {7, 2} },
					{ {0, 1}, {8, 0}, {1, 1}, {2, 1}, {8, 2}, {3, 1}, {8, 3}, {4, 1}, {8, 4}, {5, 1}, {8, 5}, {6, 1}, {8, 6}, {7, 1}, {8, 7}, {8, 8}, {6, 0}, {6, 2}, {7, 0}, {7, 2} },
					{ {0, 2}, {8, 0}, {1, 2}, {8, 1}, {2, 2}, {3, 2}, {8, 3}, {4, 2}, {8, 4}, {5, 2}, {8, 5}, {6, 2}, {8, 6}, {7, 2}, {8, 7}, {8, 8}, {6, 0}, {6, 1}, {7, 0}, {7, 1} },
					{ {0, 3}, {8, 0}, {1, 3}, {8, 1}, {2, 3}, {8, 2}, {3, 3}, {4, 3}, {8, 4}, {5, 3}, {8, 5}, {6, 3}, {8, 6}, {7, 3}, {8, 7}, {8, 8}, {6, 4}, {6, 5}, {7, 4}, {7, 5} },
					{ {0, 4}, {8, 0}, {1, 4}, {8, 1}, {2, 4}, {8, 2}, {3, 4}, {8, 3}, {4, 4}, {5, 4}, {8, 5}, {6, 4}, {8, 6}, {7, 4}, {8, 7}, {8, 8}, {6, 3}, {6, 5}, {7, 3}, {7, 5} },
					{ {0, 5}, {8, 0}, {1, 5}, {8, 1}, {2, 5}, {8, 2}, {3, 5}, {8, 3}, {4, 5}, {8, 4}, {5, 5}, {6, 5}, {8, 6}, {7, 5}, {8, 7}, {8, 8}, {6, 3}, {6, 4}, {7, 3}, {7, 4} },
					{ {0, 6}, {8, 0}, {1, 6}, {8, 1}, {2, 6}, {8, 2}, {3, 6}, {8, 3}, {4, 6}, {8, 4}, {5, 6}, {8, 5}, {6, 6}, {7, 6}, {8, 7}, {8, 8}, {6, 7}, {6, 8}, {7, 7}, {7, 8} },
					{ {0, 7}, {8, 0}, {1, 7}, {8, 1}, {2, 7}, {8, 2}, {3, 7}, {8, 3}, {4, 7}, {8, 4}, {5, 7}, {8, 5}, {6, 7}, {8, 6}, {7, 7}, {8, 8}, {6, 6}, {6, 8}, {7, 6}, {7, 8} },
					{ {0, 8}, {8, 0}, {1, 8}, {8, 1}, {2, 8}, {8, 2}, {3, 8}, {8, 3}, {4, 8}, {8, 4}, {5, 8}, {8, 5}, {6, 8}, {8, 6}, {7, 8}, {8, 7}, {6, 6}, {6, 7}, {7, 6}, {7, 7} }
			}
	};
	
	private static final int DEFAULT_START_X = 0;
	private static final int DEFAULT_START_Y = 0;
	
	private static final int MINIMAL_REMOVE_NUMBERS_AMOUNT = 1;
	private static final Random REMOVE_NUMBERS_RANDOM = new Random();
	
	private static final int RANDOM_SOLVE_ITERATIONS = 10;
	private static final Random RANDOM_SOLVE_RANDOM = new Random();
	
	private static final int DEFAULT_SOLUTION_AMOUNT_LIMIT = 100;
	private static final int UNIQUELY_SOLVABLE_SOLUTION_AMOUNT = 1;
	private static final int FULL_BOARD_SOLUTION_AMOUNT = 1;
	
	private static final String TO_STRING_MISSING_NUMBER = ".";
	private static final String TO_STRING_NUMBER_SEPARATOR = " ";
	private static final String TO_STRING_LINE_SEPARATOR = System.lineSeparator();
	
	private final int[][] numbers = new int[LENGTH][LENGTH];
	private final int[][][] numberConstraints = new int[LENGTH][LENGTH][LARGEST_NUMBER + 1];
	
	private int numberAmount;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for(int y = 0; y < LENGTH; y++) {
			if(y != 0 && y % BOX_LENGTH == 0) builder.append(TO_STRING_LINE_SEPARATOR);
			
			for(int x = 0; x < LENGTH; x++) {
				int number = numbers[x][y];
				
				if(x != 0 && x % BOX_LENGTH == 0) {
					builder.append(TO_STRING_NUMBER_SEPARATOR);
					builder.append(TO_STRING_NUMBER_SEPARATOR);
				}
				
				String numberString = number == MISSING_NUMBER ? TO_STRING_MISSING_NUMBER : String.valueOf(number);
				builder.append(numberString);
				builder.append(TO_STRING_NUMBER_SEPARATOR);
			}
			
			builder.append(TO_STRING_LINE_SEPARATOR);
		}
		
		return builder.toString();
	}
	
	public boolean uniquelySolvable() {
		return solutionAmount(UNIQUELY_SOLVABLE_SOLUTION_AMOUNT + 1) == UNIQUELY_SOLVABLE_SOLUTION_AMOUNT;
	}
	
	public int solutionAmount() {
		return solutionAmount(DEFAULT_SOLUTION_AMOUNT_LIMIT);
	}
	
	public int solutionAmount(int amountLimit) {
		return solutionAmount(DEFAULT_START_X, DEFAULT_START_Y, amountLimit);
	}
	
	private int solutionAmount(int startX, int startY, int amountLimit) {
		if(isFull()) return FULL_BOARD_SOLUTION_AMOUNT;
		
		while(numbers[startX][startY] != MISSING_NUMBER) {
			
			startX++;
			if(startX == LENGTH) {
				startX = DEFAULT_START_X;
				startY++;
			}
		}
		
		int amount = 0;
		
		for(int number = SMALLEST_NUMBER; number <= LARGEST_NUMBER; number++) {
			if(placeNumber(startX, startY, number)) {
				
				amount += solutionAmount(startX, startY, amountLimit - amount);
				removeNumber(startX, startY, number);
				
				if(amount >= amountLimit) return amount;
			}
		}
		
		return amount;
	}
	
	public boolean solveRandomly() {
		return solveRandomly(DEFAULT_START_X, DEFAULT_START_Y);
	}
	
	private boolean solveRandomly(int startX, int startY) {
		if(isFull()) return true;
		
		while(numbers[startX][startY] != MISSING_NUMBER) {
			
			startX++;
			if(startX == LENGTH) {
				startX = DEFAULT_START_X;
				startY++;
			}
		}
		
		for(int i = 0; i < RANDOM_SOLVE_ITERATIONS; i++) {
			int number = RANDOM_SOLVE_RANDOM.nextInt(LARGEST_NUMBER - SMALLEST_NUMBER + 1) + SMALLEST_NUMBER;
			
			if(placeNumber(startX, startY, number)) {
				
				if(solveRandomly(startX, startY)) return true;
				removeNumber(startX, startY, number);
			}
		}
		
		return false;
	}
	
	public boolean solve() {
		return solve(DEFAULT_START_X, DEFAULT_START_Y);
	}
	
	private boolean solve(int startX, int startY) {
		if(isFull()) return true;
		
		while(numbers[startX][startY] != MISSING_NUMBER) {
			
			startX++;
			if(startX == LENGTH) {
				startX = DEFAULT_START_X;
				startY++;
			}
		}
		
		for(int number = SMALLEST_NUMBER; number <= LARGEST_NUMBER; number++) {
			if(placeNumber(startX, startY, number)) {
				
				if(solve(startX, startY)) return true;
				removeNumber(startX, startY, number);
			}
		}
		
		return false;
	}
	
	private boolean placeNumber(int x, int y, int number) {
		if(numberConstraints[x][y][number] != UNCONSTRAINED_NUMBER_CONSTRAINT_AMOUNT) return false;
		
		numbers[x][y] = number;
		numberAmount++;
		
		for(int[] position : CONSTRAINED_NUMBER_POSITIONS[x][y]) {
			int x2 = position[0];
			int y2 = position[1];
			
			numberConstraints[x2][y2][number]++;
		}
		
		return true;
	}
	
	public boolean removeNumbers(int amount) {
		if(amount < MINIMAL_REMOVE_NUMBERS_AMOUNT) return true;
		
		int iterations = numberAmount();
		for(int i = 0; i < iterations; i++) {
			
			int x = REMOVE_NUMBERS_RANDOM.nextInt(LENGTH);
			int y = REMOVE_NUMBERS_RANDOM.nextInt(LENGTH);
			int number = numbers[x][y];
			
			if(number != MISSING_NUMBER) {
				removeNumber(x, y, number);
				
				if(uniquelySolvable() && removeNumbers(amount - 1)) return true;
				
				placeNumber(x, y, number);
			}
		}
		
		return false;
	}
	
	public void removeNumber(int x, int y, int number) {
		numbers[x][y] = MISSING_NUMBER;
		numberAmount--;
		
		for(int[] position : CONSTRAINED_NUMBER_POSITIONS[x][y]) {
			int x2 = position[0];
			int y2 = position[1];
			
			numberConstraints[x2][y2][number]--;
		}
	}
	
	public boolean isFull() {
		return numberAmount == FULL_BOARD_NUMBER_AMOUNT;
	}
	
	public boolean isEmpty() {
		return numberAmount == EMPTY_BOARD_NUMBER_AMOUNT;
	}
	
	public int numberAmount() {
		return numberAmount;
	}
	
}