package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String READ_BRIDGE_SIZE_GUIDE = "다리의 길이를 입력해주세요.";
    private static final String READ_MOVING_GUIDE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String READ_GAME_COMMAND_GUIDE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private final InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(READ_BRIDGE_SIZE_GUIDE);
        try {
            String text = Console.readLine();
            int bridgeSize = inputValidator.validateNumber(text);
            inputValidator.validateBridgeSizeRange(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return readBridgeSize();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(READ_MOVING_GUIDE);
        try {
            String moving = Console.readLine();
            inputValidator.validateInputMoving(moving);
            return moving;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return readMoving();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(READ_GAME_COMMAND_GUIDE);
        try {
            String gameCommand = Console.readLine();
            inputValidator.validateInputGameCommand(gameCommand);
            return gameCommand;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return readGameCommand();
    }
}
