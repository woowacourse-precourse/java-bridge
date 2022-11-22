package domain;

import java.util.List;

import bridge.BridgeRandomNumberGenerator;
import service.ViewController;

public class BridgeGame {
	private ViewController view = new ViewController();
	private final List<String> bridge;

	private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
	private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

	private MapMaker mapMaker = new MapMaker();
	private int gameCount = 0;

	public BridgeGame() {
		bridge = start();
		move(bridge);
	}

	public List<String> start() {
		int size = view.startView();
		return bridgeMaker.makeBridge(size);
	}

	public void move(List<String> bridge) {
		gameCount++;
		for (String rightCondition : bridge) {
			if (!failCheck(rightCondition)) {
				return;
			}
		}
		gameResult(true);
	}

	public boolean failCheck(String rightCondition) {
		if (!mapMaker.conditionCheck(rightCondition)) {
			retry();
			return false;
		}
		return true;
	}

	public void retry() {
		String command = view.retryView();
		if(command.equals("R")) {
			mapMaker = new MapMaker();
			move(bridge);
			return;
		}
		gameResult(false);
	}

	public void gameResult(boolean gameResult) {
		String result = "성공";
		if (!gameResult) {
			result = "실패";
		}
		view.resultView(mapMaker, result, gameCount);
		return;
	}

}