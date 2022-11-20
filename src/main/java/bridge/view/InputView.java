package bridge.view;

import bridge.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static String input(){
        return Console.readLine();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        return Validator.validateBridgeLength(input());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        return Validator.validateMove(input());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        return Validator.validateRestartOrQuit(input());
    }

}
