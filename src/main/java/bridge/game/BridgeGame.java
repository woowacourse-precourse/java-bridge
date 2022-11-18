package bridge.game;

import java.util.ArrayList;
import java.util.List;

import bridge.BridgeMaker;
import bridge.gameInput.GameCommand;
import bridge.gameInput.PlayerMove;
import bridge.validation.Validation;
import bridge.view.GuideMessageView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private static final int BRIDGE_SIZE = 2;
	private static int bridgeSize;
	private static List<String> bridge;
	private static List<String> topMapResult;
	private static List<String> bottomMapResult;

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
		if (isDown(input)) {
			ableMoveDown(moveCount, input);
			unableMoveDown(moveCount, input);
		}
	}

	private static boolean isDown(String input) {
		return input.equals(PlayerMove.DOWN.getDirection());
	}

	private void unableMoveDown(int moveCount, String input) {
		if (!isAbleCross(input, moveCount)) {
			bottomMapResult.add(MapDrawer.UNABLE_CROSS.getSymbol());
			topMapResult.add(MapDrawer.BLANK.getSymbol());
		}
	}

	private void ableMoveDown(int moveCount, String input) {
		if (isAbleCross(input, moveCount)) {
			bottomMapResult.add(MapDrawer.ABLE_CROSS.getSymbol());
			topMapResult.add(MapDrawer.BLANK.getSymbol());
		}
	}

	private void moveUp(int moveCount, String input) {
		if (isUp(input)) {
			ableMoveUp(moveCount, input);
			unableMoveUp(moveCount, input);
		}
	}

	private static boolean isUp(String input) {
		return input.equals(PlayerMove.UP.getDirection());
	}

	private void ableMoveUp(int moveCount, String input) {
		if (isAbleCross(input, moveCount)) {
			topMapResult.add(MapDrawer.ABLE_CROSS.getSymbol());
			bottomMapResult.add(MapDrawer.BLANK.getSymbol());
		}
	}

	private void unableMoveUp(int moveCount, String input) {
		if (!isAbleCross(input, moveCount)) {
			topMapResult.add(MapDrawer.UNABLE_CROSS.getSymbol());
			bottomMapResult.add(MapDrawer.BLANK.getSymbol());
		}
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean retry() {
		String RestartOrEnd = Validation.validateGameCommand(1);

		if (isReStart(RestartOrEnd)) {
			return true;
		}

		return false;
	}

	private static boolean isReStart(String input) {
		return input.equals(GameCommand.RE_START.getCommand());
	}

	public void initMap() {
		topMapResult = new ArrayList<>();
		bottomMapResult = new ArrayList<>();
	}

	private boolean isAbleCross(String input, int moveCount) {
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
		return topMapResult.contains(MapDrawer.UNABLE_CROSS.getSymbol()) || bottomMapResult.contains(
			MapDrawer.UNABLE_CROSS.getSymbol());
	}

	public static boolean isClearCrossBridge() {
		return (topMapResult.size() == bridgeSize && topMapResult.get(bridgeSize - 1)
			.equals(MapDrawer.ABLE_CROSS.getSymbol())) ||
			(bottomMapResult.size() == bridgeSize && bottomMapResult.get(bridgeSize - 1)
				.equals(MapDrawer.ABLE_CROSS.getSymbol()));

	}

	public static List<String> getTopMapResult() {
		return topMapResult;
	}

	public static List<String> getBottomMapResult() {
		return bottomMapResult;
	}
}
