package bridge.domain;

import bridge.Constants;
import java.util.List;

public class Bridge {

	public static final int MIN_LENGTH = 3;
	public static final int MAX_LENGTH = 20;
	private final List<String> value;

	public Bridge(List<String> bridge) {
		validateLength(bridge.size());
		this.value = bridge;
	}

	private void validateLength(int length) {
		if (length < MIN_LENGTH || length > MAX_LENGTH) {
			throw new IllegalArgumentException();
		}
	}

	boolean canWalk(int position, String direction) {
		validatePosition(position);
		int index = position - 1;
		return value.get(index).equals(direction);
	}

	private void validatePosition(int position) {
		if (position < 1 || position > value.size()) {
			throw new IllegalArgumentException();
		}
	}
}
