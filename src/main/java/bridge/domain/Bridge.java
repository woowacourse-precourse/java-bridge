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

	public boolean canWalkUp(int position) {
		validatePosition(position);
		int index = position - 1;
		return value.get(index).equals(Constants.UP);
	}

	public void validatePosition(int position) {
		if (position < 1 || position > value.size()) {
			throw new IllegalArgumentException();
		}
	}

	public boolean canWalkDown(int position) {
		validatePosition(position);
		int index = position - 1;
		return value.get(index).equals(Constants.DOWN);
	}
}
