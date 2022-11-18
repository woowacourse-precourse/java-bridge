package bridge;

public class Marking {
	private final String START = "[";
	private final String END = "]";
	private final String BAR = " | ";
	private final String SUCCESS = " O ";
	private final String FAIL = " X ";
	private final String NOTHING = "   ";
	private final String UPPER_CELL = "U";
	private final String LOWER_CELL = "D";

	private StringBuilder upperCellBuilder = new StringBuilder();
	private StringBuilder lowerCellBuilder = new StringBuilder();

	public String markingUpperCell(String bridgeLetter) {
		upperCellBuilder.append(START);
		lowerCellBuilder.append(START);
		if (bridgeLetter.equals(UPPER_CELL)) {
			upperCellBuilder.append(SUCCESS);
		}
		if (!bridgeLetter.equals(UPPER_CELL)) {
			upperCellBuilder.append(FAIL);
		}
		lowerCellBuilder.append(NOTHING);
		upperCellBuilder.append(END);
		lowerCellBuilder.append(END);
		return upperCellBuilder.toString();
	}

	public String markingLowerCell(String bridgeLetter) {
		upperCellBuilder.append(START);
		lowerCellBuilder.append(START);
		if (bridgeLetter.equals(LOWER_CELL)) {
			lowerCellBuilder.append(SUCCESS);
		}
		if (!bridgeLetter.equals(LOWER_CELL)) {
			lowerCellBuilder.append(FAIL);
		}
		upperCellBuilder.append(NOTHING);
		upperCellBuilder.append(END);
		lowerCellBuilder.append(END);
		return lowerCellBuilder.toString();
	}

	public String getUpperCell() {
		return upperCellBuilder.toString();
	}

	public String getLowerCell() {
		return lowerCellBuilder.toString();
	}
}
