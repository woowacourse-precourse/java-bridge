package bridge;

import java.util.List;

import bridgeConstant.Cell;
import dto.MapDto;

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

	StringBuilder upperRow;
	StringBuilder lowerRow;

	String map;

	public MapRenderer(List<String> partOfBridge, boolean isCorrectMoving) {
		init();
		addEntrance();
		if (isSizeOne(partOfBridge)) {
			map = renderWhenSizeIsOne(partOfBridge, isCorrectMoving);
		}
		if (!isSizeOne(partOfBridge)) {
			map = renderWhenSizeBiggerThanOne(partOfBridge, isCorrectMoving);
		}
	}

	public MapDto toMapDto() {
		return new MapDto(map);
	}

	private String renderWhenSizeIsOne(List<String> partOfBridge, boolean isCorrectMoving) {
		addLastCell(partOfBridge.get(FIRST_INDEX), isCorrectMoving);
		addExit();
		return upperRow.toString() + LINE_BREAK_CHARACTER + lowerRow.toString();
	}

	private String renderWhenSizeBiggerThanOne(List<String> partOfBridge, boolean isCorrectMoving) {
		int lastIndex = partOfBridge.size() - ONE;
		partOfBridge.subList(FIRST_INDEX, lastIndex).forEach(cell -> {
			addCircle(cell);
			addDivisionLine();
		});
		addLastCell(partOfBridge.get(lastIndex), isCorrectMoving);
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

	private void addLastCell(String cell, boolean isCorrectMoving) {
		if (isCorrectMoving) {
			addCircle(cell);
		}
		if (!isCorrectMoving) {
			addCross(cell);
		}
	}

	private boolean isSizeOne(List<String> partOfBridge) {
		return partOfBridge.size() == 1;
	}

	private void addCircle(String cell) {
		if (cell.equals(Cell.upPosition()))
			addCircleToUpperRow();
		if (cell.equals(Cell.downPosition()))
			addCircleToLowerRow();
	}

	private void addCross(String cell) {
		if (cell.equals(Cell.upPosition())) {
			addCrossToLowerRow();
		}
		if (cell.equals(Cell.downPosition())) {
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
}
