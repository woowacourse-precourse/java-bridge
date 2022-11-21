package bridge;

import dto.BridgeDto;
import dto.IndexDto;
import dto.MapDto;
import dto.MovingDto;

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

	public MapRenderer(BridgeDto bridgeDto, IndexDto indexDto, MovingDto movingDto) {
		Bridge bridge = new Bridge(bridgeDto.getBridge());
		int index = indexDto.getIndex();
		Moving moving = new Moving(movingDto.getMoving());

		init();
		addEntrance();
		render(bridge, index, moving);
	}

	private void render(Bridge bridge, int index, Moving moving) {
		boolean isCorrectMoving = isCorrectMoving(bridge, index, moving);
		if (isFirstCell(index)) {
			map = renderWhenSizeIsOne(bridge, index, isCorrectMoving);
		}
		if (!isFirstCell(index)) {
			map = renderWhenSizeBiggerThanOne(bridge, index, isCorrectMoving);
		}
	}

	private boolean isCorrectMoving(Bridge bridge, int index, Moving moving) {
		return bridge.isUpPositionAt(index) == moving.isUpPosition();
	}

	public MapDto toMapDto() {
		return new MapDto(map);
	}

	private String renderWhenSizeIsOne(Bridge bridge, int index, boolean isCorrectMoving) {
		addLastCell(bridge, index, isCorrectMoving);
		addExit();
		return upperRow.toString() + LINE_BREAK_CHARACTER + lowerRow.toString();
	}

	private String renderWhenSizeBiggerThanOne(Bridge bridge, int index, boolean isCorrectMoving) {
		for (int idx = FIRST_INDEX; idx < index; idx++) {
			addCircle(bridge, idx);
			addDivisionLine();
		}
		addLastCell(bridge, index, isCorrectMoving);
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

	private void addLastCell(Bridge bridge, int index, boolean isCorrectMoving) {
		if (isCorrectMoving) {
			addCircle(bridge, index);
		}
		if (!isCorrectMoving) {
			addCross(bridge, index);
		}
	}

	private boolean isFirstCell(int index) {
		return index == FIRST_INDEX;
	}

	private void addCircle(Bridge bridge, int index) {
		if (bridge.isUpPositionAt(index))
			addCircleToUpperRow();
		if (!bridge.isUpPositionAt(index))
			addCircleToLowerRow();
	}

	private void addCross(Bridge bridge, int index) {
		if (bridge.isUpPositionAt(index)) {
			addCrossToLowerRow();
		}
		if (!bridge.isUpPositionAt(index)) {
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
