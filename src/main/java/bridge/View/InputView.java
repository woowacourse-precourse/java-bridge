package bridge.View;

import bridge.Constants;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Constants.BRIDGE_SIZE_REQUEST_MESSAGE);

        return validateBridgeSize(Console.readLine());
    }

    private int validateBridgeSize(String input){
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Constants.MOVING_REQUEST_MESSAGE);

        return validateMoving(Console.readLine());
    }

    private String validateMoving(String input){
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Constants.RESTART_REQUEST_MESSAGE);

        return validateGameCommand(Console.readLine());
    }

    private String validateGameCommand(String input){
        return input;
    }
}
