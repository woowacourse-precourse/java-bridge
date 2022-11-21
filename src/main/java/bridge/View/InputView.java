package bridge.View;

import bridge.Service.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String READ_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String READ_MOVING_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String READ_COMMAND_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private InputValidator inputValidator = new InputValidator();

    public int readBridgeSize() {
        System.out.println(READ_SIZE_MESSAGE);

        String input = Console.readLine();

        inputValidator.validateDigit(input);
        int size = Integer.parseInt(input);

        inputValidator.validateSize(size);

        return size;
    }

    public String readMoving() {
        System.out.println(READ_MOVING_MESSAGE);

        String input = Console.readLine();

        inputValidator.validateMoving(input);

        return input;
    }

    public String readGameCommand() {
        System.out.println(READ_COMMAND_MESSAGE);

        String input = Console.readLine();

        inputValidator.validateCommand(input);

        return input;
    }
}
