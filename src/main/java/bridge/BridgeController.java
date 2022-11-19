package bridge;

import view.InputView;
import view.OutputView;

import java.util.List;

public class BridgeController {
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private List<String> moveBridgeResult;

    public void run() {
        new OutputView().printStart();
        makeBridgeController();
    }

    public void makeBridgeController() {
        int size = new InputView().readBridgeSize();
        List<String> bridge = new BridgeMaker(bridgeRandomNumberGenerator).makeBridge(size);
        int blockCount = bridge.size();
        moveController(bridge, blockCount);
    }

    public void moveController(List<String> bridge, int blockCount) {
        BridgeGame bridgeGame = new BridgeGame();
        for (int tryCount = 0; tryCount < blockCount; tryCount++) {
            String sideToMove = new InputView().readMoving();
            moveBridgeResult = bridgeGame.move(bridge, tryCount, sideToMove);
            new OutputView().printMap(moveBridgeResult);
            int resultSize = moveBridgeResult.size();
            if (moveBridgeResult.get(resultSize - 1).contains("X")
                    || moveBridgeResult.get(resultSize - 2).contains("X")) {
                String gameCommand = new InputView().readGameCommand();
                if (gameCommand.equals("R")) {
                    moveBridgeResult.clear();
                    new BridgeGame().retry(bridge, blockCount);
                    tryCount = blockCount;
                }
                if (gameCommand.equals("Q")) {
                    new OutputView().printResult(moveBridgeResult, tryCount + 1);
                    break;
                }
            }
        }
    }
}