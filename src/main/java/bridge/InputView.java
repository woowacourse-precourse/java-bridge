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
        String bridgeSize = Console.readLine();
        int mappedBridgeSize = 0;
        try {
            mappedBridgeSize = Integer.parseInt(bridgeSize);
        } catch (Exception e) {
            throw new IllegalArgumentException("다리 길이는 숫자여야 합니다.");
        }
        if (!(3 <= mappedBridgeSize && mappedBridgeSize <= 20))
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        return mappedBridgeSize;
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
