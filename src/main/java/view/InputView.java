package view;

import static camp.nextstep.edu.missionutils.Console.*;
import static view.InputViewConstants.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		String bridgeSize = readLine();
		validateBridgeSizeNumeric(bridgeSize);
		validateBridgeSizeRange(bridgeSize);
		return Integer.parseInt(bridgeSize);
	}

	private void validateBridgeSizeNumeric(String bridgeSize) {
		String regex = REGEX_ALL_NUMERIC;
		if (!bridgeSize.matches(regex)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NON_NUMERIC);
		}
	}

	private void validateBridgeSizeRange(String bridgeSize) {
		int tmpBridgeSize = Integer.parseInt(bridgeSize);
		if (tmpBridgeSize < 3 || tmpBridgeSize > 20) {
			throw new IllegalArgumentException(ERROR_MEESAGE_OUT_OF_RANGE);
		}
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		String moving = readLine();
		validateMoving(moving);
		return moving;
	}

	private void validateMoving(String moving) {
		if (moving.equals(MOVING_UP) || moving.equals(MOVING_DOWN)) {
			return;
		}
		throw new IllegalArgumentException(ERROR_MESSAGE_NOT_U_OR_NOT_D);
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		return null;
	}
}
