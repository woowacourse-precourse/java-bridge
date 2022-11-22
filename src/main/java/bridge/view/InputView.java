package bridge.view;

import bridge.common.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_COMMAND_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final int VALID_BRIDGE_SIZE_LOWER_BOUND = 3;
    private static final int VALID_BRIDGE_SIZE_UPPER_BOUND = 20;
    private static List<String> VALID_MOVING = List.of("U", "D");
    private static List<String> VALID_GAME_COMMAND = List.of("R", "Q");

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
        String size = Console.readLine();
        validateSizeInput(size);
        return Integer.parseInt(size);
    }

    // == validation ==
    private void validateSizeInput(String size) {
        int bridgeSize = convertInteger(size);
        validateSize(bridgeSize);
    }

    private int convertInteger(String size) {
        try {
            return Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.isInvalidNumber());
        }
    }

    private void validateSize(int size) {
        if (size < VALID_BRIDGE_SIZE_LOWER_BOUND || size > VALID_BRIDGE_SIZE_UPPER_BOUND) {
            throw new IllegalArgumentException(ErrorMessage.isInvalidRoundRange());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVING_MESSAGE);
        String moving = Console.readLine();
        validateMoving(moving);
        return moving;
    }

    private void validateMoving(String move) {
        if (!VALID_MOVING.contains(move)) {
            throw new IllegalArgumentException(ErrorMessage.isInvalidMovingCommand());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_GAME_COMMAND_MESSAGE);
        String gameCommand = Console.readLine();
        validateGameCommand(gameCommand);
        return gameCommand;
    }

    private void validateGameCommand(String command) {
        if (!VALID_GAME_COMMAND.contains(command)) {
            throw new IllegalArgumentException(ErrorMessage.isInvalidGameCommand());

        }
    }
}
