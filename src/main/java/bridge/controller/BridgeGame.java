package bridge.controller;

import static bridge.controller.Constant.*;

import java.util.ArrayList;
import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

public class BridgeGame {

	private final BridgeNumberGenerator generator;
	private final BridgeMaker bridgeMaker;
	private final List<String> bridge;
	private String upsideBridge = "";
	private String downsideBridge = "";
	private int tryCount = 1;

	public BridgeGame(int size) {
		this.generator = new BridgeRandomNumberGenerator();
		this.bridgeMaker = new BridgeMaker(generator);
		this.bridge = bridgeMaker.makeBridge(size);
	}

	public List<String> move(String location, int index) {
		List<String> state = new ArrayList<>();
		setUpsideBridge(location, index);
		setDownsideBridge(location, index);

		state.add(this.upsideBridge);
		state.add(this.downsideBridge);

		return state;
	}

	private void setDownsideBridge(String location, int index) {
		if (location.equals(DOWNSIDE) && location.equals(bridge.get(index))) {
			upsideBridge += BLANK;
			downsideBridge += RIGHT;
		}
		if (location.equals(DOWNSIDE) && !location.equals(bridge.get(index))) {
			upsideBridge += BLANK;
			downsideBridge += WRONG;
		}
	}

	private void setUpsideBridge(String location, int index) {
		if (location.equals(UPSIDE) && location.equals(bridge.get(index))) {
			upsideBridge += RIGHT;
			downsideBridge += BLANK;
		}
		if (location.equals(UPSIDE) && !location.equals(bridge.get(index))) {
			upsideBridge += WRONG;
			downsideBridge += BLANK;
		}
	}

	public void retry() {
		this.upsideBridge = "";
		this.downsideBridge = "";
		this.tryCount++;
	}

	public int getTryCount() {
		return tryCount;
	}
}
