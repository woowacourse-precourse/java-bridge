package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String input) {
        valid(input);
        return Integer.parseInt(input);
    }

    void valid(String input) throws IllegalArgumentException {
        if (!isNumber(input)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 '숫자'여야 합니다.");
        }
        if (!isNumberInValidRange(input)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

        }
    }

    private boolean isNumberInValidRange(String input) {
        int number = Integer.parseInt(input);
        if (number <= 20 && number >= 3) {
            return true;
        }
        return false;
    }

    private boolean isNumber(String input) {
        for (int i = 0; i <input.length() ; i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                return false;
            }
        }
        return true;
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
}
