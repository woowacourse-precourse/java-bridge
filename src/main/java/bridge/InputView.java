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
        return BridgeValidate(Console.readLine());
    }
    private int BridgeValidate(String input) {
        numberValidateRetry(input);
        rangeValidateRetry(input);
        return Integer.parseInt(input);
    }
    private void numberValidateRetry(String input) {
        try {
            numberValidate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBridgeSize();
        }
    }
    private void rangeValidateRetry(String input) {
        try {
            rangeValidate(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBridgeSize();
        }
    }
    public void numberValidate(String input) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new NumberFormatException("[ERROR] 숫자를 입력해주세요.");
        }
    }
    public void rangeValidate(int size) {
        if (!(size >= 3 && size <= 20)) {
            throw new IllegalArgumentException("[ERROR] 3에서 20사이의 숫자를 입력해주세요.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
