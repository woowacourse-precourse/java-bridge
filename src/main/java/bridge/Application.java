package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();

    private static List<String> bridge;
    private static int bridgeSize;
    private static List<String> upBridgeResult;
    private static List<String> downBridgeResult;
    private static String gameStatus;
    private static int location;
    private static int cnt;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        outputView.printGameStart();
        startMakingBridge();
        cnt = 0;
        location = 0;
        do{
            cnt ++;
            upBridgeResult = new ArrayList<>();
            downBridgeResult = new ArrayList<>();
            gameStatus = "성공";
            //playGame();
        } while(//retry);
        outputView.printResult(upBridgeResult, downBridgeResult, gameStatus, cnt);
    }

    public static void startMakingBridge() {
        try{
            outputView.printBridgeSize();
            bridgeSize = inputView.readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            bridge = bridgeMaker.makeBridge(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            startMakingBridge();
        }
    }
}