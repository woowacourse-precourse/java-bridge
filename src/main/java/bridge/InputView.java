package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.ErrorMessage.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            int i = validateInt(Console.readLine());
            return validateRange(i);
        } catch (IllegalArgumentException e) {
            return readBridgeSize();
        }
    }

    public int validateInt(String s) {
        if (!s.matches("^[0-9]+$")) {
            System.out.println(IS_NOT_NUMBER.returnMessage());
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(s);
    }

    public int validateRange(int i) {
        if (i < 3 || i > 20) {
            System.out.println(OUT_OF_RANGE.returnMessage());
            throw new IllegalArgumentException();
        }
        return i;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String s = Console.readLine();
            return validateMove(s);
        } catch (IllegalArgumentException e) {
            return readMoving();
        }
    }

    public String validateMove(String s) {
        if (!(s.equals("U") || s.equals("D"))) {
            System.out.println(INVALID_MOVE.returnMessage());
            throw new IllegalArgumentException();
        }
        return s;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String s = Console.readLine();
            return validateCommand(s);
        } catch (IllegalArgumentException e) {
            return readGameCommand();
        }
    }

    public String validateCommand(String s) {
        if (!(s.equals("R") || s.equals("Q"))) {
            System.out.println(INVALID_RETRY.returnMessage());
            throw new IllegalArgumentException();
        }
        return s;
    }
}
