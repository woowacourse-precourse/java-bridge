package bridge.service;

import bridge.util.ErrorConst;
import bridge.util.GameConst;

public class InputValidService {

	public Integer validBridgeSize(String bridgeSize) {
		Integer bridgeSizeNumber = checkIsNumber(bridgeSize);
		checkBridgeSizeRange(bridgeSizeNumber);
		return bridgeSizeNumber;
	}

	public String validUserMoving(String userMoving) {
		if (!userMoving.equals(GameConst.MOVING_UP) && !userMoving.equals(GameConst.MOVING_DOWN)) {
			throw new IllegalArgumentException(ErrorConst.MOVING_ERROR);
		}
		return userMoving;
	}

	public String validUserCommand(String userCommand) {
		if (!userCommand.equals(GameConst.RESTART) && !userCommand.equals(GameConst.QUIT)) {
			throw new IllegalArgumentException(ErrorConst.USER_COMMAND_ERROR);
		}
		return userCommand;
	}

	private void checkBridgeSizeRange(Integer bridgeSizeNumber) {
		if (bridgeSizeNumber < GameConst.MIN_BRIDGE_SIZE || GameConst.MAX_BRIDGE_SIZE < bridgeSizeNumber) {
			throw new IllegalArgumentException(ErrorConst.OUT_OF_RANGE_BRIDGE_SIZE_ERROR);
		}
	}

	private Integer checkIsNumber(String bridgeSize) {
		try {
			return Integer.valueOf(bridgeSize);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorConst.NOT_NUMBER_ERROR);
		}
	}

}
