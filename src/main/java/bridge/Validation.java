package bridge;

public class Validation {
	public static int validationConvertBridgeSize(String stringBridgeSize) {
		int convertSize;
		try {
			convertSize = Integer.parseInt(stringBridgeSize);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자 외에 입력해선 안됩니다.");
		}
		return convertSize;
	}

	public static void validationCheckBridgeSizeRange(int bridgeSize) {
		if (bridgeSize < 3 || bridgeSize > 20) {
			throw new IllegalArgumentException("[ERROR] 다리의 길이는 3이상 20이하의 수만 입력해주세요.");
		}
	}

	public static void validationUpOrDown(String upDown) {
		if ((!upDown.equals("U")) && (!upDown.equals("D"))) {
			throw new IllegalArgumentException("[ERROR] 이동 가능한 칸은 U 또는 D만 가능합니다.");
		}
	}

	public static void validationRestartOrQuit(String restartOrQuit) {
		if ((!restartOrQuit.equals("R")) && (!restartOrQuit.equals("Q"))) {
			throw new IllegalArgumentException("[ERROR] 실패한 경우, 재시도(R) 또는 종료(Q)만 입력해주세요.");
		}
	}

	public static void exitGame() {
		throw new IllegalArgumentException();
	}
}
