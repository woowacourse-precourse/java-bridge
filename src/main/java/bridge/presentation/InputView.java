package bridge.presentation;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String MOVING_REGEX = "^[UD]$";
    private static final String COMMAND_REGEX = "^[RQ]$";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.INTRO);
        System.out.println(Message.INPUT_SIZE);

        String line = Console.readLine();
        validateBridgeSize(line);

        return Integer.parseInt(line);
    }

    private void validateBridgeSize(String line) {
        if (!line.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("BridgeSize 값은 숫자만 입력될 수 있습니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Message.INPUT_MOVING);

        String line = Console.readLine();
        validateMoving(line);

        return line;
    }

    private void validateMoving(String line) {
        if (!line.matches(MOVING_REGEX)) {
            throw new IllegalArgumentException("이동 명령은 U, D 만 입력될 수 있습니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Message.INPUT_COMMAND);

        String line = Console.readLine();
        validateCommand(line);

        return line;
    }

    private void validateCommand(String line) {
        if (!line.matches(COMMAND_REGEX)) {
            throw new IllegalArgumentException("게임 조작 명령은 R, Q 만 입력될 수 있습니다.");
        }
    }
}
