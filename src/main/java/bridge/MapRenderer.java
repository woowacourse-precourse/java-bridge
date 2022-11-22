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
	private final List<String> movingStack;
	private final int lastIndex;
	private final boolean isCorrect;
	private StringBuilder upperRow;
	private StringBuilder lowerRow;
	private String map;

	public MapRenderer(List<String> bridge, List<String> movingStack) {
		this.movingStack = movingStack;
		this.lastIndex = movingStack.size() - ONE;
		this.isCorrect = bridge.get(lastIndex).equals(movingStack.get(lastIndex));

		init();
		addEntrance();
		render();
	}

	private void render() {
		if (movingStack.size() == ONE) {
			map = renderWhenSizeIsOne();
		}
		if (movingStack.size() != ONE) {
			map = renderWhenSizeBiggerThanOne();
		}
	}

	private String renderWhenSizeIsOne() {
		addLastCell();
		addExit();
		return upperRow.toString() + LINE_BREAK_CHARACTER + lowerRow.toString();
	}

	private String renderWhenSizeBiggerThanOne() {
		for (int index = FIRST_INDEX; index < lastIndex; index++) {
			addCircle(index);
			addDivisionLine();
		}
		addLastCell();
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

	private void addLastCell() {
		if (isCorrect) {
			addCircle(lastIndex);
		}
		if (!isCorrect) {
			addCross();
		}
	}

	private void addCircle(int index) {
		if (movingStack.get(index).equals(Constant.UPPER_POSITION))
			addCircleToUpperRow();
		if (movingStack.get(index).equals(Constant.LOWER_POSITION))
			addCircleToLowerRow();
	}

	private void addCross() {
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
