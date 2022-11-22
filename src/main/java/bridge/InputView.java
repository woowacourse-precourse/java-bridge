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
        while(true) {
            System.out.println("다리의 길이를 입력해주세요.");
            String inputBridgeLength = Console.readLine();
            // 만약 올바른 값이라면 그 값 리턴

            // 올바르지 않은 값이라면 에러 Exception 발생 후 에러 메시지 출력 후 반복
            throwExceptionIfNotValidBrideSize(inputBridgeLength);
            return 0;
        }
    }

    /**
     * 입력 받은 다리 길이가 정수인지 맞는지 판별한다.
     */
    public boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 입력 받은 다리 길이가 3~20 사이의 숫자인지 판별한다.
     */
    public boolean isBetween3To20(int num) {
        if (num >= 3 && num <= 20) {
            return true;
        }
        return false;
    }

    /**
     * 입력 받은 다리 길이가 올바르지 않을 때 예외처리 후 에러 메시지를 발생한다.
     */
    private void throwExceptionIfNotValidBrideSize(String s) throws IllegalArgumentException {
        if (!isNumber(s)) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
        }
        if (isNumber(s)) {
            int num = Integer.parseInt(s);
            if (!isBetween3To20(num)) {
                System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
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
