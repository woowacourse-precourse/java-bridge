package bridge.view;

import bridge.validator.InputBridgeSizeValidator;
import bridge.validator.InputMovingValidator;
import bridge.validator.InputRetryOrExitValidator;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n\n" + "다리의 길이를 입력해주세요.";
    private static final String MOVING_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String COMMAND_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자를 입력해야 합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(GAME_START_MESSAGE);

        int size = convertStringToInt(Console.readLine());
        InputBridgeSizeValidator.validateBridgeSize(size);
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVING_INPUT_MESSAGE);

        String movingInput = Console.readLine();
        InputMovingValidator.validateMovingInput(movingInput);
        return movingInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(COMMAND_INPUT_MESSAGE);

        String command = Console.readLine();
        InputRetryOrExitValidator.validateRetryOrExitCommand(command);
        return command;
    }

    private int convertStringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }
}
