package bridge.enums;

import java.util.Arrays;

public enum UpDown {
	UP(1, "U"),
	DOWN(0, "D");


	private int numValue;
	private String strValue;

	UpDown(int numValue, String strValue) {
		this.numValue = numValue;
		this.strValue = strValue;
	}

	public static String getStringByNum(int num) {
		return Arrays.stream(values())
				.filter(upDown -> upDown.numValue == num)
				.map(upDown -> upDown.strValue)
				.findAny()
				.orElseThrow(() -> new RuntimeException("No matched Number"));
	}

	public String getStrValue() {
		return strValue;
	}


}
