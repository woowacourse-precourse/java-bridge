package bridge;

import bridge.enums.Command;
import bridge.enums.Map;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

	private final List<String> bridge;
	private final List<String> upperBridge = new ArrayList<>();
	private final List<String> lowerBridge = new ArrayList<>();

	Bridge(List<String> bridge) {
		this.bridge = bridge;
		buildUpperLower();
	}

	private void buildUpperLower() {
		for (String shape : bridge) {
			up(shape);
			down(shape);
		}
	}

	private void up(String shape) {
		if (shape.equals(Command.UP.getValue())) {
			upperBridge.add(Map.SAFE.getValue());
			lowerBridge.add(Map.DIE.getValue());
		}
	}

	private void down(String shape) {
		if (shape.equals(Command.DOWN.getValue())) {
			upperBridge.add(Map.DIE.getValue());
			lowerBridge.add(Map.SAFE.getValue());
		}
	}

	public int getSize() {
		return bridge.size();
	}

	public List<String> getUpperBridge() {
		return upperBridge;
	}

	public List<String> getLowerBridge() {
		return lowerBridge;
	}
}
