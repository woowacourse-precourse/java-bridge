package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;
    private int bridgeSize, attepmtCnt;
    private boolean isSucess;
    private List<String> playerBridgeMap;
    private List<String> RandomBridgeMap;

    public BridgeGameController() {
        bridgeGame = new BridgeGame();
        inputView = new InputView(new CheckNum());
        playerBridgeMap = new ArrayList<>();
        RandomBridgeMap = new ArrayList<>();
        outputView = new OutputView();
    }

    public void start() {
        attepmtCnt = 0;
        bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        RandomBridgeMap = bridgeMaker.makeBridge(bridgeSize);
//        BridgeAlgorithm();
    }
}
