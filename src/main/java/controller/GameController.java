package controller;

import dto.BridgeDto;
import dto.GameCommandDto;
import dto.IndexDto;
import dto.MapDto;
import dto.MovingDto;
import repository.PlayCount;
import service.BridgeGame;
import view.InputView;
import view.OutputView;

public class GameController {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private final BridgeGame bridgeGame = new BridgeGame();

	public void control() {
		BridgeDto bridgeDto = init();
		MapDto mapDto = run(bridgeDto);
		finish(bridgeDto, mapDto);
	}

	private BridgeDto init() {
		outputView.printStartMessage();
		int bridgeSize = inputView.readBridgeSize();
		return bridgeGame.initBridge(bridgeSize);
	}

	private MapDto run(BridgeDto bridgeDto) {
		while (true) {
			MapDto finalMapDto = play(bridgeDto);
			if (isRetry(bridgeDto, finalMapDto)) {
				continue;
			}
			return finalMapDto;
		}
	}

	private boolean isRetry(BridgeDto bridgeDto, MapDto finalMapDto) {
		if (!isSuccess(bridgeDto, finalMapDto)) {
			GameCommandDto gameCommandDto = new GameCommandDto(inputView.readGameCommand());
			return bridgeGame.retry(gameCommandDto);
		}
		return false;
	}

	private MapDto play(BridgeDto bridgeDto) {
		MapDto mapDto = null;
		for (int index = 0; index < bridgeDto.getBridgeSize(); index++) {
			mapDto = move(bridgeDto, index);

			if (isSuccess(bridgeDto, mapDto) || mapDto.getNumberOfCorrect() == index) {
				break;
			}
		}
		return mapDto;
	}

	private MapDto move(BridgeDto bridgeDto, int index) {
		MovingDto movingDto = new MovingDto(inputView.readMoving());
		MapDto mapDto = bridgeGame.move(bridgeDto, new IndexDto(index), movingDto);
		outputView.printMap(mapDto.getMap());
		return mapDto;
	}

	private void finish(BridgeDto bridgeDto, MapDto mapDto) {
		boolean isSuccess = isSuccess(bridgeDto, mapDto);
		String map = mapDto.getMap();

		outputView.printResult(map, isSuccess, PlayCount.getInstance().getCount());
	}

	private boolean isSuccess(BridgeDto bridgeDto, MapDto mapDto) {
		return bridgeDto.getBridgeSize() == mapDto.getNumberOfCorrect();
	}
}
