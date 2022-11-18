package bridge;

import bridge.constant.message.InputErrorMessage;
import bridge.utils.Validator;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return 0;
    }

    private void checkNumericString(String command){
        if(!Validator.isNumericString(command)){
            throw new IllegalArgumentException(InputErrorMessage.NO_NUMERIC_STRING.getMessage());
        }
    }

    private void checkRangeOfBridgeSize(int bridgeSize){
        // TODO: 주어진 다리 크기가 유효한지 확인
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    private void checkValidMoving(String command){
        // TODO: 사용자의 입력값이 칸 이동 명령어인지 확인
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void checkValidGameCommand(String command){
        // TODO: 사용자의 입력값이 게임 관련 명령어인지 확인
    }
}
