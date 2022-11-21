package bridge.view;

import static bridge.constants.ErrorConstant.RETRY_ERROR;
import static bridge.constants.ErrorConstant.SIZE_EXCEPTION;
import static bridge.validator.Validate.*;

import bridge.constants.ErrorConstant;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

//    private OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSizeInput = Console.readLine();
        try {
            vaildateBridgeSize(bridgeSizeInput);
        } catch (IllegalArgumentException e) {
            SIZE_EXCEPTION.printException();
            return readBridgeSize();
        }
        return Integer.parseInt(bridgeSizeInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String userMove;
        userMove = Console.readLine().toUpperCase();
        return userMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine().toUpperCase();
        try{
            vaildateCheckRetry(command);
        }catch (IllegalArgumentException e){
            RETRY_ERROR.printException();
            return readGameCommand();
        }
        return command;
    }

}
