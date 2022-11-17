package bridge.view;

import bridge.validator.InputViewValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String WHITE_SPACE = "\\s";
    private static final String EMPTY = "";
    private static final String PRINT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String PRINT_SELECT_MOVING_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String PRINT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                return getBridgeSize();
            } catch (IllegalArgumentException illegalArgumentException) {
                ErrorView.printException(illegalArgumentException);
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println();
        System.out.println(PRINT_SELECT_MOVING_DIRECTION);
        String userInput = Console.readLine().replaceAll(WHITE_SPACE, EMPTY);

         return getMovingCommand(userInput);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println();
        System.out.println(PRINT_RETRY);
        String userInput = Console.readLine().replaceAll(WHITE_SPACE, EMPTY);
        return getRetryCommand(userInput);
    }

    private String getMovingCommand(String userInput) {
        while (true) {
            try {
                return InputViewValidator.movingCommandValidation(userInput);
            } catch (IllegalArgumentException illegalArgumentException) {
                ErrorView.printException(illegalArgumentException);
            }
        }
    }

    private String getRetryCommand(String userInput) {
        while (true) {
            try {
                return InputViewValidator.retryCommandValidation(userInput);
            } catch (IllegalArgumentException illegalArgumentException) {
                ErrorView.printException(illegalArgumentException);
            }
        }
    }

    private int getBridgeSize() {
        System.out.println();
        System.out.println(PRINT_BRIDGE_SIZE);
        String userInput = Console.readLine().replaceAll(WHITE_SPACE, EMPTY);
        return Integer.parseInt(InputViewValidator.ckeckBridgeSize(userInput));
    }
}
