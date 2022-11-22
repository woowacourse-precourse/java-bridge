package view;

import static camp.nextstep.edu.missionutils.Console.*;
import static view.InputViewConstants.*;

import validator.BridgeSizeValidator;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	private final BridgeSizeValidator bridgeSizeValidator;

	public InputView() {
		this.bridgeSizeValidator = new BridgeSizeValidator();
	}

	public int readBridgeSize() {
		System.out.println(MESSAGE_READ_BRIDGE_SIZE);
		int bridgeSize = readBridgeSizeUntilNoError();
		System.out.println();
		return bridgeSize;
	}

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSizeUntilNoError() {
		while (true) {
			try {
				return Integer.parseInt(bridgeSizeValidator.validateBridgeSize((readLine())));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		System.out.println(MESSAGE_READ_MOVING);
		String moving = readLine();
		validateMoving(moving);
		return moving;
	}

	private void validateMoving(String moving) {
		if (moving.equals(MOVING_UP) || moving.equals(MOVING_DOWN)) {
			return;
		}
		throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_MOVING_INPUT);
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		System.out.println(MESSAGE_READ_GAME_COMMAND);
		String gameCommand = readLine();
		validateGameCommand(gameCommand);
		return gameCommand;
	}

	private void validateGameCommand(String gameCommand) {
		if (gameCommand.equals(GAME_COMMAND_RESTART) || gameCommand.equals(GAME_COMMAND_QUIT)) {
			return;
		}
		throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_GAME_COMMAND_INPUT);
	}
}
