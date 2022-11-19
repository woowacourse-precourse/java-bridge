package bridge.domain;

import static bridge.constant.ErrorMessage.*;

import java.util.List;

public class Bridge {
	private final List<String> bridge;

	public Bridge(List<String> bridge) {
		this.bridge = bridge;
	}

	public boolean match(int index, String command) {
		validateIndexRange(index);
		return bridge.get(index).equals(command);
	}

	private void validateIndexRange(int index) {
		if (index < 0 || index >= this.length()) {
			throw new IllegalArgumentException(NOT_INDEX_RANGE.getMessage());
		}
	}

	public int length() {
		return bridge.size();
	}
}
