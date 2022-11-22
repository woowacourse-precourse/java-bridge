package bridge;

public enum SideTypes {

	D(0, "D"),
	U(1, "U"),
	;

	private final int number;
	private final String type;

	SideTypes(int number, String type) {
		this.number = number;
		this.type = type;
	}

	public static String getType(int number) {
		for (SideTypes sideType : SideTypes.values()) {
			if (sideType.number == number) {
				return sideType.type;
			}
		}
		throw new IllegalArgumentException("숫자 0과 1만 입력해 주세요.");
	}

	public int getNumber() {
		return number;
	}

	public String getType() {
		return type;
	}
}
