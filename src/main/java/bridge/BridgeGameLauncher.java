package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameLauncher {
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private final List<String> bridge = bridgeMaker.transmitBridge();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private List<List<String>> resultMap;

    private int attempts = 1;

    public void run() {
        while (true) {
            resultMap = new ArrayList<>();
            if (isSuccessfulCrossing()) {
                outputView.printResult(true, attempts);
                return;
            }
            if (!isRetry()) {
                outputView.printResult(false, attempts);
                return;
            }
            attempts++;
        }
    }

    private boolean isSuccessfulCrossing() {
        for (String block : bridge) {
            String currentMoving = inputView.readMoving();
            boolean isSuccess = bridgeGame.move(block, currentMoving);
            List<String> newMap = outputView.printMap(currentMoving, isSuccess, resultMap);
            resultMap.add(newMap);
            if (!isSuccess) {
                return false;
            }
        }
        return true;
    }

    private boolean isRetry() {
        String inputForRestart = inputView.readGameCommand();
        //최종 게임 결과
        return bridgeGame.retry(inputForRestart);
    }

}
