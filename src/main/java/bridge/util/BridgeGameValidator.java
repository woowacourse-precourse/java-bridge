package bridge.util;

public class BridgeGameValidator {
    public void validateBridgeSize(int bridgeSize) {
        if(BridgeGameInfo.MIN_BRIDGE_SIZE <= bridgeSize && bridgeSize <= BridgeGameInfo.MAX_BRIDGE_SIZE) return;

        throw new IllegalArgumentException(Message.ILLEGAL_BRIDGE_SIZE_ERROR_MESSAGE);
    }

    public void validateUserInputForMove(String userInputForMove)
    {
        if(userInputForMove.equals(BridgeGameInfo.LOWER_MOVE) || userInputForMove.equals(BridgeGameInfo.UPPER_MOVE)) return;

        throw new IllegalArgumentException(Message.ILLEGAL_MOVE_REQUEST_ERROR_MESSAGE);
    }

    public void validateGameCommand(String gameCommand)
    {
        if(gameCommand.equals(BridgeGameInfo.GAME_RESTART_COMMAND) || gameCommand.equals(BridgeGameInfo.GAME_QUIT_COMMAND)) return;

        throw new IllegalArgumentException(Message.ILLEGAL_GAME_COMMAND_ERROR_MESSAGE);
    }
}
