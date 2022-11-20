package bridge;

import java.util.List;
import java.util.ArrayList;

public class Application {
    static int bridgeSize;
    static List<String> bridge;
    static List<String> playerMove;
    static InputView inputview;
    static OutputView outputView;
    static BridgeMaker bridgeMaker;
    static BridgeGame bridgeGame;
    static boolean stepSuccess;
    static int tryCount;

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        initialize();
        getBridge();
        gameStart();
        gameResult();
    }

    private static void gameResult() {
        outputView.printResult();
    }

    private static void initialize() {
        playerMove = new ArrayList<>();
        stepSuccess = true;
        tryCount = 0;

        inputview = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
    }

    private static void getBridge() {
        getBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private static void getBridgeSize() {
        bridgeSize = inputview.readBridgeSize();
    }

    public static void gameStart() {
        tryCount++;
        
        while(stepSuccess){
            if(checkSuccess())
                return;
            bridgeGame.move();
            stepSuccess = CheckStep();
        }

        CheckRetry();
    }

    private static boolean checkSuccess() {
        if(bridgeSize == playerMove.size() && stepSuccess)
            return true;

        return false;
    }

    private static boolean CheckStep() {
        int index = playerMove.size() - 1;
        String lastMove = playerMove.get(index);
        if(bridge.get(index).equals(lastMove))
            return true;
        return false;
    }

    private static void CheckRetry(){
        String retry = inputview.readGameCommand();
        if(retry == "R")
            bridgeGame.retry();

        return;
    }
}
