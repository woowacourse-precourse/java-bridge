package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int MAX_BRIDGE_SIZE = 20;
    private static final int MIN_BRIDGE_SIZE = 3;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();

        validateisDigit(bridgeSize);
        validateOverSize(Integer.parseInt(bridgeSize));

        return Integer.parseInt(bridgeSize);
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

    public void validateOverSize(int bridgeSize){
        if(bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public void validateisDigit(String bridgeSize){
        for(int i = 0; i< bridgeSize.length(); i++) {
            if (!Character.isDigit(bridgeSize.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자만 입력 가능합니다.");
            }
        }
    }
}
