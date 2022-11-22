package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String READ_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private static final String READ_MOVING_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String READ_GAME_COMMAND_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private final InputValidator inputValidator = new InputValidator();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(READ_BRIDGE_SIZE_MESSAGE);
        String size = Console.readLine();
        inputValidator.validateBridgeSize(size);
        return Integer.parseInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(READ_MOVING_MESSAGE);
        String move = Console.readLine();
        inputValidator.validateMoving(move);
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(READ_GAME_COMMAND_MESSAGE);
        String command = Console.readLine();
        inputValidator.validateCommand(command);
        return command;
    }
}
