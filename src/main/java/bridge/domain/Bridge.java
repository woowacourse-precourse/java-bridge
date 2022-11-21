package bridge.domain;

import java.util.List;

public class Bridge {
	private static final int MIN_SIZE = 3;
	private static final int MAX_SIZE = 20;
	private static final String BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3이상, 20이하 입니다.";
	private final List<String> blocks;

	public Bridge(List<String> blocks) {
		validSize(blocks.size());
		this.blocks = blocks;
	}

	private void validSize(int size) {
		if (size < MIN_SIZE || size > MAX_SIZE) {
			throw new IllegalArgumentException(BRIDGE_SIZE_ERROR_MESSAGE);
		}
	}

	public boolean isCorrectMoving(String input, int movementCount) {
		return blocks.get(movementCount).equals(input);
	}

	public int getBridgeSize() {
		return blocks.size();
	}
}
