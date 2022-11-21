package bridge;

import camp.nextstep.edu.missionutils.Console;

/** * 사용자로부터 입력을 받는 역할을 한다. */
public class InputView {
	private BridgeException exception = new BridgeException();

	/**    * 다리의 길이를 입력받는다.    */
	public int readBridgeSize() {
		String userInput = Console.readLine();
		ReadBridgeSizException(userInput);
		return toInt(userInput);
	}

	/**    * 사용자가 이동할 칸을 입력받는다.    */
	public String readMoving() {
		String userInputMove = Console.readLine();
		checkReadMovingException(userInputMove);
		return userInputMove;
	}

	/**    * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.    */
	public String readGameCommand() {
		String usertryOrEnd = Console.readLine();
		checkReadGameCommandException(usertryOrEnd);
		return usertryOrEnd;
	}

	public int toInt(String userInput) {
		return Integer.parseInt(userInput);
	}

	public void ReadBridgeSizException(String userInputSize) {
		exception.checkBridgeSizeNumberMissMatch(userInputSize);
		exception.checkBridgeSize(userInputSize);
	}

	public void checkReadMovingException(String userInputMove) {
		exception.checkMissMatch(userInputMove);
		exception.checkUserInputMove(userInputMove);
	}

	public void checkReadGameCommandException(String usertryOrEnd) {
		exception.checkMissMatch(usertryOrEnd);
	}
}