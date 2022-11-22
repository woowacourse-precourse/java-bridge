package controller;

import dto.BridgeResponseDto;
import dto.BridgeSizeRequestDto;
import dto.GameCommandRequestDto;
import dto.MoveResultResponseDto;
import dto.MovingRequestDto;
import service.BridgeGame;
import view.InputView;
import view.OutputView;

public class GameController {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private final BridgeGame bridgeGame = new BridgeGame();

	public void control() {
		BridgeResponseDto bridgeResponseDto = init();
		MoveResultResponseDto moveResultResponseDto = run(bridgeResponseDto);
		finish(moveResultResponseDto);
	}

	private BridgeResponseDto init() {
		outputView.printStartMessage();
		bridgeGame.initMovingStack();
		return makeBridge();
	}

	private BridgeResponseDto makeBridge() {
		while (true) {
			try {
				BridgeSizeRequestDto bridgeSizeRequestDto = inputView.readBridgeSize();
				return bridgeGame.initBridge(bridgeSizeRequestDto);
			} catch (IllegalArgumentException e) {
				outputView.printErrorLog(e);
			}
		}
	}

	private MoveResultResponseDto run(BridgeResponseDto bridgeResponseDto) {
		while (true) {
			MoveResultResponseDto finalResultResponseDto = play(bridgeResponseDto);
			if (isRetry(finalResultResponseDto)) {
				continue;
			}
			return finalResultResponseDto;
		}
	}

	private MoveResultResponseDto play(BridgeResponseDto bridgeResponseDto) {
		while (true) {
			MoveResultResponseDto moveResultResponseDto = bridgeGame.checkGameIsEnd(confirmResult(bridgeResponseDto));
			if (moveResultResponseDto == null) {
				continue;
			}
			return moveResultResponseDto;
		}
	}

	private MoveResultResponseDto confirmResult(BridgeResponseDto bridgeResponseDto) {
		while (true) {
			try {
				return produceResultByMoving(bridgeResponseDto);
			} catch (IllegalArgumentException e) {
				outputView.printErrorLog(e);
			}
		}
	}

	private MoveResultResponseDto produceResultByMoving(BridgeResponseDto bridgeResponseDto) {
		MovingRequestDto movingRequestDto = inputView.readMoving();
		bridgeGame.move(movingRequestDto);
		MoveResultResponseDto moveResultResponseDto = bridgeGame.produceResult(bridgeResponseDto);
		outputView.printMap(moveResultResponseDto);
		return moveResultResponseDto;
	}

	private boolean isRetry(MoveResultResponseDto finalResultResponseDto) {
		while (true) {
			try {
				return checkRestart(finalResultResponseDto);
			} catch (IllegalArgumentException e) {
				outputView.printErrorLog(e);
			}
		}
	}

	private boolean checkRestart(MoveResultResponseDto finalResultResponseDto) {
		if (bridgeGame.success(finalResultResponseDto) != null) {
			return false;
		}
		GameCommandRequestDto gameCommandRequestDto = inputView.readGameCommand();
		return bridgeGame.retry(gameCommandRequestDto);
	}

	private void finish(MoveResultResponseDto moveResultResponseDto) {
		outputView.printResult(moveResultResponseDto, bridgeGame.makePlayCountDto());
	}
}
