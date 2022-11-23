package bridge.model;

import bridge.controller.GameController;

import static bridge.util.Constant.*;

public class BridgeGame {

    public String move(String bridgeShape, String nextMove) {
        if(bridgeShape.equals(nextMove))
            return PASS_SIGN;
        return FAIL_SIGN;
    }

    public void retry(String retryCommand) {
        if(retryCommand.equals(RESET_COMMAND)) GameController.resetGame();
        if(retryCommand.equals(QUIT_COMMAND)) GameController.quitGame();
    }

}
