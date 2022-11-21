package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;
    private int bridgeSize, attemptCnt;
    private final BridgeMaker bridgeMaker;
    private boolean isSuccess;
    private List<String> playerBridgeMap, RandomBridgeMap;

    public BridgeGameController() {
        bridgeGame = new BridgeGame();
        inputView = new InputView();
        playerBridgeMap = new ArrayList<>();
        RandomBridgeMap = new ArrayList<>();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        outputView = new OutputView();
    }

    public void start() {
        attemptCnt = 0;
        bridgeSize = inputView.readBridgeSize();

        RandomBridgeMap = bridgeMaker.makeBridge(bridgeSize);
        BridgeAlgorithm();
    }

    private void checkAllPass(int idx, int bridgeSize) {
        if (idx != bridgeSize) {
            isSuccess = false;
            showRestart();
        }
    }

    private boolean checkSameInBridgeAlgorithm(int idx, String playerStep) {
        return !bridgeGame.checkSame(RandomBridgeMap, idx, playerStep);
    }

    private String bridgeAlgorithm(int idx) {
        String playerStep = inputView.readMoving();
        bridgeGame.move(playerBridgeMap, RandomBridgeMap, idx, playerStep);
        outputView.constructMap(playerBridgeMap);
        return playerStep;
    }

    private void bridgeAlgorithmSetting() {
        isSuccess = true;
        attemptCnt += 1;
    }

    public void constructBridgeAlgorithm() {
        bridgeAlgorithmSetting();
        int idx;
        for (idx = 0; idx < bridgeSize; idx += Constant.MOVE_DISTANCE.getConstant()) {
            String playerStep = bridgeAlgorithm(idx);
            if (checkSameInBridgeAlgorithm(idx, playerStep)) {
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
        outputView.printResult(playerBridgeMap, isSuccess, attemptCnt);
    }
}
