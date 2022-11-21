package controller;

import dto.BridgeResponseDto;
import dto.BridgeSizeRequestDto;
import dto.GameCommandRequestDto;
import dto.MoveResultResponseDto;
import dto.MovingRequestDto;
import bridge.PlayCount;
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
		finish(bridgeResponseDto, moveResultResponseDto);
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
			MoveResultResponseDto finalMoveResultResponseDto = play(bridgeResponseDto);
			if (isRetry(bridgeResponseDto, finalMoveResultResponseDto)) {
				continue;
			}
			return finalMoveResultResponseDto;
		}
	}

	private boolean isRetry(BridgeResponseDto bridgeResponseDto, MoveResultResponseDto finalMoveResultResponseDto) {
		while (true) {
			try {
				return gameCommandIsRetry(bridgeResponseDto, finalMoveResultResponseDto);
			} catch (IllegalArgumentException e) {
				outputView.printErrorLog(e);
			}
		}
	}

	private boolean gameCommandIsRetry(BridgeResponseDto bridgeResponseDto, MoveResultResponseDto finalMoveResultResponseDto) {
		if (!isSuccess(bridgeResponseDto, finalMoveResultResponseDto)) {
			GameCommandRequestDto gameCommandRequestDto = inputView.readGameCommand();
			return bridgeGame.retry(gameCommandRequestDto);
		}
		return false;
	}

	private MoveResultResponseDto play(BridgeResponseDto bridgeResponseDto) {
		while (true) {
			MoveResultResponseDto moveResultResponseDto = addMovingToMap(bridgeResponseDto);
			if (bridgeGame.isEnd(bridgeResponseDto, moveResultResponseDto)) {
				bridgeGame.initMovingStack();
				return moveResultResponseDto;
			}
		}
	}

	private MoveResultResponseDto addMovingToMap(BridgeResponseDto bridgeResponseDto) {
		while (true) {
			try {
				return renderMapAddedMoving(bridgeResponseDto);
			} catch (IllegalArgumentException e) {
				outputView.printErrorLog(e);
			}
		}
	}

	private MoveResultResponseDto renderMapAddedMoving(BridgeResponseDto bridgeResponseDto) {
		MovingRequestDto movingRequestDto = inputView.readMoving();
		bridgeGame.move(movingRequestDto);
		MoveResultResponseDto moveResultResponseDto = bridgeGame.renderMap(bridgeResponseDto);
		outputView.printMap(moveResultResponseDto);
		return moveResultResponseDto;
	}

	private void finish(BridgeResponseDto bridgeResponseDto, MoveResultResponseDto moveResultResponseDto) {
		String map = moveResultResponseDto.getMap();

		outputView.printResult(map, isSuccess(bridgeResponseDto, moveResultResponseDto), PlayCount.getInstance().getCount());
	}

	private boolean isSuccess(BridgeResponseDto bridgeResponseDto, MoveResultResponseDto moveResultResponseDto) {
		return bridgeResponseDto.getBridge().size() == moveResultResponseDto.getNumberOfCorrect();
	}
}
