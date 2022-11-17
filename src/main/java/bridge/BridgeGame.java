package bridge;

import java.util.Arrays;
import java.util.List;

import bridge.validation.Validation;
import bridge.view.GuideMessageView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private static final int BRIDGE_SIZE = 2;
	private static int bridgeSize;
	private static List<String> bridge;
	private static String[][] map;

	public void createBridge(BridgeMaker bridgeMaker) {
		GuideMessageView.START_BRIDGE_GAME_GUIDE_MESSAGE.printMessage();
		bridgeSize = Validation.validateBridgeSize(BRIDGE_SIZE);

		bridge = bridgeMaker.makeBridge(bridgeSize);
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void move(int moveCount, String movingDirection) {
		makeMap(moveCount, movingDirection);
	}

	private void moveDown(int moveCount, String input) {
		if (input.equals("D")) {
			if (isCrossable(input, moveCount)) {
				map[1][moveCount] = "O";
				map[0][moveCount] = " ";
			}
			if (!isCrossable(input, moveCount)) {
				map[1][moveCount] = "X";
				map[0][moveCount] = " ";
			}
		}
	}

	private void moveUp(int moveCount, String input) {
		if (input.equals("U")) {
			if (isCrossable(input, moveCount)) {
				map[0][moveCount] = "O";
				map[1][moveCount] = " ";
			}
			if (!isCrossable(input, moveCount)) {
				map[0][moveCount] = "X";
				map[1][moveCount] = " ";
			}
		}
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean retry() {
		String input = Validation.validateGameCommand(1);
		if (input.equals("R")) {
			return true;
		}
		return false;
	}

	public void initMap() {
		map = new String[BRIDGE_SIZE][bridgeSize];

		Arrays.fill(map[0], "");
		Arrays.fill(map[1], "");
	}

	private boolean isCrossable(String input, int moveCount) {
		if (input.equals(bridge.get(moveCount))) {
			return true;
		}
		return false;
	}

	private void makeMap(int moveCount, String movingDirection) {
		moveUp(moveCount, movingDirection);
		moveDown(moveCount, movingDirection);
	}

	public static boolean isFailCrossBridge() {
		return Arrays.stream(map)
			.flatMap(flatMap -> Arrays.stream(flatMap))
			.anyMatch(value -> value.contains("X"));
	}

	public static boolean isClearCrossBridge() {
		return map[0][map[0].length - 1].equals("O") || map[1][map[1].length - 1].equals("O");
	}

	public static String[][] getMap() {
		return map;
	}
}
