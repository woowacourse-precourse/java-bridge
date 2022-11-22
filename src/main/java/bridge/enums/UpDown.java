package bridge.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum UpDown {
	UP(1, "U"),
	DOWN(0, "D");


	private final int numValue;
	private final String direction;

	UpDown(int numValue, String direction) {
		this.numValue = numValue;
		this.direction = direction;
	}

	public static String convertNumToDirection(int num) {
		return Arrays.stream(values())
				.filter(upDown -> upDown.numValue == num)
				.map(upDown -> upDown.direction)
				.findAny()
				.orElseThrow(() -> new RuntimeException("No matched Number"));
	}

	public String getDirection() {
		return direction;
	}

	public static List<String> getStrValues() {
		return Arrays.stream(values())
				.map(UpDown::getDirection)
				.collect(Collectors.toList());
	}

	public static boolean isUp(String src) {
		return src.equals(UP.getDirection());
	}

	public static boolean isDown(String src) {
		return src.equals(DOWN.getDirection());
	}


}
