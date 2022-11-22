package bridge.View;

import bridge.Utils.Validator.GameCommandValidator;
import bridge.Utils.Validator.MovementValidator;
import camp.nextstep.edu.missionutils.Console;

import bridge.Utils.Validator.BridgeLengthValidator;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        bridgeSize = BridgeLengthValidator.validateBridgeInput(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(INPUT_MOVE);
        String movement = Console.readLine();
        return MovementValidator.movementValid(movement);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(INPUT_RETRY);
        String gameCommand = Console.readLine();
        gameCommand = GameCommandValidator.commandValid(gameCommand);
        return gameCommand;
    }

}
