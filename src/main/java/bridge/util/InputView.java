package bridge.util;

import validation.InputValidation;
import validation.RetryValidation;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final InputValidation inputValidation=new InputValidation();
    private static final RetryValidation retryValidation=new RetryValidation();

    private final String ERROR_MESSAGE="[ERROR]";

    String user_input_bridge_size;

    String user_input_bridge_move;

    String user_input_retry_condition;
    /**
     * 다리의 길이를 입력받는다.
     */

    public int readBridgeSize() {
        user_input_bridge_size = readLine();
        return bridgeSizeValidation();
    }

    private int bridgeSizeValidation() {
        int bridge_size=0;
        if (inputValidation.userInputBridgeSizeValidation(user_input_bridge_size).equals(ERROR_MESSAGE)) {
            readBridgeSize();
        }
        bridge_size=Integer.parseInt(user_input_bridge_size);
        return bridge_size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        user_input_bridge_move = readLine();
        return bridgeMoveValidation();
    }
    private String bridgeMoveValidation(){
        if (inputValidation.userInputBridgeMoveValidation(user_input_bridge_move).equals(ERROR_MESSAGE)){
            readMoving();
        }
        return user_input_bridge_move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        user_input_retry_condition = readLine();
        return retryConditionValidation();
    }

    private String retryConditionValidation(){
        if(retryValidation.userInputRetryConditionValidation(user_input_retry_condition).equals(ERROR_MESSAGE)){
            readGameCommand();
        }

        return user_input_retry_condition;
    }
}
