package bridge.model;

import java.util.List;

public enum FootPrint {
	Blank("   |"),
	RIGHT(" O |"),
	WRONG(" X |");

	private final String footPrint;

	FootPrint(String footPrint) {
		this.footPrint = footPrint;
	}

	public static List<String> makeFootPrints(int stairs, Boolean isRight) {
		String footPrint = chooseFootPrint(isRight);
		return chooseStairs(footPrint, stairs);
	}

	public String getFootPrint() {
		return footPrint;
	}

	private static String chooseFootPrint(Boolean isRight) {
		if (isRight) {
			return RIGHT.footPrint;
		}
		return WRONG.footPrint;
	}

	private static List<String> chooseStairs(String footPrint, int stairs) {
		if (stairs == 0) {
			return List.of(footPrint, Blank.footPrint);
		}
		return List.of(Blank.footPrint, footPrint);
	}
}
