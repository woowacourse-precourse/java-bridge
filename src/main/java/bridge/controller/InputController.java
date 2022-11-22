package bridge.controller;

import bridge.domain.command.BranchCommand;
import bridge.domain.command.MoveCommand;
import bridge.view.InputView;

public class InputController {
	private static final int MIN_SIZE = 3;
	private static final int MAX_SIZE = 20;
	private static final String BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3이상, 20이하 입니다.";
	private final InputView inputView = new InputView();

	public int receiveBridgeSize() {
		try {
			int size = inputView.readBridgeSize();
			return validBridgeSize(size);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return receiveBridgeSize();
		}
	}

	private int validBridgeSize(int size) {
		if (size < MIN_SIZE || size > MAX_SIZE) {
			throw new IllegalArgumentException(BRIDGE_SIZE_ERROR_MESSAGE);
		}
		return size;
	}

	public String receiveMoveCommand() {
		try {
			String moving = inputView.readMoving();
			return validMoveCommand(moving);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return receiveMoveCommand();
		}
	}

	private String validMoveCommand(String inputCommand) {
		MoveCommand command = MoveCommand.findCommand(inputCommand);
		return command.getValue();
	}

	public boolean askRetry() {
		try {
			String retryInput = inputView.readGameCommand();
			return validBranchCommand(retryInput);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return askRetry();
		}
	}

	private boolean validBranchCommand(String inputCommand) {
		BranchCommand branchCommand = BranchCommand.findCommand(inputCommand);
		return BranchCommand.isRestartGame(branchCommand.getValue());
	}
}
