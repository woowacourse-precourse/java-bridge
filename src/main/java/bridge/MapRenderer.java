package bridge;

import java.util.List;

import bridgeConstant.Constant;

public class MapRenderer {
	private static final String ENTRANCE = "[";
	private static final String EXIT = "]";
	private static final String DIVISION_LINE = "|";
	private static final String CIRCLE = " O ";
	private static final String CROSS = " X ";
	private static final String SPACE = "   ";
	private static final String LINE_BREAK_CHARACTER = "\n";
	private static final int ONE = 1;
	private static final int FIRST_INDEX = 0;

	private StringBuilder upperRow;
	private StringBuilder lowerRow;
	private String map;

	public MapRenderer(List<String> bridge, List<String> movingStack) {
		int lastIndex = movingStack.size() - ONE;
		boolean isCorrect = bridge.get(lastIndex).equals(movingStack.get(lastIndex));

		init();
		addEntrance();
		render(lastIndex, movingStack, isCorrect);
	}

	private void render(int lastIndex, List<String> movingStack, boolean isCorrect) {
		if (movingStack.size() == ONE) {
			map = renderWhenSizeIsOne(lastIndex, movingStack, isCorrect);
		}
		if (movingStack.size() != ONE) {
			map = renderWhenSizeBiggerThanOne(lastIndex, movingStack, isCorrect);
		}
	}

	private String renderWhenSizeIsOne(int lastIndex, List<String> movingStack, boolean isCorrect) {
		addLastCell(lastIndex, movingStack, isCorrect);
		addExit();
		return upperRow.toString() + LINE_BREAK_CHARACTER + lowerRow.toString();
	}

	private String renderWhenSizeBiggerThanOne(int lastIndex, List<String> movingStack, boolean isCorrect) {
		for (int index = FIRST_INDEX; index < lastIndex; index++) {
			addCircle(index, movingStack);
			addDivisionLine();
		}
		addLastCell(lastIndex, movingStack, isCorrect);
		addExit();
		return upperRow.toString() + LINE_BREAK_CHARACTER + lowerRow.toString();
	}

	private void init() {
		upperRow = new StringBuilder();
		lowerRow = new StringBuilder();
	}

	private void addEntrance() {
		upperRow.append(ENTRANCE);
		lowerRow.append(ENTRANCE);
	}

	private void addExit() {
		upperRow.append(EXIT);
		lowerRow.append(EXIT);
	}

	private void addDivisionLine() {
		upperRow.append(DIVISION_LINE);
		lowerRow.append(DIVISION_LINE);
	}

	private void addLastCell(int lastIndex, List<String> movingStack, boolean isCorrect) {
		if (isCorrect) {
			addCircle(lastIndex, movingStack);
		}
		if (!isCorrect) {
			addCross(lastIndex, movingStack);
		}
	}

	private void addCircle(int index, List<String> movingStack) {
		if (movingStack.get(index).equals(Constant.UPPER_POSITION))
			addCircleToUpperRow();
		if (movingStack.get(index).equals(Constant.LOWER_POSITION))
			addCircleToLowerRow();
	}

	private void addCross(int lastIndex, List<String> movingStack) {
		if (movingStack.get(lastIndex).equals(Constant.LOWER_POSITION)) {
			addCrossToLowerRow();
		}
		if (movingStack.get(lastIndex).equals(Constant.UPPER_POSITION)) {
			addCrossToUpperRow();
		}
	}

	private void addCircleToUpperRow() {
		upperRow.append(CIRCLE);
		lowerRow.append(SPACE);
	}

	private void addCircleToLowerRow() {
		upperRow.append(SPACE);
		lowerRow.append(CIRCLE);
	}

	private void addCrossToLowerRow() {
		upperRow.append(SPACE);
		lowerRow.append(CROSS);
	}

	private void addCrossToUpperRow() {
		upperRow.append(CROSS);
		lowerRow.append(SPACE);
	}

	public String getMap() {
		return map;
	}
}
