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

	public static boolean isUp(int number) {
		return number == UP.number;
	}

	public static boolean isDown(int number) {
		return number == DOWN.number;
	}

	public static String upPosition() {
		return UP.position;
	}

	public static String downPosition() {
		return DOWN.position;
	}

}
