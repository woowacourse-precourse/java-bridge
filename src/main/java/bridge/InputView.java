package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        return numberValidateRetry(Console.readLine());
    }

    private int numberValidateRetry(String input) {
        try {
            return rangeValidateRetry(numberValidate(input));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    private int rangeValidateRetry(int input) {
        try {
            return rangeValidate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    public int numberValidate(String input) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new NumberFormatException("[ERROR] 숫자를 입력해주세요.");
        }
        return Integer.parseInt(input);
    }

    //3에서 20사이 검증
    public int rangeValidate(int size) {
        if (!(size >= 3 && size <= 20)) {
            throw new IllegalArgumentException("[ERROR] 3에서 20사이의 숫자를 입력해주세요.");
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return movingValidateRetry(Console.readLine());
    }

    public String movingValidateRetry(String input) {
        try {
            return movingValidate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    public String movingValidate(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] U 와 D 중 하나를 입력해주세요.");
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return GameCommandValidateRetry(Console.readLine());
    }

    public String GameCommandValidateRetry(String input) {
        try {
            return GameCommandValidate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    public String GameCommandValidate(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] R 와 Q 중 하나를 입력해주세요.");
        }
        return input;
    }
}
