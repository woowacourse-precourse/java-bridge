package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;

    public String input() {
        return Console.readLine();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        String size = input();
        validateIsNotEmpty(size);
        validateIsNumber(size);
        return validateIsLengthRange(size);
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

    public void validateIsNotEmpty(String size) {
        if(size.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    public void validateIsNumber(String size) {
        String regExp = "^[0-9]*$";
        if(!size.matches(regExp) || String.valueOf(size.charAt(0)).equals("0")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }

    public int validateIsLengthRange(String input) {
        int size = Integer.parseInt(input);
        if(size < MIN_LENGTH || size > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return size;
    }
}
