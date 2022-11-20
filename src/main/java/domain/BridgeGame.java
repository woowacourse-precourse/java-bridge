package domain;

import java.util.List;

import bridge.BridgeRandomNumberGenerator;
import service.InputView;
import service.OutputView;

public class BridgeGame {
	InputView in = new InputView();
	OutputView out = new OutputView();
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
		out.printGameMessage("START");
		out.printGameMessage("BRIDGE_SIZE");
		int size = in.readBridgeSize();

		return bridgeMaker.makeBridge(size);
	}

	public void move(List<String> bridge) {
		gameCount++;

		for (String rightCondition : bridge) {
			if (!failCheck(rightCondition)) {
				break;
			}
		}
		
		ending(true);
	}

	public boolean failCheck(String rightCondition) {
		if (!mapMaker.conditionCheck(rightCondition)) {
			retry();
			return false;
		}

		return true;
	}
	
	public void retry() {
	}
	
	public void ending(boolean gameResult) {
		String result = "성공";

		if (!gameResult) {
			result = "실패";
		}

		out.printResult(mapMaker.toString(), result, gameCount);
		return;
	}

}
