package bridge.view;

import bridge.domain.BridgeGameCommand;
import bridge.domain.BridgeGamePosition;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static bridge.common.BridgeGameConstant.BRIDGE_MAX_LENGTH;
import static bridge.common.BridgeGameConstant.BRIDGE_MIN_LENGTH;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final Pattern NUMBERS_CORRECT_PATTERN = Pattern.compile("^[0-9]+$");
    private static final String INPUT_IS_NOT_NUMBER_MESSAGE = "입력은 숫자로만 이루어져야 합니다";
    private static final String MIN_SIZE_MESSAGE = "입력은 " + BRIDGE_MIN_LENGTH + "이상이어야 합니다";
    private static final String MAX_SIZE_MESSAGE = "입력은 " + BRIDGE_MAX_LENGTH + "이하여야 합니다";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        if (!NUMBERS_CORRECT_PATTERN.matcher(input).matches()){
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER_MESSAGE);
        }
        int bridgeLength = Integer.parseInt(input);
        validateBridgeLength(bridgeLength);
        return bridgeLength;
    }

    private void validateBridgeLength(int bridgeLength) {
        if (bridgeLength < BRIDGE_MIN_LENGTH) {
            throw new IllegalArgumentException(MIN_SIZE_MESSAGE);
        }
        if (bridgeLength > BRIDGE_MAX_LENGTH) {
            throw new IllegalArgumentException(MAX_SIZE_MESSAGE);
        }
    }
}
