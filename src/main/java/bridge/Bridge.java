package bridge;

import java.util.Arrays;

public enum Bridge {
	UP(1, "U", "O"),
	DOWN(0, "D", " "),
	WRONG(-1, "W", "X"),
	UNKNOWN(2, "F", " ");

	private final int first;
	private final String order;
	private final String result;

	Bridge(int index, String order, String result) {
		this.first = index;
		this.order = order;
		this.result = result;
	}

	public int getFirst() {
		return first;
	}

	public String getOrder() {
		return order;
	}

	public String getResult() {
		return result;
	}
	public static Bridge findOrder(int number) {
		return Arrays.stream(values())
				.filter(v -> v.first == number)
				.findFirst()
				.orElse(UNKNOWN);
	}

	public static Bridge findIndex(String shape) {
		return Arrays.stream(values())
				.filter(v -> v.getOrder().equals(shape))
				.findFirst()
				.orElse(UNKNOWN);
	}
}
