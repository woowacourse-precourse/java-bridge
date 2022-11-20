package bridge.view;

import bridge.controller.GameController;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        boolean flag = true;
        String inputBridgeSize = "";
        while (flag) {
            inputBridgeSize = Console.readLine();
            if(!GameController.isValidBridgeNumber(inputBridgeSize) && !GameController.isValidBridgeRange(inputBridgeSize)) {
                flag = false;
            }
        }
        return Integer.parseInt(inputBridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        boolean flag = true;
        String inputBridgeAction = "";
        while (flag) {
            inputBridgeAction = Console.readLine();
            if(!GameController.isValidBridgeAction(inputBridgeAction)) {
                flag = false;
            }
        }
        return inputBridgeAction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        boolean flag = true;
        String inputBridgeRestart = "";
        while (flag) {
            inputBridgeRestart = Console.readLine();
            if(!GameController.isValidBridgeRestart(inputBridgeRestart)) {
                flag = false;
            }
        }
        return inputBridgeRestart;
    }
}
