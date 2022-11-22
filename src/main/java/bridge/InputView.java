package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 제공된 InputView 클래스를 활용해 구현해야 한다.
 * InputView의 패키지는 변경할 수 있다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {

    private static final String INVALID_SIZE_INPUT = "다리 길이는 3부터 20 사이의 정수여야 합니다.";
    private static final String INVALID_MOVING_INPUT = "이동할 칸은 U 또는 D로 이동할 수 있습니다.";
    private static final String INVALID_COMMAND_INPUT = "재시도 여부는 R 또는 Q로 입력해주세요.";
    private static final String READ_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String READ_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String READ_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final InputView inputView = new InputView();

    public static InputView getInstance() {
        return inputView;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        validateBridgeSize(input);
        return Integer.valueOf(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        validateMovingCommand(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        validateGameCommand(input);
        return input;
    }

    private void validateBridgeSize(String input) {
        try {
            int value = Integer.valueOf(input);
            if (value < 3 || value > 20)
                throw new IllegalArgumentException(INVALID_SIZE_INPUT);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_SIZE_INPUT);
        }
    }

    private void validateMovingCommand(String input) {
        if (!MovingCommand.hasCommandOf(input))
            throw new IllegalArgumentException(INVALID_MOVING_INPUT);
    }

    private void validateGameCommand(String input) {
        for (GameCommand command : GameCommand.values()) {
            System.out.println(command);
        }
        if (!GameCommand.hasCommandOf(input))
            throw new IllegalArgumentException(INVALID_COMMAND_INPUT);
    }

    public int getBridgeSize() {
        System.out.println(READ_SIZE_MESSAGE);

        try {
            return readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getBridgeSize();
        }
    }

    public String getMoving() {
        System.out.println(READ_MOVING_MESSAGE);

        try {
            return readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getMoving();
        }
    }

    public String getGameCommand() {
        System.out.println(READ_COMMAND_MESSAGE);

        try {
            return readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getGameCommand();
        }
    }

}
