package bridge.domain;

import java.util.Arrays;

public enum Bridge {
	TOP(1, 0, "U", "O"),
	BOTTOM(0, 1, "D", " "),
	WRONG(-1, 0, "W", "X"),
	UNKNOWN(2, -1,"F", " ");

	private final int first;
	private final int second;
	private final String order;
	private final String result;

	Bridge(int top, int bottom, String order, String result) {
		this.first = top;
		this.second = bottom;
		this.order = order;
		this.result = result;
	}

	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
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

	public static Bridge findTop(String shape) {
		return Arrays.stream(values())
				.filter(v -> v.getOrder().equals(shape))
				.findFirst()
				.orElse(UNKNOWN);
	}

}
