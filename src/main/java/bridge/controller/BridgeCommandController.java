package bridge.controller;

import bridge.dto.MoveCommandDto;
import bridge.model.BridgeGame;
import bridge.utils.CommandChecker;
import bridge.utils.CommandSymbols;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeCommandController {
	private final BridgeGame bridgeGame;
	private final InputView inputView;
	private final OutputView outputView;

	public BridgeCommandController(BridgeGame bridgeGame, InputView inputView,
		OutputView outputView) {
		this.bridgeGame = bridgeGame;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public String getGameCommand(BridgeMoveController bridgeMoveController) {
		MoveCommandDto moveCommandDto = bridgeMoveController.receiveMoveCommandDto();
		return getRetryOrQuit(bridgeMoveController, moveCommandDto);
	}

	public String getInputCommand() {
		String gameCommand;
		do {
			gameCommand = inputGameCommand();
		} while (CommandChecker.isEqualToError(gameCommand));
		return gameCommand;
	}

	public boolean isCommandRetry(String gameCommand) {
		return CommandChecker.isEqualToRetry(gameCommand);
	}

	private String getRetryOrQuit(BridgeMoveController bridgeMoveController,
		MoveCommandDto moveCommandDto) {
		String gameCommand = bridgeMoveController.checkMoveCommand(this, moveCommandDto);
		return receiveGameResult(gameCommand, moveCommandDto);
	}

	private String receiveGameResult(String gameCommand, MoveCommandDto moveCommandDto) {
		if (isQuit(gameCommand, moveCommandDto)) {
			outputView.receiveGameResult(bridgeGame.sendGameResult());
			return CommandSymbols.QUIT;
		}
		return CommandSymbols.RETRY;
	}

	private boolean isQuit(String gameCommand, MoveCommandDto moveCommandDto) {
		return CommandChecker.isEqualToQuit(gameCommand) || moveCommandDto.isGameClear();
	}

	private String inputGameCommand() {
		try {
			return commandCheck();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return CommandSymbols.ERROR;
		}
	}

	private String commandCheck() {
		String gameCommand = inputView.readGameCommand();
		bridgeGame.retry(gameCommand);
		outputView.checkResetOutput(gameCommand);
		return gameCommand;
	}


}
