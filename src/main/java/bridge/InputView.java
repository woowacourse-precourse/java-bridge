package bridge;

import bridge.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING_POSITION_MESSAGE = "이동할 칸을 선택해주세요. (위: %s, 아래: %s)%n";
    private static final String INPUT_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)%n";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
        String input = getInput();
        InputValidator.validateInteger(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.printf(
                INPUT_MOVING_POSITION_MESSAGE,
                BridgeMaker.getUpBridgeLetter(),
                BridgeMaker.getDownBridgeLetter()
        );
        String input = getInput();
        InputValidator.validateMoving(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.printf(INPUT_GAME_COMMAND_MESSAGE, BridgeGame.getRetryCommand(), BridgeGame.getQuitCommand());
        String input = getInput();
        InputValidator.validateGameCommand(input);
        return input;
    }

    private static String getInput() {
        String input = Console.readLine().trim();
        InputValidator.validateNotEmpty(input);
        return input;
    }

}
