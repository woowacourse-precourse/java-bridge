package bridge;

import java.util.List;
import java.util.ArrayList;

public class Application {
    static List<String> bridge;
    static InputView inputview;
    static OutputView outputView;
    static BridgeMaker bridgeMaker;
    static BridgeGame bridgeGame;
    static int tryCount;
    static boolean stepCorrect;

    public static void main(String[] args) {
        System.out.println(Message.GAME_START_COMMENT);
        initialize();
        getBridge();
        gameStart();
        gameResult();
    }

    private static void gameResult() {
        outputView.printResult();
    }

    private static void initialize() {
        tryCount = 0;

        inputview = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
    }

    private static void getBridge() {
        int bridgeSize = getBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private static int getBridgeSize() {
        return inputview.readBridgeSize();
    }

    public static void gameStart(){
        tryCount++;
        moveBridge();

        if(BridgeGame.playerStep.size() < bridge.size())
            CheckRetry();
    }

    private static void moveBridge(){
        stepCorrect = true;

        while(stepCorrect && BridgeGame.playerStep.size() < bridge.size()){
            stepCorrect = bridgeGame.move(inputview.readMoving());
            outputView.printMap();
        }
    }

    private static void CheckRetry(){
        String retry = inputview.readGameCommand();
        if(retry.equals(Retry.R.name()))
            bridgeGame.retry();

        return;
    }
}
