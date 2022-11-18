package bridge.view;

import bridge.domain.ControllerCommand;
import bridge.domain.Position;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static bridge.config.BridgeGameConstants.BRIDGE_MAX_LENGTH;
import static bridge.config.BridgeGameConstants.BRIDGE_MIN_LENGTH;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final Pattern NUMBERS = Pattern.compile("^[0-9]+$");
    private static final String NOT_NUMBER_MESSAGE = "입력은 숫자로만 이루어져야 합니다";
    private static final String UNDER_SIZE_MESSAGE = "입력은 " + BRIDGE_MIN_LENGTH + "이상이어야 합니다";
    private static final String OVER_SIZE_MESSAGE = "입력은 " + BRIDGE_MAX_LENGTH + "이하여야 합니다";


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        if (!NUMBERS.matcher(input).matches()) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
        int length = Integer.parseInt(input);
        validateBridgeSize(length);
        return length;
    }

    private void validateBridgeSize(int length) {
        if (length < BRIDGE_MIN_LENGTH) {
            throw new IllegalArgumentException(UNDER_SIZE_MESSAGE);
        }
        if (length > BRIDGE_MAX_LENGTH) {
            throw new IllegalArgumentException(OVER_SIZE_MESSAGE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Position readMoving() {
        String input = Console.readLine();
        return Position.from(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public ControllerCommand readGameCommand() {
        String input = Console.readLine();
        return ControllerCommand.from(input);
    }
}
