package bridge.domain;


import static bridge.common.message.ExceptionMessage.BRIDGE_LENGTH_INCORRECT_CHARACTER_MESSAGE;
import static bridge.common.message.ExceptionMessage.BRIDGE_LENGTH_OUT_OF_SIZE_MESSAGE;
import static bridge.common.message.ExceptionMessage.ERROR_CODE;
import static bridge.common.message.ExceptionMessage.GAME_COMMAND_INCORRECT_MESSAGE;
import static bridge.common.message.ExceptionMessage.READ_MOVING_INCORRECT_MESSAGE;

import bridge.common.message.ConsoleOut;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(ProcessHelper processHelper) {
        while (true) {
            try {
                ConsoleOut.INPUT_BRIDGE_LENGTH_MESSAGE.print();
                String bridgeSize = Console.readLine();
                bridgeSizeValidation(processHelper, bridgeSize);
                bridgeNumberValidation(bridgeSize);

                return Integer.parseInt(bridgeSize);
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(ProcessHelper processHelper) {
        while (true) {
            try {
                ConsoleOut.INPUT_MOVING_POSITION_MESSAGE.print();
                String moving = Console.readLine();
                movingValidation(processHelper, moving);
                return moving;
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(ProcessHelper processHelper) {
        while (true) {
            try {
                ConsoleOut.GAME_RESTART_Q_AND_A_MESSAGE.print();
                String gameCommand = Console.readLine();
                gameCommandValidation(processHelper, gameCommand);
                return gameCommand;
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
            }
        }
    }

    private void gameCommandValidation(ProcessHelper processHelper, String gameCommand) {
        if (!processHelper.checkCharIsROrQ(gameCommand)) {
            // throw new GameCommandException(ERROR_CODE + GAME_COMMAND_INCORRECT_MESSAGE);
            throw new IllegalArgumentException(ERROR_CODE + GAME_COMMAND_INCORRECT_MESSAGE);
        }
    }

    private void movingValidation(ProcessHelper processHelper, String moving) {
        if (!processHelper.checkCharIsUOrD(moving)) {
            // throw new ReadMovingException(ERROR_CODE + READ_MOVING_INCORRECT_MESSAGE);
            throw new IllegalArgumentException(ERROR_CODE + READ_MOVING_INCORRECT_MESSAGE);
        }
    }

    private void bridgeSizeValidation(ProcessHelper processHelper, String str) {
        if (!processHelper.checkBridgeSize(str)) {
            // throw new BridgeCorrectSizeInputException(ERROR_CODE + BRIDGE_LENGTH_INCORRECT_CHARACTER_MESSAGE);
            throw new IllegalArgumentException(
                ERROR_CODE + BRIDGE_LENGTH_INCORRECT_CHARACTER_MESSAGE);
        }
    }

    private void bridgeNumberValidation(String bridgeSize) {
        if (Integer.parseInt(bridgeSize) < 3 || Integer.parseInt(bridgeSize) > 20) {
            // throw new BridgeSizeOutOfBoundaryException(ERROR_CODE + BRIDGE_LENGTH_OUT_OF_SIZE_MESSAGE);
            throw new IllegalArgumentException(
                ERROR_CODE + BRIDGE_LENGTH_OUT_OF_SIZE_MESSAGE);
        }
    }
}
