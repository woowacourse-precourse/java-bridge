package bridge.domain;

import static bridge.message.MessageConstants.*;

public enum ResultMessageStatus {
	UP_SUCCESS_RESULT("O", " "),
	UP_FAILURE_RESULT("X", " "),
	DOWN_SUCCESS_RESULT(" ", "O"),
	DOWN_FAILURE_RESULT(" ", "X");

	private final String upFloor;
	private final String downFloor;

	ResultMessageStatus(String upFloor, String downFloor) {
		this.upFloor = upFloor;
		this.downFloor = downFloor;
	}

	public static ResultMessageStatus makeResultMessageStatus(String bridgeCommand, String command) {
		if (bridgeCommand.equals(command)) {
			return makeSuccessResultMessage(command);
		}
		return makeFailureResultMessage(command);
	}

	private static ResultMessageStatus makeSuccessResultMessage(String command) {
		if (command.equals(UP_COMMAND_MESSAGE)) {
			return UP_SUCCESS_RESULT;
		}
		return DOWN_SUCCESS_RESULT;
	}

	private static ResultMessageStatus makeFailureResultMessage(String command) {
		if (command.equals(UP_COMMAND_MESSAGE)) {
			return UP_FAILURE_RESULT;
		}
		return DOWN_FAILURE_RESULT;
	}

	public String getUpFloor() {
		return this.upFloor;
	}

	public String getDownFloor() {
		return this.downFloor;
	}
}
