package bridge.view;

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
        String line = Console.readLine();
        if (!validateBridgeSize(line)) {
            throw new IllegalArgumentException("다리 길이는 3과 20 사이의 숫자의 숫자입니다.");
        }
        return Integer.parseInt(line);
    }

    public boolean validateBridgeSize(String line) {
        if (!Pattern.matches("^[0-9]{1,2}$", line)) {
            return false;
        }

        int size = Integer.parseInt(line);
        return 3 <= size && size <= 20;
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
