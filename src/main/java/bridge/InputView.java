package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    int bridgeSize_in = 0;
    String upAndDown_in = "";
    String retryAndQuit_in = "";

    public void readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSizeLetter_in = Console.readLine();
        bridgeSizeNotLetterValidation(bridgeSizeLetter_in);
        bridgeSizeRangeValidation(bridgeSize_in);
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return 0;
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
