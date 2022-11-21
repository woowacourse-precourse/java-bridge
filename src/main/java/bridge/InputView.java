package bridge;

import bridge.utils.ValidateUtils;
import bridge.utils.constants.BridgeSize;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        try{
            System.out.println(BridgeSize.READ_BRIDGE_SIZE_MESSAGE);
            String input = Console.readLine();
            ValidateUtils.isCorrectRangeNumbers(input);
            return Integer.parseInt(input);
        }catch (IllegalArgumentException e){
            System.out.println(BridgeSize.ERROR_BRIDGE_SIZE_MESSAGE);
            return readBridgeSize();
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
