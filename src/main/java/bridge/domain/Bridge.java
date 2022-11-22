package bridge.domain;

import bridge.ErrorMessages;
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
			throw new IllegalArgumentException(ErrorMessages.INVALID_BRIDGE_LENGTH);
		}
	}

	public boolean canWalk(int position, String moving) {
		validatePosition(position);
		return value.get(position).equals(moving);
	}

	private void validatePosition(int position) {
		if (position < 0 || position >= value.size()) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_POSITION);
		}
	}

	public int getLength() {
		return value.size();
	}
}
