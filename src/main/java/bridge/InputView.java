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
        String readLine = Console.readLine();
        try {
            return Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }



    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public RetryResponse readGameCommand() {
        String readLine = Console.readLine();
        return RetryResponse.of(readLine);
    }
}
