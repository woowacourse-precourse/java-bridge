package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 패키지 변경 ㅇ
 * 함수 인자, 이름, 리턴 변경 ㅇ
 * 필요한 메서드 추가 ㅇ
 */
public class InputView {

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		BridgeSize bridgeSize;
		
		while (true) {
			try {
				bridgeSize = new BridgeSize(readLine());
			} catch (IllegalArgumentException illegalArgumentException) {
				System.out.println(ErrorMessage.ERROR_WRONG_SIZE.getErrorMessage());
				continue;
			}
			return bridgeSize.getSize();
		}
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		return null;
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		return null;
	}
}
