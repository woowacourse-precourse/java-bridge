package bridge.ui;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */

import bridge.BridgeSymbol;
import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class InputView {

	/**
	 * 다리의 길이를 입력받는다.
	 */

	public int readBridgeSize() {
		String bridgeSize = Console.readLine();
		checkBridgeSize(bridgeSize);
		return Integer.parseInt(bridgeSize);
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		String moving = Console.readLine();
		checkMoving(moving);
		return moving;
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		String gameCommand = Console.readLine();
		checkGameCommand(gameCommand);
		return gameCommand;
	}

	private void checkBridgeSize(String bridgeSize) {

		if (!isDigit(bridgeSize) ||
			Integer.parseInt(bridgeSize) < 3 ||
			Integer.parseInt(bridgeSize) > 20) {
			ErrorView.errorMsg = ErrorMessage.BRIDGE_SIZE.getMsg();
			throw new IllegalArgumentException();
		}
	}

	private boolean isDigit(String bridgeSize) {
        if (bridgeSize.isEmpty()) {
            return false;
        }
		try {
			Double.parseDouble(bridgeSize);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	private void checkMoving(String moving) {
		if (!Objects.equals(moving, BridgeSymbol.UP.getSymbol()) &&
			!Objects.equals(moving, BridgeSymbol.DOWN.getSymbol())) {
			ErrorView.errorMsg = ErrorMessage.MOVING.getMsg();
			throw new IllegalArgumentException();
		}
	}

	private void checkGameCommand(String gameCommand) {
		if (!Objects.equals(gameCommand, BridgeSymbol.RETRY.getSymbol()) &&
			!Objects.equals(gameCommand, BridgeSymbol.QUIT.getSymbol())) {
			ErrorView.errorMsg = ErrorMessage.GAME_COMMAND.getMsg();
			throw new IllegalArgumentException();
		}
	}
}
