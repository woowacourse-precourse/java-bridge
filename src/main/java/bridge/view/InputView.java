package bridge.view;

import bridge.handler.check.CheckHandler;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		// TODO : 다리 길이 입력시 정상 입력되었는지 확인
		return Integer.parseInt(CheckHandler.isBridgeLengthInput(Console.readLine()));
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		// TODO : 이동 위치 입력시 정상 입력되었는지 확인
		return CheckHandler.isMoveInput(Console.readLine());
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		// TODO : 게임 종료 여부 입력시 정상 입력되었는지 확인
		return CheckHandler.isGameCommandInput(Console.readLine());
	}

}
