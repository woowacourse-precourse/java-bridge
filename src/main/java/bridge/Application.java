package bridge;

import java.util.List;
import java.util.ArrayList;

public class Application {
    static int bridgeSize;
    static List<String> bridge;
    static List<String> playerMove;
    static InputView inputview = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    static BridgeGame bridgeGame = new BridgeGame();
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
