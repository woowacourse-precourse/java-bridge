package bridge;

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


	public void start(InputView inputView, OutputView outputView){
		//다리 길이 입력
		GuideMessageView.START_BRIDGE_GAME_GUIDE_MESSAGE.printMessage();
		GuideMessageView.BRIDGE_LENGTH_GUIDE_MESSAGE.printMessage();
		Validation.validateBridgeSize(2);

		//이동할 칸 선택
		GuideMessageView.SELECT_MOVE_GUIDE_MESSAGE.printMessage();
		inputView.readMoving();
		Validation.validateMoving();


	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void move(int moveCount, List<String> bridge) {
		String input = Validation.validateMoving();
		makeMap(moveCount, input, bridge);
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
	public void retry() {
	}

	public static void initMoveHistory(int size) {
		map = new String[2][size];
	}

	public static boolean isCrossable(String input, int moveCount, List<String> bridge) {
		if (input.equals(bridge.get(moveCount))) {
			return true;
		}
		return false;
	}

	public static void makeMap(int moveCount, String input, List<String> bridge) {
		moveUp(moveCount, input, bridge);
		moveDown(moveCount, input, bridge);
	}

	public static String[][] getMap() {
		return map;
	}
}
