package bridge.view;

import bridge.domain.Direction;
import bridge.domain.Range;
import bridge.domain.Restart;
import bridge.validate.ValidateNumberFormat;
import bridge.validate.ValidateStringFormat;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static final String READ_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String READ_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String READ_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String inputValue = Console.readLine();
            validateBridgeSize(inputValue);
            return Integer.parseInt(inputValue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    public void showBridgeSizeMessage() {
        System.out.println(READ_BRIDGE_SIZE_MESSAGE);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String inputValue = Console.readLine();
            validateMoving(inputValue);
            return inputValue;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    public void showMovingMessage() {
        System.out.println(READ_MOVING_MESSAGE);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String inputValue = Console.readLine();
            validateGameCommand(inputValue);
            return inputValue;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    public void showGameCommandMessage() {
        System.out.println(READ_GAME_COMMAND_MESSAGE);
    }

    private void validateBridgeSize(String inputValue) {
        ValidateNumberFormat.validate(inputValue);
        Range.validate(Integer.parseInt(inputValue));
    }

    private void validateMoving(String inputValue) {
        ValidateStringFormat.validate(inputValue);
        Direction.validate(inputValue);
    }

    private void validateGameCommand(String inputValue) {
        ValidateStringFormat.validate(inputValue);
        Restart.validate(inputValue);
    }
}
