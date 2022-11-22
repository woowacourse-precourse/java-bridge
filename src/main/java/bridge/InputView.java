package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String BRIDGE_MAKE_MASSAGE = "다리의 길이를 입력해주세요.";

    private static final String RETRY_QUESTION_MASSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_MAKE_MASSAGE);
        String rawInputValue = Console.readLine();
        int bridgeSize = parseNumber(rawInputValue);
        numberRangeCheck(bridgeSize);
        return bridgeSize;
    }

    private Integer parseNumber(String rawInputValue) {
        try {
            return Integer.parseInt(rawInputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void numberRangeCheck(int bridgeSize) {
        if (bridgeSize > 20 || 3 > bridgeSize) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_MESSAGE);
        String movingWay = Console.readLine();
        validateWay(movingWay);
        return movingWay;
    }

    private void validateWay(String rawInput) {
        if (!Objects.equals(rawInput, "U") && !Objects.equals(rawInput, "D")) {
            throw new IllegalArgumentException("[ERROR] U 혹은 D 를 입력해야합니다. (대,소문자 구분)");
        }
    }

    private String  validateGameCommand(String rawInput) {
        if (!Objects.equals(rawInput, "R") && !Objects.equals(rawInput, "Q")) {
            throw new IllegalArgumentException("[ERROR] R 혹은 Q 를 입력해야합니다. (대,소문자 구분)");
        }
        return rawInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RETRY_QUESTION_MASSAGE);
        return validateGameCommand(Console.readLine());
    }
}
