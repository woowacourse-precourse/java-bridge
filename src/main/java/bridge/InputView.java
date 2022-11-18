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
        return numberValidate(Console.readLine());
    }

    //숫자 검증
    public int numberValidate(String size) {
        try {
            return negativeValidate(Integer.parseInt(size));
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닙니다.");
            return readBridgeSize();
        }
    }

    //1 이상 검증
    public int negativeValidate(int size) {
        try {
            if (size <= 0) {
                throw new IllegalArgumentException("[ERROR] 1 이상의 숫자를 입력해주세요.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return rangeValidate(size);
    }
    //3에서 20사이 검증
    public int rangeValidate(int size) {
        try {
            if (!(size >= 3 && size <= 20)) {
                throw new IllegalArgumentException("[ERROR] 3에서 20사이의 숫자를 입력해주세요.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return size;
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
