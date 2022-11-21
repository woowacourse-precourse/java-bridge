package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;
    private int bridgeSize, attepmtCnt;
    private final BridgeMaker bridgeMaker;
    private boolean isSucess;
    private List<String> playerBridgeMap, RandomBridgeMap;

    public BridgeGameController() {
        bridgeGame = new BridgeGame();
        inputView = new InputView(new CheckNum());
        playerBridgeMap = new ArrayList<>();
        RandomBridgeMap = new ArrayList<>();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        outputView = new OutputView();
    }

    public void start() {
        attepmtCnt = 0;
        bridgeSize = inputView.readBridgeSize();

        RandomBridgeMap = bridgeMaker.makeBridge(bridgeSize);
        BridgeAlgorithm();
    }

    private void checkAllPass(int idx, int bridgeSize) {
        if (idx != bridgeSize) {
            isSucess = false;
            showRestart();
        }
    }

    private boolean checkSameInBridgeAlogorithm(int idx, String playerStep) {
        return !bridgeGame.checkSame(RandomBridgeMap, idx, playerStep);
    }

    private String bridgeAlgorithm(int idx) {
        String playerStep = inputView.readMoving();
        bridgeGame.move(playerBridgeMap, RandomBridgeMap, idx, playerStep);
        outputView.constructMap(playerBridgeMap);
        return playerStep;
    }

    private void bridgeAlgorithmSetting() {
        isSucess = true;
        attepmtCnt += 1;
    }

    public void constructBridgeAlgorithm() {
        bridgeAlgorithmSetting();
        int idx;
        for (idx = 0; idx < bridgeSize; idx += Constant.MOVE_DISTANCE.getConstant()) {
            String playerStep = bridgeAlgorithm(idx);
            if (checkSameInBridgeAlogorithm(idx, playerStep)) {
                break;
            }
        }
        checkAllPass(idx, bridgeSize);
    }

    public void BridgeAlgorithm() {
        constructBridgeAlgorithm();
        showResult();
    }

    public void showRestart() {
        String restartInput = inputView.readGameCommand();
        if (bridgeGame.retry(restartInput)) {
            playerBridgeMap = new ArrayList<>();
            constructBridgeAlgorithm();
        }
    }

    public void showResult() {
        outputView.printResult(playerBridgeMap, isSucess, attepmtCnt);
    }
}
