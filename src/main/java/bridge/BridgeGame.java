package bridge;

import java.util.Arrays;
import java.util.List;

import bridge.Validation.Validation;
import bridge.View.GuideMessageView;
import bridge.View.InputView;
import bridge.View.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private static String[][] map;

	public void start(InputView inputView, OutputView outputView) {

		//다리 길이 입력
		GuideMessageView.START_BRIDGE_GAME_GUIDE_MESSAGE.printMessage();
		int bridgeSize = Validation.validateBridgeSize(2);

		//다리 생성
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
		boolean isRe = false;

		do {
			int moveCount = 0;
			initMap(bridgeSize);

			do {
				//이동할 칸 선택하고 이동하기
				String movingDirection = Validation.validateMoving(1);
				move(moveCount++, bridge, movingDirection);
				outputView.printMap(map, moveCount);

			} while (!isClearCrossBridge() && !isFailCrossBridge());

			if (isClearCrossBridge()) {
				GuideMessageView.GAME_RESULT_GUIDE_MESSAGE.printMessage();
				outputView.printMap(map, moveCount);
			}

			if (isFailCrossBridge()) {
				isRe = retry();
			}

		}while(isRe);
	}

	private boolean isFailCrossBridge() {
		return Arrays.stream(map)
			.flatMap(flatMap -> Arrays.stream(flatMap))
			.anyMatch(value -> value.contains("X"));
	}

	private static boolean isClearCrossBridge() {
		return map[0][map[0].length - 1].equals(" O ") || map[1][map[1].length - 1].equals(" O ");
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void move(int moveCount, List<String> bridge, String movingDirection) {
		makeMap(moveCount, movingDirection, bridge);
	}

	private static void moveDown(int moveCount, String input, List<String> bridge) {
		if (input.equals("D")) {
			if (isCrossable(input, moveCount, bridge)) {
				map[1][moveCount] = " O ";
				map[0][moveCount] = "   ";
			}
			if (!isCrossable(input, moveCount, bridge)) {
				map[1][moveCount] = " X ";
				map[0][moveCount] = "   ";
			}
		}
	}

	private static void moveUp(int moveCount, String input, List<String> bridge) {
		if (input.equals("U")) {
			if (isCrossable(input, moveCount, bridge)) {
				map[0][moveCount] = " O ";
				map[1][moveCount] = "   ";
			}
			if (!isCrossable(input, moveCount, bridge)) {
				map[0][moveCount] = " X ";
				map[1][moveCount] = "   ";
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
		if(input.equals("R")){
			return true;
		}
		return false;
	}

	public static void initMap(int size) {
		map = new String[2][size];

		Arrays.fill(map[0], "");
		Arrays.fill(map[1], "");
	}

	public static boolean isCrossable(String input, int moveCount, List<String> bridge) {
		if (input.equals(bridge.get(moveCount))) {
			return true;
		}
		return false;
	}

	public static void makeMap(int moveCount, String movingDirection, List<String> bridge) {
		moveUp(moveCount, movingDirection, bridge);
		moveDown(moveCount, movingDirection, bridge);
	}

	public static String[][] getMap() {
		return map;
	}
}
