package bridge.model.domain;

import java.util.List;

public enum FootPrint {
	BLANK("   |"),
	RIGHT(" O |"),
	WRONG(" X |"),
	;

	private final String footPrint;

	FootPrint(String footPrint) {
		this.footPrint = footPrint;
	}

	public static List<String> makeFootPrints(int stairsNumber, Boolean isRight) {
		String footPrint = chooseFootPrint(isRight);
		return chooseStairs(footPrint, stairsNumber);
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

	private static List<String> chooseStairs(String footPrint, int stairsNumber) {
		if (stairsNumber == 0) {
			return List.of(footPrint, BLANK.footPrint);
		}
		return List.of(BLANK.footPrint, footPrint);
	}
}
