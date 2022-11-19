package bridge;

import view.InputView;
import view.OutputView;

import java.util.List;

public class BridgeController {
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private List<String> moveResult;
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public void run() {
        new OutputView().printStart();
        makeBridgeController();
    }

    public void makeBridgeController() {
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        int size = new InputView().readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        int blockCount = bridge.size();
        moveController(bridge, blockCount);
    }

    public void moveController(List<String> bridge, int blockCount) {
        bridgeGame = new BridgeGame();
        for (int i = 0; i < blockCount; i++) {
            String sideToMove = new InputView().readMoving();
            moveResult = bridgeGame.moveResult(bridge, i, sideToMove);
            new OutputView().printMap(moveResult);
            int resultSize = moveResult.size();
            if (moveResult.get(resultSize - 1).contains("X")
                    || moveResult.get(resultSize - 2).contains("X")) {
                String gameCommand = new InputView().readGameCommand();
                if (gameCommand.equals("R")) {
                    moveResult.clear();
                    new BridgeGame().retry(bridge, blockCount);
                    i = blockCount;
                }
                if (gameCommand.equals("Q")) {
                    new OutputView().printResult(moveResult);
                    new OutputView().printFailedResult(1);
                    break;
                }
            }
            if (i == blockCount - 1) {
                new OutputView().printResult(moveResult);
                new OutputView().printSuccessResult(1);
            }
        }
    }
}