package bridge;

import java.util.List;

public class Game_Control {
    InputView InputView = new InputView();
    OutputView outputview = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();
    BridgeRandomNumberGenerator BridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(BridgeNumberGenerator);
    private String check = "R";
    static int count = 1;
    int bridgeSize = InputView.readBridgeSize();
    List<String> makeBridge = bridgeMaker.makeBridge(bridgeSize);

    public void start() {
        while (check.contentEquals("R")) {
            System.out.println(makeBridge);
            outputview.printMap(bridgeSize, makeBridge);
            outputview.printResult();
            outputview.printSuccess();
            count=bridgeGame.retry(count);
            check = outputview.printFail(check);
            outputview.restart();
        }
    }
}
