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
		BridgeCommandController bridgeCommandController =
			new BridgeCommandController(bridgeGame, inputView, outputView);
		MoveCommandDto moveCommandDto = receiveMoveCommandDto();
		return bridgeCommandController.getRetryOrQuit(moveCommandDto);
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
}
