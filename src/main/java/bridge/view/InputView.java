package bridge.view;

import bridge.util.BridgeGameInfo;
import bridge.util.Message;
import camp.nextstep.edu.missionutils.Console;

public class InputView {


    private String readLine()
    {
        return Console.readLine();
    }
    private void validateBridgeSize(int bridgeSize) {
        if(BridgeGameInfo.MIN_BRIDGE_SIZE <= bridgeSize && bridgeSize <= BridgeGameInfo.MAX_BRIDGE_SIZE) return;

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
        if(userInputForMove.equals(BridgeGameInfo.LOWER_MOVE) || userInputForMove.equals(BridgeGameInfo.UPPER_MOVE)) return;

        throw new IllegalArgumentException(Message.ILLEGAL_MOVE_REQUEST_ERROR_MESSAGE);
    }

    public String readMoving() {
        String userInputForMove = readLine();
        validateUserInputForMove(userInputForMove);
        return userInputForMove;
    }
    private void validateGameCommand(String gameCommand)
    {
        if(gameCommand.equals(BridgeGameInfo.GAME_RESTART_COMMAND) || gameCommand.equals(BridgeGameInfo.GAME_QUIT_COMMAND)) return;

        throw new IllegalArgumentException(Message.ILLEGAL_GAME_COMMAND_ERROR_MESSAGE);
    }

    public String readGameCommand() {
        String gameCommand = readLine();
        validateGameCommand(gameCommand);
        return gameCommand;
    }

}
