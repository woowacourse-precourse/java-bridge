package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * TODO 메서드 시그니처(인자, 이름)와 반환 타입 변경 가능
 * TODO 메서드 추가 가능
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int bridgeSize() {
        String inputValue = readLine();
        validateThisIsNumber(inputValue);
        return Integer.parseInt(inputValue);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String movement() {
        String inputValue = readLine();
        validateCorrectValueForMoving(inputValue);
        return inputValue;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String gameCommand() {
        String inputValue = readLine();
        validateCorrectValueForGameCommand(inputValue);
        return inputValue;
    }

    private String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("값이 입력되지 않았습니다. 값을 입력해 주세요.");
        }
    }

    private void validateThisIsNumber(String inputValue) {
        final String REGEX_FOR_NUMBER = "^\\d+$";
        if (!inputValue.matches(REGEX_FOR_NUMBER)) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }

    private void validateCorrectValueForMoving(String inputValue) {
        final String VALUE_FOR_UP = "U";
        final String VALUE_FOR_DOWN = "D";
        if (!inputValue.equals(VALUE_FOR_UP) && !inputValue.equals(VALUE_FOR_DOWN)) {
            throw new IllegalArgumentException("U 또는 D만 입력해 주세요. (U:위, D:아래)");
        }
    }

    private void validateCorrectValueForGameCommand(String inputValue) {
        final String VALUE_FOR_RESTART = "R";
        final String VALUE_FOR_QUIT = "Q";
        if (!inputValue.equals(VALUE_FOR_RESTART) && !inputValue.equals(VALUE_FOR_QUIT)) {
            throw new IllegalArgumentException("R 또는 Q만 입력해 주세요. (R:재시작, Q:종료)");
        }
    }
}
