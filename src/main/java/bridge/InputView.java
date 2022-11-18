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
        String bridgeSizeString = Console.readLine();
        int bridgeSize = checkBridgeSizeString(bridgeSizeString);
        return bridgeSize;
    }

    private int checkBridgeSizeString(String bridgeSizeString) {
        int bridgeSize = stringToInt(bridgeSizeString);
        if(bridgeSize < 3 || bridgeSize > 20)
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 숫자를 입력해주세요.");
        return bridgeSize;
    }

    private int stringToInt(String bridgeSizeString) {
        try {
            int result =  Integer.parseInt(bridgeSizeString);
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
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
