package bridge.domain;

import java.util.List;

public class Bridge {
	private final List<String> bridge;

	public Bridge(List<String> bridge) {
		this.bridge = bridge;
	}

	public boolean match(int index, String position) {
		return bridge.get(index).equals(position);
	}

	public int length() {
		return bridge.size();
	}
}
