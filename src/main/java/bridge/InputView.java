package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.io.PrintStream;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize = 0;
        while (true) {
            try {
                bridgeSize = Integer.parseInt(readValue());
                if(isBridgeNumber(bridgeSize)){
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 3 이상 20 이하의 숫자를 입력해주세요.");
            }
        }
        return bridgeSize;
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

    public String readValue() {
        String value = Console.readLine();
        return value;
    }

    public boolean isBridgeNumber(int bridgeSize){
        if(bridgeSize >= 3 && bridgeSize <= 20)
            return true;
        System.out.println("[ERROR] 3 이상 20 이하의 숫자를 입력해주세요.");
        return false;
    }
}
