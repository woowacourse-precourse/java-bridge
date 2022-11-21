package bridge.vo;

import java.util.List;

public class Bridge {
	private final List<String> bridge;

	public Bridge(List<String> bridge) {
		this.bridge = bridge;
	}

	public String getIndexToCrossValue(int index) {
		return bridge.get(index);
	}

	public List<String> showBridge() {
		return bridge;
	}

	public int getBridgeSize() {
		return bridge.size();
	}
}
