package bridge;

import java.util.Arrays;

public enum Bridge {
	UP(1, 0, "U", "O"),
	DOWN(0, 1, "D", " "),
	WRONG(-1, 0, "W", "X"),
	UNKNOWN(2, -1,"F", " ");

	private final int top;
	private final int bottom;
	private final String order;
	private final String result;

	Bridge(int top, int bottom, String order, String result) {
		this.top = top;
		this.bottom = bottom;
		this.order = order;
		this.result = result;
	}

	public int getTop() {
		return top;
	}

	public int getBottom() {
		return bottom;
	}

	public String getOrder() {
		return order;
	}

	public String getResult() {
		return result;
	}
	public static Bridge findOrder(int number) {
		return Arrays.stream(values())
				.filter(v -> v.top == number)
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
