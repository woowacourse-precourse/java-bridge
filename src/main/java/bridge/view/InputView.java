package bridge.view;

import bridge.model.constant.Error;
import bridge.model.validation.ExitOption;
import bridge.model.validation.Stairs;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
	private static final String BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요.";
	private static final String MOVING_MESSAGE = String.format("\n이동할 칸을 선택해주세요. (위: %s, 아래: %s)",
		Stairs.UP.getCommand(), Stairs.DOWN.getCommand());
	private static final String RETRY_MESSAGE = String.format("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)",
		ExitOption.REPLAY.getCommand(), ExitOption.QUIT.getCommand());

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		System.out.println(BRIDGE_SIZE_MESSAGE);
		try {
			return Integer.parseInt(Console.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Error.FORMAT.getMessage());
		}
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		System.out.println(MOVING_MESSAGE);
		return Console.readLine();
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		System.out.println(RETRY_MESSAGE);
		return Console.readLine();
	}

}
