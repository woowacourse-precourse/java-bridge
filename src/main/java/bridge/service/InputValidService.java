package bridge.service;

import java.util.List;
import java.util.stream.Collectors;

import bridge.util.ErrorConst;
import bridge.util.InputViewConst;

public class InputValidService {

	public Integer validBridgeSize(String bridgeSize) {
		//각 자리 char 이 숫자 여야 한다
		checkIsNumber(bridgeSize);
		//3부터 20 이어야 한다
		Integer bridgeSizeNumber = Integer.valueOf(bridgeSize);
		checkNumberRange(bridgeSizeNumber);
		return bridgeSizeNumber;
	}

	public String validUserMoving(String userMoving) {
		if (!userMoving.equals(InputViewConst.MOVING_UP) && !userMoving.equals(InputViewConst.MOVING_DOWN)) {
			throw new IllegalArgumentException(ErrorConst.MOVING_ERROR);
		}
		return userMoving;
	}

	public String validUserCommand(String userCommand) {
		if (!userCommand.equals(InputViewConst.RESTART) && !userCommand.equals(InputViewConst.QUIT)) {
			throw new IllegalArgumentException(ErrorConst.USER_COMMAND_ERROR);
		}
		return userCommand;
	}

	private void checkNumberRange(Integer bridgeSizeNumber) {
		if (bridgeSizeNumber < 3 || 20 < bridgeSizeNumber) {
			throw new IllegalArgumentException(ErrorConst.OUT_OF_RANGE_BRIDGE_SIZE_ERROR);
		}
	}

	private void checkIsNumber(String bridgeSize) {
		List<Integer> bridgeSizeNumbers = bridgeSize.chars().mapToObj(i -> i - 48).collect(Collectors.toList());
		long count = bridgeSizeNumbers.stream().filter(i -> 0 < i && i < 10).count();
		if (bridgeSize.length() != count) {
			throw new IllegalArgumentException(ErrorConst.NOT_NUMBER_ERROR);
		}
	}

}
