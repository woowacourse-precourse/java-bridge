package bridge;

import java.util.Arrays;

public enum Bridge {
	UP(1, "U"),
	DOWN(0, "D"),
	UNKNOWN(-1, "False");

	private final int index;
	private final String order;

	Bridge(int index, String order) {
		this.index = index;
		this.order = order;
	}

	public int getIndex() {
		return index;
	}

	public String getOrder() {
		return order;
	}
	public static Bridge findOrder(int number) {
		return Arrays.stream(values())
				.filter(v -> v.index == number)
				.findFirst()
				.orElse(UNKNOWN);
	}
}
