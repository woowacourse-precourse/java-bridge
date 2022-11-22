package bridge.domain;

import static bridge.constant.Constant.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum BridgeColumn {
	UP("U", 1),
	DOWN("D", 0);

	private final String mark;
	private final int number;
	private final List<String> resultMap;

	BridgeColumn(String mark, int number) {
		this.mark = mark;
		this.number = number;
		this.resultMap = new ArrayList<>();
	}

	public static String getMark(int number) {
		for (BridgeColumn bridgeColumn : BridgeColumn.values()) {
			if (bridgeColumn.number == number) {
				return bridgeColumn.mark;
			}
		}
		return "";
	}

	public static boolean isExistedMark(String mark) {
		return Arrays.stream(BridgeColumn.values())
				.anyMatch(bridgeColumn -> mark.equals(bridgeColumn.mark));
	}

	public static void addResultToMap(String mark, boolean movable) {
		Arrays.stream(BridgeColumn.values())
			.forEach(bridgeColumn -> {
				if(!bridgeColumn.mark.equals(mark)) {
					bridgeColumn.resultMap.add(" ");
					return;
				}
				addMoveResult(movable, bridgeColumn);
			});
	}

	private static void addMoveResult(boolean movable, BridgeColumn bridgeColumn) {
		if(movable) {
			bridgeColumn.resultMap.add(MOVABLE_MARK);
			return;
		}
		bridgeColumn.resultMap.add(IMMOVABLE_MARK);
	}

	public static String getResultMapAsString() {
		StringBuilder result = new StringBuilder();
		Arrays.stream(BridgeColumn.values())
			.peek(e -> result.append(START_BRIDGE_MAP_STRING))
			.map(bridgeColumn -> String.join(BRIDGE_MAP_DELIMITER, bridgeColumn.resultMap))
			.forEach(resultMap -> result.append(resultMap).append(END_BRIDGE_MAP_STRING).append("\n"));
		return result.toString();
	}

	public static void clearAllResultMap() {
		Arrays.stream(BridgeColumn.values())
			.forEach(bridgeColumn -> bridgeColumn.resultMap.clear());
	}
}
