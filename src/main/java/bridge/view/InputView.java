package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static final String MOVE_UP = "U";
    public static final String MOVE_DOWN = "D";
    public static final String RETRY_YES = "R";
    public static final String RETRY_NO = "Q";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSizeString = Console.readLine();
        validInteger(bridgeSizeString);
        return Integer.parseInt(bridgeSizeString);
    }

    public void validInteger(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();
        validMoving(moving);
        return moving;
    }

    public void validMoving(String moving) {
        if (!(moving.equals(MOVE_DOWN) || moving.equals(MOVE_UP))) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readRetry() {
        String retry = Console.readLine();
        validRetry(retry);
        return retry;
    }

    public void validRetry(String retry) {
        if (!(retry.equals(RETRY_YES) || retry.equals(RETRY_NO))) {
            throw new IllegalArgumentException();
        }
    }
}
