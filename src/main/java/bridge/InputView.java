package bridge;

import bridge.constant.ErrorMessage;
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
        int result = validateSize(Console.readLine());
        if (result < 3 || result > 20) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_SIZE);
        }
        return result;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String result = validateMoving(Console.readLine());
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String result = validateCommend(Console.readLine());
        return result;
    }

    private String validateCommend(String commend) {
        if (!(commend.equals("R") || commend.equals("Q"))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_COMMEND);
        }

        return commend;
    }

    private int validateSize(String size) {
        int result;
        for (int i = 0; i < size.length(); i++)
        {
            if (!(size.charAt(i) <= '9' && size.charAt(i) >= '0'))
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER);
        }

        result = Integer.parseInt(size);
        return result;
    }

    private String validateMoving(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_DIRECTION);
        }

        return moving;
    }
}
