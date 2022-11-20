package bridge;

import static bridge.Application.movingInput;

public class StartGame {

    public static boolean startGame() {
        OutputView.printSelect();
        movingInput = InputView.readMoving();
        BridgeGame.move();
        OutputView.printMap();
        if (BridgeGame.isWrong()) {
            if (wantRetry()) {
                BridgeGame.retry();
                return true;
            }
            //게임 종료
            return false;
        }
        return true;
    }

    public static void init() {
        OutputView.printStart();
        selectBridgeSize();
        createBridge();
    }

    public static void selectBridgeSize() {
        OutputView.printRequestSize();
        Application.size = InputView.readBridgeSize();
    }

    public static void createBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Application.bridge = bridgeMaker.makeBridge(Application.size);
    }

    public static boolean wantRetry() {
        OutputView.printRetry();
        String retryOrNot = InputView.readGameCommand();
        if (retryOrNot.equals("R"))
            return true;
        return false;
    }
}
