package bridge.view;

import bridge.util.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String READ_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String READ_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String READ_GAME_COMMEND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                System.out.println(READ_BRIDGE_SIZE_MESSAGE);
                String input = Console.readLine();
                InputValidator.validateBridgeSize(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                System.out.println(READ_MOVING_MESSAGE);
                String input = Console.readLine();
                InputValidator.validateMoving(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                System.out.println(READ_GAME_COMMEND_MESSAGE);
                String input = Console.readLine();
                InputValidator.validateGameCommand(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
