package bridge;

import bridge.utils.ValidateUtils;
import bridge.utils.constants.BridgeMove;
import bridge.utils.constants.BridgeSize;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        try{
            String input = getInput(BridgeSize.READ_BRIDGE_SIZE_MESSAGE);
            ValidateUtils.isCorrectRangeNumbers(input);
            return Integer.parseInt(input);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try{
            String input = getInput(BridgeMove.READ_BRIDGE_MOVE_MESSAGE);
            ValidateUtils.isCorrectMoveValue(input);
            return input;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private String getInput(String msg){
        System.out.println(msg);
        return Console.readLine();
    }


}
