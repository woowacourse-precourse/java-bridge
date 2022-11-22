package bridge.ui;

import bridge.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ENTER_BRIDGE_SIZE_MSG = "다리의 길이를 입력해주세요.";
    private static final String ENTER_MOVING_DIRECTION_MSG = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String ENTER_GAME_COMMAND_MSG = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int readBridgeSize() {
        System.out.println(ENTER_BRIDGE_SIZE_MSG);
        String bridgeSizeInput =Console.readLine();
        InputValidator.checkBridgeSizeType(bridgeSizeInput);

        int size = Integer.valueOf(bridgeSizeInput);
        InputValidator.checkBridgeSizeRange(size);

        return size;
    }

    public String readMoving() {
        System.out.println(ENTER_MOVING_DIRECTION_MSG);
        String direction =Console.readLine();
        InputValidator.checkMovingDirection(direction);
        return direction;
    }

    public String readGameCommand() {
        System.out.println(ENTER_GAME_COMMAND_MSG);
        String gameCommand = Console.readLine();
        InputValidator.checkGameCommand(gameCommand);
        return gameCommand;
    }
}
