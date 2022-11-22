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
        try {
            Bridge bridge = makeNewBridge();
            Crossing crossing = gameEngine.createCrossing();
            crossBridge(crossing, bridge);
            view.printGameResult(gameEngine.getTryCount(), crossing);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void crossBridge(Crossing crossing, Bridge bridge) {
        while (!crossing.isFinish(bridge.getBridgeSize())) {
            inputAndCross(crossing, bridge);
            if (crossing.isPass()) {
                continue;
            }
            if (!new RetryOrQuit(view.requestRetryOrQuit()).isRetry()) {
                break;
            }
            gameEngine.retry(crossing);
        }
    }

    private void inputAndCross(Crossing crossing, Bridge bridge) {
        UpOrDown upOrDown = new UpOrDown(view.requestDirection());
        cross(crossing, bridge, upOrDown);
    }

    private void cross(Crossing crossing, Bridge bridge, UpOrDown upOrDown) {
        gameEngine.cross(crossing, bridge, upOrDown);
        view.printCurrentMap(crossing);
    }

    private Bridge makeNewBridge() {
        int size = view.requestNewBridgeSize();

        return gameEngine.makeBridge(size);
    }
}
