package bridge.view;

import static bridge.util.Constant.*;

import bridge.validation.Validation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_INPUT_MSG);
        String bridgeLengthInput = Console.readLine();
        Validation.checkBridgeLengthConsistOfNum(bridgeLengthInput);
        Validation.checkBridgeLengthRange3To20(bridgeLengthInput);
        return Integer.parseInt(bridgeLengthInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_INPUT_MSG);
        String moveCommandInput = Console.readLine();
        Validation.checkMoveCommand(moveCommandInput);
        return moveCommandInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(GAME_RESTART_MSG);
        String gameCommandInput = Console.readLine();
        Validation.checkGameCommand(gameCommandInput);
        return gameCommandInput;
    }
}
