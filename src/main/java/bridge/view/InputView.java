package bridge.view;

import bridge.model.ExceptionMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVING_COMMAND_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final List<String> movingCommands = List.of("U", "D");
    private static final List<String> gameCommands = List.of("R", "Q");

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
        String bridgeSizeStr = Console.readLine();
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(bridgeSizeStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER.getMessage());
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVING_COMMAND_MESSAGE);
        String movingCommand = Console.readLine();
        if(!movingCommands.contains(movingCommand)) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_MOVING_COMMAND.getMessage());
        }
        return movingCommand;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(GAME_COMMAND_MESSAGE);

        String gameCommand = Console.readLine();
        if(!gameCommands.contains(gameCommand)) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_GAME_COMMAND.getMessage());
        }
        return gameCommand;
    }
}
