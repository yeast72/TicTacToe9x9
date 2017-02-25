package softpec_ticTest;

public class Board {
	public static final int BOARD_SIZE = 9;
	private Symbol[][] map;
	public static final String STRING_EMPTY = "_";
	
	public Board() {
		setMap(new Symbol[BOARD_SIZE][BOARD_SIZE]);
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				getMap()[i][j] = new Symbol(STRING_EMPTY);
			}
		}
	}

	public void placeSymbol(Symbol symbol, int row, int col) {
		getMap()[row - 1][col - 1] = symbol;

	}

	public Symbol getSymbol(int row, int col) {
		return getMap()[row - 1][col - 1];
	}

	public void printBoard() {
		System.out.println("0 1 2 3 4 5 6 7 8 9");
		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.print(i + 1 + " ");
			for (int j = 0; j < BOARD_SIZE; j++) {

				System.out.print(getMap()[i][j].getValue() + " ");
			}
			System.out.println();
		}
	}

	public boolean isEmpty(int row, int col) {
		if(row > BOARD_SIZE || col > BOARD_SIZE)
			return false;
		else if (getMap()[row - 1][col - 1].getValue().equals(STRING_EMPTY) || row == -1 && col == -1 ) {
			return true;
		}
		return false;
	}

	public Symbol[][] getMap() {
		return map;
	}

	public void setMap(Symbol[][] map) {
		this.map = map;
	}
}