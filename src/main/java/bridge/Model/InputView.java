package bridge.Model;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INT_REGEX = "^[0-9]*$";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String input) {
        // 예외처리
        checkNumber(input);
        checkRange(input);

        return changeInt(input);
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

    /**
     * 입력받은 String 을 int 로 변환한다.
     */
    private int changeInt(String input) {
        return Integer.parseInt(input);
    }
    /**
     * 입력받은 숫자가 범위(3 ~ 20)를 벗어날 경우 IllegalArgumentException 을 발생시킨다.
     */
    private void checkRange(String input) {
        int number = changeInt(input);
        if(number < 3 || number > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
    /**
     * 입력받은 값이 숫자가 아닐 경우 IllegalArgumentException 을 발생시킨다.
     */
    private void checkNumber(String input) {
        if(!input.matches(INT_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다.");
        }
    }
}
