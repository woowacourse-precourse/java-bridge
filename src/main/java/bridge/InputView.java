package bridge;

import validation.InputValidation;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final InputValidation inputValidation=new InputValidation();
    String user_input_bridge_size;
    /**
     * 다리의 길이를 입력받는다.
     */

    public int readBridgeSize() {
        user_input_bridge_size = readLine();
        return bridgeSizeValidation();
    }

    private int bridgeSizeValidation() {
        int bridge_size=0;
        if (inputValidation.userInputBridgeSizeValidation(user_input_bridge_size).equals("[ERROR]")) {
            readBridgeSize();
        }
        bridge_size=Integer.parseInt(user_input_bridge_size);
        return bridge_size;
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
