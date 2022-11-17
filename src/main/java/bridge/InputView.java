package bridge;

import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
	private int bridgeLength = 0;
	private String upOrDown = "";
	private String restartOrQuit = "";

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		while (this.bridgeLength != 0) {
			System.out.println("\n다리의 길이를 입력해주세요.");
			String bridgeLengthStr = Console.readLine();
			try {
				bridgeSizeExceptionCheck(bridgeLengthStr);
			} catch (IllegalArgumentException e) {
				continue;
			}
		}
		return this.bridgeLength;
	}

	public void bridgeSizeExceptionCheck(String bridgeLengthStr) {
		String pattern = "^[0-9]+$";
		int bridgeLength = 0;
		if (Pattern.matches(pattern, bridgeLengthStr)) {
			bridgeLength = Integer.parseInt(bridgeLengthStr);
			if (bridgeLength < 3 || bridgeLength > 20) {
				throw new IllegalArgumentException("[ERROR] 다리의 길이는 3이상 20이하의 정수입니다.");
			}
		}
		this.bridgeLength = bridgeLength;
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		while (!upOrDown.equals("")) {
			System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
			String tempUpOrDown = Console.readLine();
			try {
				readMovingExceptionCheck(tempUpOrDown);
			} catch (IllegalArgumentException e) {
				continue;
			}
		}
		return upOrDown;
	}

	public void readMovingExceptionCheck(String tempUpOrDown) {
		if (!tempUpOrDown.equals("U") || !tempUpOrDown.equals("D")) {
			throw new IllegalArgumentException("[ERROR] U와 D만 선택하세요.");
		}
		this.upOrDown = tempUpOrDown;
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		while (!restartOrQuit.equals("")) {
			System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q");
			String tempRestartOrQuit = Console.readLine();
			try {
				readGameCommandExceptionCheck(tempRestartOrQuit);
			} catch (IllegalArgumentException e) {
				continue;
			}
		}
		return upOrDown;
	}
	
	public void readGameCommandExceptionCheck(String tempRestartOrQuit) {
		if (!tempRestartOrQuit.equals("R") || !tempRestartOrQuit.equals("Q")) {
			throw new IllegalArgumentException("[ERROR] R와 Q만 선택하세요.");
		}
		this.restartOrQuit = tempRestartOrQuit;
	}
}
