package bridge;

import bridge.system.SystemValue;
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
        String input = Console.readLine();
        validateForConsistOfNumber(input);
        validateForRangeOfNumber(input);
        return Integer.parseInt(input);
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

    private void validateForConsistOfNumber(String text) {
        Pattern pattern = Pattern.compile(SystemValue.REGEX_CONSIST_NUMBER);
        if (!pattern.matcher(text).matches()) {
            throw new IllegalArgumentException("[ERROR] 다리 길이 입력 값이 숫자가 아닙니다.");
        }
    }

    private void validateForRangeOfNumber(String text) {
        int num = Integer.parseInt(text);
        if (num < SystemValue.MIN_RANGE_BRIDGE_SIZE || num > SystemValue.MAX_RANGE_BRIDGE_SIZE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이 입력 값이 3이상 20이하의 숫자가 아닙니다.");
        }
    }
}
