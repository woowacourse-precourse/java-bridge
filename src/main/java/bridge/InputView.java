package bridge;

import bridge.util.Message;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final Integer MIN_BRIDGE_SIZE = 3;
    private static final Integer MAX_BRIDGE_SIZE = 20;
    private static final String UPPER_MOVE = "U";
    private static final String LOWER_MOVE = "D";
    private static final String GAME_RESTART_COMMAND = "R";
    private static final String GAME_QUIT_COMMAND = "Q";
    private String readLine()
    {
        return Console.readLine();
    }
    private void validateBridgeSize(int bridgeSize) {
        if(MIN_BRIDGE_SIZE <= bridgeSize && bridgeSize <= MAX_BRIDGE_SIZE) return;

        throw new IllegalArgumentException(Message.ILLEGAL_BRIDGE_SIZE_ERROR_MESSAGE);
    }
    public int readBridgeSize() {
        try {
            int bridgeSize = Integer.parseInt(readLine());
            validateBridgeSize(bridgeSize);
            return bridgeSize;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ILLEGAL_BRIDGE_SIZE_ERROR_MESSAGE);
        }
    }
    private void validateUserInputForMove(String userInputForMove)
    {
        if(userInputForMove.equals(LOWER_MOVE) || userInputForMove.equals(UPPER_MOVE)) return;

        throw new IllegalArgumentException(Message.ILLEGAL_MOVE_REQUEST_ERROR_MESSAGE);
    }

    public String readMoving() {
        String userInputForMove = readLine();
        validateUserInputForMove(userInputForMove);
        return userInputForMove;
    }
    private void validateGameCommand(String gameCommand)
    {
        if(gameCommand.equals(GAME_RESTART_COMMAND) || gameCommand.equals(GAME_QUIT_COMMAND)) return;

        throw new IllegalArgumentException(Message.ILLEGAL_GAME_COMMAND_ERROR_MESSAGE);
    }

    public String readGameCommand() {
        String gameCommand = readLine();
        validateGameCommand(gameCommand);
        return gameCommand;
    }

}
