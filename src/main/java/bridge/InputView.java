package bridge;

import camp.nextstep.edu.missionutils.Console;


import static bridge.exceptions.InputException.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() throws IllegalArgumentException {
        String bridgeSizeInput = Console.readLine();
        bridgeSizeNumberCheck(bridgeSizeInput);
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        bridgeSizeRangeCheck(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() throws IllegalArgumentException {
        String movingInput = Console.readLine();
        movingInputErrorCheck(movingInput);
        return movingInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        /**
         "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
         */
        String gameCommandInput = Console.readLine();
        gameCommandInputErrorCheck(gameCommandInput);
        return gameCommandInput;
    }
}
