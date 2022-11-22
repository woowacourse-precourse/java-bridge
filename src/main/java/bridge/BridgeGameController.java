package bridge;

import bridge.engine.BridgeGameEngine;
import bridge.model.Bridge;
import bridge.model.Crossing;
import bridge.model.RetryOrQuit;
import bridge.model.UpOrDown;
import bridge.view.BridgeGameView;

public class BridgeGameController implements Runnable {

    private final BridgeGameEngine gameEngine;
    private final BridgeGameView view;

    public BridgeGameController(BridgeGameEngine gameEngine, BridgeGameView view) {
        this.gameEngine = gameEngine;
        this.view = view;
    }

    @Override
    public void run() {
        Bridge bridge = makeNewBridge();

        Crossing crossing = gameEngine.createCrossing();

        crossBridge(crossing, bridge);
        view.printGameResult(gameEngine.getTryCount(), crossing);
    }

    private void crossBridge(Crossing crossing, Bridge bridge) {
        while (!crossing.isFinish(bridge.getBridgeSize())) {
            UpOrDown upOrDown = new UpOrDown(view.requestDirection());
            gameEngine.cross(crossing, bridge, upOrDown);
            view.printCurrentMap(crossing);

            if (crossing.isPass()) {
                continue;
            }

            RetryOrQuit retryOrQuit = new RetryOrQuit(view.requestRetryOrQuit());

            if (!retryOrQuit.isRetry()) {
                break;
            }

            gameEngine.retry(crossing);
        }
    }

    private Bridge makeNewBridge() {
        int size = view.requestNewBridgeSize();

        return gameEngine.makeBridge(size);
    }
}
