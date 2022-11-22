package bridge;

import bridge.ui.InputView;
import bridge.ui.OutputView;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private BridgeRandomNumberGenerator randomGenerator = new BridgeRandomNumberGenerator();
	private BridgeMaker maker = new BridgeMaker(randomGenerator);
	private OutputView output = new OutputView();
	private InputView input = new InputView();

	private Bridge bridge = new Bridge();
	private User user = new User();
	private boolean onGame = true;

	public void start() {
		while (onGame) {
			boolean movable = move();
            if (!movable) {
                onGame = retry();
            }
			if (user.moveCount == bridge.size) {
				user.isSuccess = BridgeSymbol.SUCCESS.getSymbol();
				onGame = false;
			}
		}
		output.printResult(user);
	}

	public void init() {
		output.printInit();
		make();
	}

	private void make() {
		bridge.size = input.readBridgeSize();
		bridge.madeBridge = maker.makeBridge(bridge.size);
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean move() {
		output.printMoveMsg();
		String moving = input.readMoving();
		boolean movable = isMovable(moving, user.moveCount);
		user.addSelect(moving);
		user.addBridge(movable);
		output.printMap(user.bridge, user.select);
		user.moveCount++;
		return movable;
	}

	private boolean isMovable(String moving, int moveCount) {
		if (Objects.equals(bridge.madeBridge.get(moveCount), moving)) {
			return true;
		}
		return false;
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean retry() {
		output.printReTry();
		String gameCommand = input.readGameCommand();
		if (Objects.equals(gameCommand, BridgeSymbol.RETRY.getSymbol())) {
			user.clearInfo();
			user.tryCount++;
			return true;
		}
		user.isSuccess = BridgeSymbol.FAIL.getSymbol();
		return false;
	}
}
