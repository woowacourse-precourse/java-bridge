package bridge.controller.request;

import bridge.domain.bridge.Bridge;
import bridge.handler.InputHandler;
import bridge.view.OutputView;

public class MoveAtBridgeRequest {

    private final MoveByBlockRequest moveByBlockRequest;
    private final InputHandler inputHandler;
    private final Bridge bridge;

    public MoveAtBridgeRequest(InputHandler inputHandler, OutputView outputView, Bridge bridge) {
        this.moveByBlockRequest = new MoveByBlockRequest(inputHandler, outputView, bridge);
        this.inputHandler = inputHandler;
        this.bridge = bridge;
    }

    public MoveByBlockRequest getMoveByBlockRequest() {
        return moveByBlockRequest;
    }

    public String getGameCommand() {
        return inputHandler.getGameCommand();
    }

    public Bridge getBridge() {
        return bridge;
    }
}
