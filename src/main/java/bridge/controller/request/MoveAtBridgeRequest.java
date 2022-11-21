package bridge.controller.request;

import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class MoveAtBridgeRequest {

    private final MoveByBlockRequest moveByBlockRequest;
    private final InputView inputView;
    private final Bridge bridge;

    public MoveAtBridgeRequest(InputView inputView, OutputView outputView, Bridge bridge) {
        this.moveByBlockRequest = new MoveByBlockRequest(inputView, outputView, bridge);
        this.inputView = inputView;
        this.bridge = bridge;
    }

    public MoveByBlockRequest getMoveByBlockRequest() {
        return moveByBlockRequest;
    }

    public String getGameCommand() {
        return inputView.readGameCommand();
    }

    public Bridge getBridge() {
        return bridge;
    }
}
