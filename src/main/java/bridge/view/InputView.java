package bridge.view;

import static bridge.constants.ErrorConstant.RETRY_ERROR;
import static bridge.constants.ErrorConstant.SIZE_EXCEPTION;
import static bridge.constants.ErrorConstant.UPDOWN_ERROR;
import static bridge.validator.Validate.*;

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
            validateBridgeSizeNumber(bridgeSizeInput);
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
        String userMove = Console.readLine().toUpperCase();
        try{
            validateCheckMove(userMove);
        }catch (IllegalArgumentException e){
            UPDOWN_ERROR.printException();
            return readMoving();
        }
        return userMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine().toUpperCase();
        try{
            validateCheckRetry(command);
        }catch (IllegalArgumentException e){
            RETRY_ERROR.printException();
            return readGameCommand();
        }
        return command;
    }

}
