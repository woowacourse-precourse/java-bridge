package bridge;

import java.util.ArrayList;
import java.util.List;

import bridge.enums.Inputs;

public class Bridge {

	private List<String> bridge;
	private int nextStep;

	public Bridge(int size, BridgeNumberGenerator bridgeNumberGenerator) {
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
		this.bridge = bridgeMaker.makeBridge(size);
		this.nextStep = 0;
	}

	public boolean moveNext(Inputs move) {
		String correctMove = bridge.get(nextStep);
		if (correctMove == move.getMessage()) {
			nextStep++;
			return true;
		}
		return false;
	}

	public boolean gameWon() {
		if (nextStep >= bridge.size()) {
			return true;
		}
		return false;
	}

	public List<String> getSuccessfullyMovedPartialBridge() {
		List<String> deepCopiedPartialBridge = new ArrayList<>();
		for (int i = 0; i < nextStep; i++) {
			deepCopiedPartialBridge.add(bridge.get(i));
		}
		return deepCopiedPartialBridge;
	}

	public void resetMoveStatus() {
		this.nextStep = 0;
	}
}
