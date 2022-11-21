package bridge.controller;

import bridge.dto.MoveCommandDto;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.StartView;

public class BridgeGameController {
	private static final StartView startView = new StartView();
	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();
	private static final BridgeGame bridgeGame = new BridgeGame();

	public void run() {
		startView.printStart();
		startBridgeMaking();
		processBridgeGame();
		outputView.printResult();
	}

	private void startBridgeMaking() {
		boolean isSizeError;

		do {
			isSizeError = isMakingBridgeSuccess();
		} while (isSizeError);
	}

	private void processBridgeGame() {
		String gameCommand;

		do {
			gameCommand = processGame();
		} while (gameCommand.equals("R"));
	}

	private String processGame() {
		MoveCommandDto moveCommandDto;
		moveCommandDto = processMove();
		return checkCommandStatus(moveCommandDto);
	}

	private MoveCommandDto processMove() {
		MoveCommandDto moveCommandDto;
		do {
			moveCommandDto = tryCatchReadMove();
		} while (isContinueMove(moveCommandDto));
		return moveCommandDto;
	}

	private MoveCommandDto tryCatchReadMove() {
		try {
			return readMove();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
		return new MoveCommandDto("", true, false);
	}

	private MoveCommandDto readMove() {
		MoveCommandDto moveCommandDto = bridgeGame.move(inputView.readMoving());
		outputView.receiveMoveCommandResult(moveCommandDto);
		outputView.printMap();
		return moveCommandDto;
	}

	private boolean isContinueMove(MoveCommandDto moveCommandDto) {
		return moveCommandDto.getMoveFlag() && !moveCommandDto.getGameClear();
	}

	private String checkQuitGame(String gameCommand, MoveCommandDto moveCommandDto) {
		if (isQuit(gameCommand, moveCommandDto)) {
			outputView.receiveGameResult(bridgeGame.sendGameResult());
			return "Q";
		}
		return "R";
	}

	private String checkCommandStatus(MoveCommandDto moveCommandDto) {
		String gameCommand = getCommandStatus(moveCommandDto);
		return checkQuitGame(gameCommand, moveCommandDto);
	}

	private String getCommandStatus(MoveCommandDto moveCommandDto) {
		if (isNotMove(moveCommandDto)) {
			return getGameCommand();
		}
		return "R";
	}

	private boolean isNotMove(MoveCommandDto moveCommandDto) {
		return !moveCommandDto.getMoveFlag();
	}

	private String getGameCommand() {
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

	private boolean isMakingBridgeSuccess() {
		try {
			bridgeGame.start(inputView.readBridgeSize());
			return false;
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return true;
		}
	}

	private boolean isQuit(String gameCommand, MoveCommandDto moveCommandDto) {
		return gameCommand.equals("Q") || moveCommandDto.getGameClear();
	}
}
