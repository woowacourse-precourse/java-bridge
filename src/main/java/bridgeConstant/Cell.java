package bridgeConstant;

public enum Cell {
	UP(1, Constant.UPPER_POSITION),
	DOWN(0, Constant.LOWER_POSITION);

	private final int number;
	private final String position;

	Cell(int number, String position) {
		this.number = number;
		this.position = position;
	}

	public static String convertToPosition(int number) {
		if (number == UP.number) {
			return UP.position;
		}
		return DOWN.position;
	}
}
