package bridge.controller;

import bridge.dto.MoveCommandDto;
import bridge.model.BridgeGame;
import bridge.utils.CommandSymbols;
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

	public void processBridgeMove(BridgeCommandController bridgeCommandController) {
		String gameCommand;
		do {
			gameCommand = bridgeCommandController.getGameCommand(this);
		} while (bridgeCommandController.isCommandRetry(gameCommand));
	}

	public MoveCommandDto receiveMoveCommandDto() {
		MoveCommandDto moveCommandDto;
		do {
			moveCommandDto = readMoveCommand();
		} while (isContinueMove(moveCommandDto));
		return moveCommandDto;
	}

	public String checkMoveCommand(BridgeCommandController bridgeCommandController,
		MoveCommandDto moveCommandDto) {
		if (isNotMove(moveCommandDto)) {
			return bridgeCommandController.getInputCommand();
		}
		return CommandSymbols.RETRY;
	}

	private boolean isNotMove(MoveCommandDto moveCommandDto) {
		return !moveCommandDto.isAbleToMove();
	}

	private MoveCommandDto readMoveCommand() {
		try {
			return readUserMoveInput();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
		return new MoveCommandDto("", true, false);
	}

	private boolean isContinueMove(MoveCommandDto moveCommandDto) {
		return moveCommandDto.isAbleToMove() && !moveCommandDto.isGameClear();
	}

	private MoveCommandDto readUserMoveInput() {
		MoveCommandDto moveCommandDto = bridgeGame.move(inputView.readMoving());
		outputView.receiveMoveCommandResult(moveCommandDto);
		outputView.printMap();
		return moveCommandDto;
	}
}
