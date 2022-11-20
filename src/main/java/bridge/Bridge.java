package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
	private List<String> bridge;
	private List<String> upperBridge = new ArrayList<>();
	private List<String> lowerBridge = new ArrayList<>();

	Bridge(List<String> bridge) {
		this.bridge = bridge;
		buildUpperLower();
	}

	private void buildUpperLower() {
		for(String shape : bridge) {
			up(shape);
			down(shape);
		}
	}

	private void up(String shape) {
		if(shape.equals("U")) {
			upperBridge.add(" O ");
			lowerBridge.add(" X ");
		}
	}

	private void down(String shape) {
		if(shape.equals("D")) {
			upperBridge.add(" X ");
			lowerBridge.add(" O ");
		}
	}

	public int getSize() {
		return bridge.size();
	}

	public List<String> getBridge() {
		return bridge;
	}

	public List<String> getUpperBridge() {
		return upperBridge;
	}

	public List<String> getLowerBridge() {
		return lowerBridge;
	}
}
