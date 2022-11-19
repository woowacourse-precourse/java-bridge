package bridge.View;

import Utils.Validator.GameCommandValidator;
import Utils.Validator.MovementValidator;
import camp.nextstep.edu.missionutils.Console;

import Utils.Validator.BridgeLengthValidator;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {


    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        String bridgeSize = Console.readLine();
        bridgeSize = BridgeLengthValidator.validateBridgeInput(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String movement = Console.readLine();
        return MovementValidator.movementValid(movement);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String gameCommand = Console.readLine();
        gameCommand = GameCommandValidator.commandValid(gameCommand);
        return gameCommand;
    }

}
