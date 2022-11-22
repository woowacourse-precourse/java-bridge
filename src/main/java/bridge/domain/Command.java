package bridge.domain;

import static bridge.view.SystemMessage.*;

public class Command {

    private static String command;

    public Command (String command){
        validateCommand(command);
        this.command = command;
    }

    private static void validateCommand(String command){
        if (!command.equals("R") && !command.equals("Q")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + RETRY_OR_GAME_OVER_CAMMAND_ERROR_MESSAGE);
        }
    }

    public boolean doRetryOrOver(BridgeGame bridgeGame){
        if (this.command.equals("R")) {
            bridgeGame.retry();
            return true;
        }
        if (this.command.equals("Q")) {
            bridgeGame.exit();
            return false;
        }
        return false;
    }
}