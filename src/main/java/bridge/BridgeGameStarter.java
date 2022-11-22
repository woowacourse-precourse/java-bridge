package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameStarter {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker = new BridgeMaker();
    BridgeGame bridgeGame = new BridgeGame();

    private int bridgeLength;
    private List<String> bridgeInfo = new ArrayList<>();
    private String completeOrNot = "";

    public void BridgeGamePlay(){
        int gameCount = 1;
        OutputView.printGameHasStarted();
        this.bridgeLength = InputView.readBridgeSize();
        this.bridgeInfo = BridgeMaker.makeBridge(bridgeLength);
        this.completeOrNot = BridgeGame.move(bridgeInfo, bridgeLength, gameCount);
        OutputView.printResult(completeOrNot, bridgeInfo, gameCount ,bridgeLength);
    }
}
