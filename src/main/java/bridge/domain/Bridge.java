package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

	private static final String NOT_INDEX_RANGE = "[ERROR] 다리의 길이와 일치하지 않는 위치입니다.";

	private final List<Move> bridge;

	public Bridge(List<String> bridge) {
		this.bridge = bridge.stream()
			.map(Move::find)
			.collect(Collectors.toList());
	}

	public boolean match(int index, Move move) {
		validateIndexRange(index);
		return bridge.get(index).equals(move);
	}

	private void validateIndexRange(int index) {
		if (index < 0 || index >= this.length()) {
			throw new IllegalArgumentException(NOT_INDEX_RANGE);
		}
	}

	public int length() {
		return bridge.size();
	}
}
