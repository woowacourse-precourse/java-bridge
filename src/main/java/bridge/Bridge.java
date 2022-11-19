package bridge;

import java.util.List;

public class Bridge {
	private final List<String> bridge;

	public Bridge(List<String> bridge) {
		this.bridge = bridge;
	}

	public boolean isCorrectMoving(int index, String moving) {
		return bridge.get(index).equals(moving);
	}

	public int getBridgeSize() {
		return bridge.size();
	}

	public List<String> getBridge() {
		return bridge;
	}
}
