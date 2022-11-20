package bridge.view;

public class Square {
	// 하나의 칸을 문자열로 반환하는 함수
	public static String getSquareResult(String userPath, String correctPath) {
		String outputPath = "   |";
		if (userPath.equals(correctPath)) {
			outputPath = " O |";
		}

		return outputPath;
	}

	public static String getLastSquareResult(String userLastPath, String bridgePath, boolean lastRoundResult) {
		if (userLastPath.equals(bridgePath)) {
			if (lastRoundResult == true) {
				return " O ]";
			}
			return " X ]";
		}

		return "   ]";
	}
}
