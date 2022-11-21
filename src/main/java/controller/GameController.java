package controller;

import dto.BridgeResponseDto;
import dto.BridgeSizeRequestDto;
import dto.GameCommandRequestDto;
import dto.MapResponseDto;
import dto.MovingRequestDto;
import repository.PlayCount;
import service.BridgeGame;
import view.InputView;
import view.OutputView;

public class GameController {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private final BridgeGame bridgeGame = new BridgeGame();

	public void control() {
		BridgeResponseDto bridgeResponseDto = init();
		MapResponseDto mapResponseDto = run(bridgeResponseDto);
		finish(bridgeResponseDto, mapResponseDto);
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

	private MapResponseDto run(BridgeResponseDto bridgeResponseDto) {
		while (true) {
			MapResponseDto finalMapResponseDto = play(bridgeResponseDto);
			if (isRetry(bridgeResponseDto, finalMapResponseDto)) {
				continue;
			}
			return finalMapResponseDto;
		}
	}

	private boolean isRetry(BridgeResponseDto bridgeResponseDto, MapResponseDto finalMapResponseDto) {
		while (true) {
			try {
				return gameCommandIsRetry(bridgeResponseDto, finalMapResponseDto);
			} catch (IllegalArgumentException e) {
				outputView.printErrorLog(e);
			}
		}
	}

	private boolean gameCommandIsRetry(BridgeResponseDto bridgeResponseDto, MapResponseDto finalMapResponseDto) {
		if (!isSuccess(bridgeResponseDto, finalMapResponseDto)) {
			GameCommandRequestDto gameCommandRequestDto = inputView.readGameCommand();
			return bridgeGame.retry(gameCommandRequestDto);
		}
		return false;
	}

	private MapResponseDto play(BridgeResponseDto bridgeResponseDto) {
		while (true) {
			MapResponseDto mapResponseDto = addMovingToMap(bridgeResponseDto);
			if (bridgeGame.isEnd(bridgeResponseDto, mapResponseDto)) {
				bridgeGame.initMovingStack();
				return mapResponseDto;
			}
		}
	}

	private MapResponseDto addMovingToMap(BridgeResponseDto bridgeResponseDto) {
		while (true) {
			try {
				return renderMapAddedMoving(bridgeResponseDto);
			} catch (IllegalArgumentException e) {
				outputView.printErrorLog(e);
			}
		}
	}

	private MapResponseDto renderMapAddedMoving(BridgeResponseDto bridgeResponseDto) {
		MovingRequestDto movingRequestDto = inputView.readMoving();
		bridgeGame.move(movingRequestDto);
		MapResponseDto mapResponseDto = bridgeGame.renderMap(bridgeResponseDto);
		outputView.printMap(mapResponseDto);
		return mapResponseDto;
	}

	private void finish(BridgeResponseDto bridgeResponseDto, MapResponseDto mapResponseDto) {
		String map = mapResponseDto.getMap();

		outputView.printResult(map, isSuccess(bridgeResponseDto, mapResponseDto), PlayCount.getInstance().getCount());
	}

	private boolean isSuccess(BridgeResponseDto bridgeResponseDto, MapResponseDto mapResponseDto) {
		return bridgeResponseDto.getBridge().size() == mapResponseDto.getNumberOfCorrect();
	}
}
