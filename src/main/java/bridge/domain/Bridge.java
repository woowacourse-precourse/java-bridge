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

	public String getOrder() {
		return order;
	}

	public String getResult() {
		return result;
	}

	public static String findOrder(int number) {
		return findValueByNumber(number).order;
	}

	public static int findTop(String shape) {
		return findMovingByShape(shape).first;
	}

	public static int findBottom(String shape) {
		return findMovingByShape(shape).second;
	}

	public static String findResult(int number) {
		return findValueByNumber(number).result;
	}

	private static Bridge findValueByNumber(int number) {
		return Arrays.stream(values())
				.filter(v -> v.first == number)
				.findFirst()
				.orElse(UNKNOWN);
	}

	private static Bridge findMovingByShape(String shape) {
		return Arrays.stream(values())
				.filter(v -> v.order.equals(shape))
				.findFirst()
				.orElse(UNKNOWN);
	}
}
