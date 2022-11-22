package bridge;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
	private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
	private final BridgeGame bridgeGame = new BridgeGame();

	private List<String> bridge = new ArrayList<>();
	private List<String> result = new ArrayList<>();

	private int countOfGame = 1;

	View view = new View();

	public void start() {
		view.start();
		makeBridge();
		while (!process()) {
			if (!bridgeGame.retry(view.readRetry())) {
				break;
			}
			addCount();
			result = new ArrayList<>();
		}
		end();
	}

	private void makeBridge() {
		bridge = bridgeMaker.makeBridge(view.readBridgeSize());
	}

	private boolean process() {
		do {
			result.add(bridgeGame.move(view.readMoving(), bridge, result.size()));
			view.printMap(result, bridge);
		} while (result.size() != bridge.size() && !result.contains("X"));
		if (result.contains("X")) {
			return false;
		}
		return true;
	}

	private void end() {
		view.printResult(result, bridge, countOfGame);
	}

	private void addCount() {
		countOfGame++;
	}
}
