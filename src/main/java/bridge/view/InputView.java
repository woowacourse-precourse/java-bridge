package bridge.view;

import static java.lang.Integer.parseInt;

import bridge.domain.Bridge;
//import bridge.domain.SubBridge;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_BLOCK_TO_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final String INPUT_GAME_COMMAND_ERROR = "[ERROR] 게임 재시작/종료 값은 R 또는 Q 중 하나의 문자여야 합니다.";
    private static final String INPUT_VALUE_LENGTH_ERROR = "[ERROR] 입력 값의 길이는 1이어야 합니다.";
    private static final String INPUT_BLOCK_TO_MOVE_ERROR = "[ERROR] 이동할 칸은 U 또는 D 중 하나의 문자여야 합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public Bridge readBridgeSize() {
        try {
            System.out.println(INPUT_BRIDGE_SIZE);
            return new Bridge(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            System.out.println(INPUT_BLOCK_TO_MOVE);
            String input = Console.readLine();
            validateBlockToMove(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            System.out.println(INPUT_GAME_COMMAND);
            String input = Console.readLine();
            validateGameCommand(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private void validateBlockToMove(String input) {
        validateLength(input);
        validateCorrectBlock(input);
    }

    private void validateGameCommand(String input) {
        validateLength(input);
        validateCorrectCommand(input);
    }

    private void validateCorrectCommand(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(INPUT_GAME_COMMAND_ERROR);
        }
    }

    private void validateLength(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(INPUT_VALUE_LENGTH_ERROR);
        }
    }

    private void validateCorrectBlock(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(INPUT_BLOCK_TO_MOVE_ERROR);
        }
    }
}
