package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 *
 */
public class InputView {

    private final String errorMsg = "[ERROR]";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {

        String bridgeSize = Console.readLine();
        int result;

        try {
            result =  Integer.parseInt(bridgeSize);

        }catch (NumberFormatException e){
            throw new IllegalArgumentException(errorMsg + " 숫자만 입력 가능");
        }

        return result;
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
