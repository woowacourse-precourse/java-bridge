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
        int bridgeSize;

        try {
            bridgeSize = Integer.parseInt(Console.readLine());
            validateBridgeSize(bridgeSize);
        }catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            bridgeSize = Integer.parseInt(Console.readLine());
            validateBridgeSize(bridgeSize);
        }

        return bridgeSize;
    }

    /**
     * 입력받은 다리의 길이를 검증한다.
     */
    public void validateBridgeSize(int bridgeSize) {
        if(bridgeSize<3 || bridgeSize>20) {
            throw new IllegalArgumentException();
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
