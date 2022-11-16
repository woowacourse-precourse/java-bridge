package bridge.view;

import static bridge.view.Validator.*;

import java.util.NoSuchElementException;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	final String SIZE_INPUT = "다리의 길이를 입력해주세요.";
	final String MOVE_INPUT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	final String COMMAND_INPUT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

	public int readBridgeSize() {
		System.out.println(SIZE_INPUT);
		int size;
		try {
			size = Integer.parseInt(Console.readLine());
			isSizeValidate(size);
		} catch (NoSuchElementException exception) {
			throw new IllegalArgumentException(INVALID_INPUT);
		}
		return size;
	}

	public String readMoving() {
		System.out.println(MOVE_INPUT);
		String input = Console.readLine();
		isMoveValidate(input);
		return input;
	}

	public String readGameCommand() {
		System.out.println(COMMAND_INPUT);
		String command = Console.readLine();
		isCommandValidate(command);
		return command;
	}
}
