package controller;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeSize;
import bridge.MapRenderer;
import view.InputView;
import view.OutputView;

public class GameController {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public void control() {
		BridgeGame bridgeGame = new BridgeGame();

		Bridge bridge = init();
		String result = run(bridge, bridgeGame);
		end(result, bridgeGame);
	}

	public Bridge init() {
		outputView.printStartMessage();

		BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		BridgeSize bridgeSize = new BridgeSize(inputView.readBridgeSize());
		return new Bridge(bridgeMaker.makeBridge(bridgeSize.getBridgeSize()));
	}

	public String run(Bridge bridge, BridgeGame bridgeGame) {
		MapRenderer mapRenderer = new MapRenderer();
		String result = "";

		while (result.equals("")) {
			result = play(bridge, bridgeGame, mapRenderer);
			if (result.chars().filter(x -> x == 'O').count() == bridge.getBridgeSize()) {
				return result;
			}
			String gameCommand = inputView.readGameCommand();
			result = bridgeGame.retry(gameCommand, result);
		}
		return result;
	}

	private String play(Bridge bridge, BridgeGame bridgeGame, MapRenderer mapRenderer) {
		String result = "";
		for (int index = 0; index < bridge.getBridgeSize(); index++) {
			String moving = inputView.readMoving();
			boolean isSafe = bridgeGame.move(bridge.getBridge().subList(0, index + 1), moving);
			String map = mapRenderer.render(bridge.getBridge().subList(0, index + 1), isSafe);
			outputView.printMap(map);
			if (bridge.isCorrectMoving(index, moving)) {
				if (index == bridge.getBridgeSize() - 1) {
					return map;
				}
				continue;
			}
			result = map;
			break;
		}
		return result;
	}


}
