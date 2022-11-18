package constant;

public enum Cell {
	UPPER_CELL(1, "U"),
	LOWER_CELL(0, "D");

	private final int number;
	private final String cellPosition;

	Cell(int number, String cellPosition) {
		this.number = number;
		this.cellPosition = cellPosition;
	}

	public static boolean isUpper(int number) {
		return number == UPPER_CELL.number;
	}

	public static boolean isLower(int number) {
		return number == LOWER_CELL.number;
	}

	public static String upperPosition() {
		return UPPER_CELL.cellPosition;
	}

	public static String lowerPosition() {
		return LOWER_CELL.cellPosition;
	}

}
