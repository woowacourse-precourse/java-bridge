package bridge;

import camp.nextstep.edu.missionutils.Console;

import bridge.Bridge.ValidBridgeInput;
import bridge.User.ValidUserInput;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        String bridgeSizeInput = Console.readLine();

        ValidBridgeInput.checkBridgeSizeNumeric(bridgeSizeInput);
        ValidBridgeInput.checkBridgeSizeValid(bridgeSizeInput);

        return Integer.parseInt(bridgeSizeInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String userMovingInput = Console.readLine();

        ValidUserInput.checkInputUpAndDown(userMovingInput);

        return userMovingInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String userCommandInput = Console.readLine();

        ValidUserInput.commandIsRorQ(userCommandInput);

        return userCommandInput;
    }
}
