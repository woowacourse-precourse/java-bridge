package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        int number;
        while (true) {
            try {
                number = tryNumInput();
                break;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
        return number;
    }

    public static int tryNumInput() {
        int number;
        try {
            String input = camp.nextstep.edu.missionutils.Console.readLine();
            number = Integer.parseInt(input);
            validateNumber(number);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    public static void validateNumber(int number) {
        if (number < 3 || 20 < number) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String input;
        while (true) {
            try {
                input = tryForwardInput();
                break;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("[ERROR] U 또는 D만 입력해야 합니다.");
            }
        }
        return input;
    }

    public static String tryForwardInput() {
        String input;
        try {
            input = camp.nextstep.edu.missionutils.Console.readLine();
            validateForward(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static void validateForward(String forward) {
        if (!forward.equals("U") && !forward.equals("D")) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String input;
        while (true) {
            try {
                input = tryRetryInput();
                break;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("[ERROR] R 또는 Q만 입력해야 합니다.");
            }
        }
        return input;
    }

    public static String tryRetryInput() {
        String input;
        try {
            input = camp.nextstep.edu.missionutils.Console.readLine();
            validateRetry(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static void validateRetry(String select) {
        if (!select.equals("R") && !select.equals("Q")) {
            throw new IllegalArgumentException();
        }
    }

}

