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
		end(mapDto);
	}

	private BridgeDto init() {
		outputView.printStartMessage();
		int bridgeSize = inputView.readBridgeSize();
		return bridgeGame.initBridge(bridgeSize);
	}

	private MapDto run(BridgeDto bridgeDto) {
		MapDto finalMapDto;
		do {
			finalMapDto = play(bridgeDto);
			if (finalMapDto.getNumberOfCorrect() == bridgeDto.getBridgeSize()) {
				return finalMapDto;
			}
			GameCommandDto gameCommandDto = new GameCommandDto(inputView.readGameCommand());
			finalMapDto = bridgeGame.retry(gameCommandDto, finalMapDto);
		} while (finalMapDto.getMap().equals(""));
		return finalMapDto;
	}

	private MapDto play(BridgeDto bridgeDto) {
		MapDto mapDto = null;
		for (int index = 0; index < bridgeDto.getBridgeSize(); index++) {
			MovingDto movingDto = new MovingDto(inputView.readMoving());
			mapDto = bridgeGame.move(bridgeDto, new IndexDto(index), movingDto);
			outputView.printMap(mapDto.getMap());

			if (bridgeGame.isFinish(mapDto, bridgeDto, new IndexDto(index))) {
				break;
			}
		}
		return mapDto;
	}

	private void end(MapDto mapDto) {
		outputView.printResult(mapDto.getMap(), bridgeGame.isSuccess(), PlayCount.getInstance().getCount());
	}
}
