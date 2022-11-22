package bridge;

import bridge.valid.InputBridgeGameValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String BRIDGE_SIZE_TEXT = "다리의 길이를 입력해주세요.";
    private static final String MOVE_COMMAND_TEXT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_COMMAND_TEXT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static InputBridgeGameValidator inputBridgeGameValidator = new InputBridgeGameValidator();


    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_TEXT);
        String bridgeSize = Console.readLine();
        inputBridgeGameValidator.validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(MOVE_COMMAND_TEXT);
        String moveCommand = Console.readLine();
        inputBridgeGameValidator.isMoveCommand(moveCommand);
        return moveCommand;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(GAME_COMMAND_TEXT);
        String gameCommand = Console.readLine();
        inputBridgeGameValidator.isGameCommand(gameCommand);
        return gameCommand;
    }
}
