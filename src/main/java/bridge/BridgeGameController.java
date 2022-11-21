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
        BridgeAlgorithm();
    }

    private void constructBridgeAlgorithm() {
        String playerStep;
        isSucess = true;
        attepmtCnt += 1;
        int _idx;
        for (_idx = 0; _idx < bridgeSize; _idx++) {
            playerStep = inputView.readMoving();
            bridgeGame.move(playerBridgeMap, RandomBridgeMap, _idx, playerStep);
            outputView.constructMap(playerBridgeMap);
            if (bridgeGame.checkSame(RandomBridgeMap, _idx, playerStep)) {
                break;
            }
        }
        if (_idx != bridgeSize) {
            isSucess = false;
            showRestart();
        }
    }

    public void BridgeAlgorithm() {
        constructBridgeAlgorithm();
        showResult();
    }

    public void showRestart() {
        String restartInput = inputView.readGameCommand();
        if (bridgeGame.retry(restartInput)) {
            playerBridgeMap = new ArrayList<String>();
            constructBridgeAlgorithm();
        }
    }

    public void showResult() {
        outputView.printResult(playerBridgeMap, isSucess, attepmtCnt);
    }
}
