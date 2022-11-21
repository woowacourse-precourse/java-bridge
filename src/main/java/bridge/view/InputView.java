package bridge.view;

import bridge.domain.GameCommand;
import bridge.domain.Moving;
import bridge.util.validator.BridgeSizeValidator;
import bridge.util.validator.GameCommandValidator;
import bridge.util.validator.MoveDirectionValidator;
import camp.nextstep.edu.missionutils.Console;

import static bridge.exception.ExceptionType.NOT_NUMBER;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public final static int LOWER_BRIDGE_LENGTH = 3;
    public final static int UPPER_BRIDGE_LENGTH = 20;
    private final static String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private final static String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final static String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                return inputBridgeSize();
            } catch (NumberFormatException e) {
                System.out.println(NOT_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);
        final String input = Console.readLine();
        final Integer bridgeSize = Integer.valueOf(input);
        BridgeSizeValidator.validate(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Moving readMoving() {
        while (true) {
            try {
                return inputMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Moving inputMoving() {
        System.out.println(MOVE_MESSAGE);
        final String input = Console.readLine();
        MoveDirectionValidator.validate(input);
        return Moving.getMoveDirection(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        while (true) {
            try {
                return inputGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private GameCommand inputGameCommand() {
        System.out.println(RETRY_MESSAGE);
        final String input = Console.readLine();
        GameCommandValidator.validate(input);
        return GameCommand.getGameCommand(input);
    }
}
