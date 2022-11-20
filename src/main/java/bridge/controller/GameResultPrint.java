package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeShape;
import bridge.model.GameControll;
import bridge.view.OutputView;

public class GameResultPrint {

    private static final OutputView outputView = new OutputView();
    private static final BridgeShape bridgeShape = new BridgeShape();
    private static final GameControll gameControll = new GameControll();

    public static void showNowBridgeShape() {
        outputView.printBridge(bridgeShape.getUpBridge(), bridgeShape.getDownBridge());
    }

    public static void printGameResult() {
        outputView.printFinalGame();
        showNowBridgeShape();
        outputView.printResult(gameControll.getCnt());
    }

}

