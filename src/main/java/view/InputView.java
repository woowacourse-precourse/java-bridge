package view;

import static bridge.enums.Regex.BRIDGE_SIZE_REGEX;
import static bridge.enums.ErrorMessages.BRIDGE_SIZE_ERROR_MESSAGE;
import static bridge.enums.Range.STARTING_POINT_INCLUSIVE;
import static bridge.enums.Range.ENDING_POINT_INCLUSIVE;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String size = Console.readLine();
        validateSize(size);
        return toInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void validateSize(String size) {
        if (size.length() > 2 || !Pattern.matches(BRIDGE_SIZE_REGEX.toString(), size)
                || !isValidateSize(size)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR_MESSAGE.toString());
        }
    }

    private boolean isValidateSize(String size) {
        int bridgeSize = toInt(size);
        return (bridgeSize >= STARTING_POINT_INCLUSIVE.getPoint()
                && bridgeSize <= ENDING_POINT_INCLUSIVE.getPoint());
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }
}
