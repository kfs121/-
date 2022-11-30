package tetrisGame;

import java.awt.*;
import java.util.Random;

public class TetrominoFactory {
	private static Random rand;
	private final static int START_X = (int) Math.ceil(TetrisGrid.GRID_WIDTH / 2.0);
	private final static int START_Y = 2;
	private static final Color[] tetrominoColors;
	
	static{
		tetrominoColors = new Color[] {
				Color.YELLOW, // O
				Color.CYAN, // I
				Color.GREEN, // S
				Color.RED, // Z
				Color.ORANGE, // L
				Color.BLUE, // J
				new Color(128, 0, 128), // T (purple)
				Color.MAGENTA
		};
		rand = new Random();
	}
	
	public static Tetromino getNewTetromino() {
		int next = rand.nextInt(7);
		switch (next) {
		case 0:
			return new O(START_X, START_Y, tetrominoColors[next]);
		case 1:
			return new I(START_X, START_Y, tetrominoColors[next]);
		case 2:
			return new S(START_X, START_Y, tetrominoColors[next]);
		case 3:
			return new Z(START_X, START_Y, tetrominoColors[next]);
		case 4:
			return new L(START_X, START_Y, tetrominoColors[next]);
		case 5:
			return new J(START_X, START_Y, tetrominoColors[next]);
		case 6:
			return new T(START_X, START_Y, tetrominoColors[next]);
		case 7:
			return new H(START_X, START_Y, tetrominoColors[next]);
		default:
			return null;

		}
	}
}
