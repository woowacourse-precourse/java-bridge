package bridge;

import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private List<String> bridgeScaffold;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        int bridgeSize = getBridgeSize();

        BridgeGame bridgeGame = new BridgeGame(bridgeScaffold);
        boolean crossBridgeResult = crossBridge(bridgeGame, bridgeSize);
        if (!crossBridgeResult) {

        }
    }

    private int getBridgeSize() {
        int bridgeSizeInput = inputView.readBridgeSize();
        this.bridgeScaffold = bridgeMaker.makeBridge(bridgeSizeInput);
        return bridgeSizeInput;
    }

    private boolean crossBridge(BridgeGame bridgeGame, int bridgeSize) {
        for (int i = 0; i < bridgeSize; i++) {
            if(moveOneStep(bridgeGame)){
                return false;
            }
        }
        return true;
    }

    private boolean moveOneStep(BridgeGame bridgeGame) {
        String direction = inputView.readMoving();

        List<String> movingProgress = bridgeGame.move(direction);

        outputView.printMap(movingProgress);

        return checkStepFail(movingProgress);
    }

    private boolean checkStepFail(List<String> movingProgress) {
        return movingProgress.stream()
                .anyMatch(progress -> progress.contains("X"));
    }
}
