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
        System.out.println("다리 길이를 입력해주세요.");
        String size = Console.readLine();
        sizeValidation(size);

        return Integer.parseInt(size);
    }

    /**
     * 입력 받은 다리 길이에 대한 유효성 검증
     * 다리 길이는 3~20 사이의 숫자여야 한다
     */
    public void sizeValidation(String input) {
        String sizeErrorMessage = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다";
        int result;

        //1. 입력이 숫자가 아닌 경우
        try {
            result = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(sizeErrorMessage);
        }
        //2. 입력 숫자가 3~20 사이 숫자가 아닌 경우
        if (result < 3 || result > 20) {
            throw new IllegalArgumentException(sizeErrorMessage);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("다리 길이를 입력해주세요.");
        String moving = Console.readLine();
        movingValidation(moving);

        return moving;
    }

    public void movingValidation(String moving) {
        String movingErrorMessage = "[ERROR] U(위 칸) 또는 D(아래 칸) 중 하나의 문자여야 합니다";

        if (moving.length() != 1) {
            throw new IllegalArgumentException(movingErrorMessage);
        }
        if (!(moving.charAt(0) == 'U' || moving.charAt(0) == 'D')) {
            throw new IllegalArgumentException(movingErrorMessage);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
