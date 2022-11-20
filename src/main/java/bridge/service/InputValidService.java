package bridge.service;

import java.util.List;
import java.util.stream.Collectors;

import bridge.util.ErrorConst;
import bridge.util.GameConst;

public class InputValidService {

	public Integer validBridgeSize(String bridgeSize) {
		checkIsNumber(bridgeSize);
		Integer bridgeSizeNumber = Integer.valueOf(bridgeSize);
		checkNumberRange(bridgeSizeNumber);
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

	private void checkNumberRange(Integer bridgeSizeNumber) {
		if (bridgeSizeNumber < GameConst.MIN_BRIDGE_SIZE || GameConst.MAX_BRIDGE_SIZE < bridgeSizeNumber) {
			throw new IllegalArgumentException(ErrorConst.OUT_OF_RANGE_BRIDGE_SIZE_ERROR);
		}
	}

	private void checkIsNumber(String bridgeSize) {
		List<Integer> bridgeSizeNumbers = bridgeSize.chars().mapToObj(i -> i - 48).collect(Collectors.toList());
		long count = bridgeSizeNumbers.stream()
			.filter(i -> GameConst.MIN_NUMBER <= i && i <= GameConst.MAX_NUMBER)
			.count();
		if (bridgeSize.length() != count) {
			throw new IllegalArgumentException(ErrorConst.NOT_NUMBER_ERROR);
		}
	}

}
