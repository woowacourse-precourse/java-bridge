package bridge.view;

import static bridge.view.Validator.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String SIZE_INPUT = "다리의 길이를 입력해주세요.";
	private static final String MOVE_INPUT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private static final String COMMAND_INPUT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

	public static int readBridgeSize() {
		System.out.println(SIZE_INPUT);
		int size;
		try {
			size = Integer.parseInt(Console.readLine());
			isSizeValidate(size);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(SIZE_ERROR);
		}
		return size;
	}

	public static String readMoving() {
		System.out.println(MOVE_INPUT);
		String input = Console.readLine();
		isMoveValidate(input);
		return input;
	}

	public static String readGameCommand() {
		System.out.println(COMMAND_INPUT);
		String command = Console.readLine();
		isCommandValidate(command);
		return command;
	}
}
