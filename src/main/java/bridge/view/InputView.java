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
}
