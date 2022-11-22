package bridge.domain;

import java.util.List;

import static bridge.Constants.*;

public class BridgeGame {

	public static void move(Map map, Bridge bridge, PlayerBridge playerBridge) {
		String answer = getAnswer(bridge, playerBridge);

		if (playerBridge.getLastValue().equals(UP)) {
			map.addUp(answer);
			map.addDown(SPACE);
		}
		if (playerBridge.getLastValue().equals(DOWN)) {
			map.addUp(SPACE);
			map.addDown(answer);
		}
	}

	private static String getAnswer(Bridge bridge, PlayerBridge playerBridge) {
		int index = playerBridge.getLastIndex();

		if (playerBridge.getLastValue().equals(bridge.getValueOfIndex(index))) {
			return O;
		}
		return X;
	}

	public static int retry(Map map, PlayerBridge playerBridge, int count) {
		map.init();
		playerBridge.init();
		return count + 1;
	}

	public static boolean success(Map map, int size) {
		return map.getSize() == size && !map.containX();
	}

	public static boolean fail(Map map) {
		for (List<String> way : map.getMap()) {
			if (way.contains(X)) {
					return true;
			}
		}
		return false;
	}
}
