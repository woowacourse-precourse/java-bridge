package bridge;

import java.util.List;

public class Application {
    static List<String> bridge;
    static InputView inputView;
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

        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
    }

    private static void getBridge() {
        int bridgeSize = getBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private static int getBridgeSize() {
        return inputView.readBridgeSize();
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
            stepCorrect = bridgeGame.move(inputView.readMoving());
            outputView.printMap();
        }
    }

    private static void CheckRetry(){
        if(bridgeGame.retry(inputView.readGameCommand()))
            gameStart();
    }
}
