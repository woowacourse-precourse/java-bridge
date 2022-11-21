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
        try {
            return inputView.readBridgeSize();
        }
        catch (IllegalArgumentException ex){
            OutputView.printError(ex.getMessage());
            return getBridgeSize();
        }
    }

    public static void gameStart(){
        tryCount++;
        tryGame();

        if(BridgeGame.playerStep.size() < bridge.size())
            CheckRetry();
    }

    private static void tryGame(){
        stepCorrect = true;

        while(stepCorrect && BridgeGame.playerStep.size() < bridge.size()){
            moveBridge();
        }
    }

    private static void moveBridge(){
        try {
            stepCorrect = bridgeGame.move(inputView.readMoving());
            outputView.printMap();
        }
        catch (IllegalArgumentException ex){
            OutputView.printError(ex.getMessage());
            moveBridge();
        }
    }

    private static void CheckRetry(){
        if(bridgeGame.retry(inputView.readGameCommand()))
            gameStart();
    }
}
