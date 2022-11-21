package bridge.controller;

import bridge.dto.MoveCommandDto;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeMoveController {
	private final BridgeGame bridgeGame;
	private final InputView inputView;
	private final OutputView outputView;

	public BridgeMoveController(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
		this.bridgeGame = bridgeGame;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void processBridgeMove() {
		String gameCommand;
		do {
			gameCommand = getGameCommand();
		} while (isCommandRetry(gameCommand));
	}

	private String getGameCommand() {
		MoveCommandDto moveCommandDto = receiveMoveCommandDto();
		return getRetryOrQuit(moveCommandDto);
	}

	private boolean isCommandRetry(String gameCommand) {
		return gameCommand.equals("R");
	}

	private MoveCommandDto receiveMoveCommandDto() {
		MoveCommandDto moveCommandDto;
		do {
			moveCommandDto = readMoveCommand();
		} while (isContinueMove(moveCommandDto));
		return moveCommandDto;
	}

	private MoveCommandDto readMoveCommand() {
		try {
			return readUserInput();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
		return new MoveCommandDto("", true, false);
	}

	private boolean isContinueMove(MoveCommandDto moveCommandDto) {
		return moveCommandDto.getMoveFlag() && !moveCommandDto.getGameClear();
	}

	private MoveCommandDto readUserInput() {
		MoveCommandDto moveCommandDto = bridgeGame.move(inputView.readMoving());
		outputView.receiveMoveCommandResult(moveCommandDto);
		outputView.printMap();
		return moveCommandDto;
	}

	private String getRetryOrQuit(MoveCommandDto moveCommandDto) {
		String gameCommand = checkMoveCommand(moveCommandDto);
		return receiveGameResult(gameCommand, moveCommandDto);
	}

	private String checkMoveCommand(MoveCommandDto moveCommandDto) {
		if (isNotMove(moveCommandDto)) {
			return getInputCommand();
		}
		return "R";
	}

	private boolean isNotMove(MoveCommandDto moveCommandDto) {
		return !moveCommandDto.getMoveFlag();
	}

	private String getInputCommand() {
		String gameCommand;
		do {
			gameCommand = inputGameCommand();
		} while (gameCommand.equals("Error"));
		return gameCommand;
	}

	private String inputGameCommand() {
		try {
			return commandCheck();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return "Error";
		}
	}

	private String commandCheck() {
		String gameCommand = inputView.readGameCommand();
		bridgeGame.retry(gameCommand);
		checkResetOutput(gameCommand);
		return gameCommand;
	}

	private void checkResetOutput(String gameCommand) {
		if (gameCommand.equals("R")) {
			outputView.resetOutputView();
		}
	}

	private String receiveGameResult(String gameCommand, MoveCommandDto moveCommandDto) {
		if (isQuit(gameCommand, moveCommandDto)) {
			outputView.receiveGameResult(bridgeGame.sendGameResult());
			return "Q";
		}
		return "R";
	}

	private boolean isQuit(String gameCommand, MoveCommandDto moveCommandDto) {
		return gameCommand.equals("Q") || moveCommandDto.getGameClear();
	}
}
