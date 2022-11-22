package bridge.domain;

import static bridge.constant.Constant.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bridge.constant.Constant;

public enum BridgeNumber {
	UP("U", 1),
	DOWN("D", 0);

	private final String mark;
	private final int number;
	private final List<String> resultMap;

	BridgeNumber(String mark, int number) {
		this.mark = mark;
		this.number = number;
		this.resultMap = new ArrayList<>();
	}

	public static String getMark(int number) {
		for (BridgeNumber bridgeNumber : BridgeNumber.values()) {
			if (bridgeNumber.number == number) {
				return bridgeNumber.mark;
			}
		}
		return "";
	}

	public static boolean isExistedMark(String mark) {
		return Arrays.stream(BridgeNumber.values())
				.anyMatch(bridgeNumber -> mark.equals(bridgeNumber.mark));
	}

	public static void addResultToMap(String mark, boolean movable) {
		Arrays.stream(BridgeNumber.values())
			.forEach(bridgeNumber -> {
				if(!bridgeNumber.mark.equals(mark)) {
					bridgeNumber.resultMap.add(" ");
					return;
				}
				addMoveResult(movable, bridgeNumber);
			});
	}

	private static void addMoveResult(boolean movable, BridgeNumber bridgeNumber) {
		if(movable) {
			bridgeNumber.resultMap.add(MOVABLE_MARK);
			return;
		}
		bridgeNumber.resultMap.add(IMMOVABLE_MARK);
	}

	public static String getResultMapAsString() {
		StringBuilder result = new StringBuilder();
		Arrays.stream(BridgeNumber.values())
			.peek(e -> result.append(START_BRIDGE_MAP_STRING))
			.map(bridgeNumber -> String.join(BRIDGE_MAP_DELIMITER, bridgeNumber.resultMap))
			.forEach(resultMap -> result.append(resultMap).append(END_BRIDGE_MAP_STRING).append("\n"));
		return result.toString();
	}
}
