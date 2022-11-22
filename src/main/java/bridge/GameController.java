package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class GameController {

    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final static BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        int tryNumber = 1;
        boolean isRetry = true;

        List<String> bridge = makeBridge();
        while (isRetry) {
            CurrentBridgeState currentBridgeState = new CurrentBridgeState();
            boolean isSuccess = tryCrossBridge(bridge, currentBridgeState);
            isRetry = retryController(currentBridgeState, isSuccess, tryNumber);
            tryNumber++;
        }
    }

    private boolean tryCrossBridge(List<String> bridge, CurrentBridgeState currentBridgeState) {

        boolean isPossibleMove = true;
        for (int turn = 0; turn < bridge.size(); turn++) {
            isPossibleMove = moveController(bridge, currentBridgeState, turn);
            if (isPossibleMove == false) {
                break;
            }
        }
        return isPossibleMove;
    }

    private List<String> makeBridge() {

        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return bridge;
    }

    public boolean moveController(List<String> bridge, CurrentBridgeState currentBridgeState, int turn) {

        boolean isPossibleMove;

        String moveCommand = inputView.readMoving();
        isPossibleMove = bridgeGame.move(bridge, moveCommand, turn);
        currentBridgeState.recordBridgeMove(moveCommand, isPossibleMove);
        outputView.printMap(currentBridgeState);

        return isPossibleMove;
    }

    public boolean retryController(CurrentBridgeState currentBridgeState, boolean isSuccess, int tryNumber) {

        boolean isRetry = false;

        if (isSuccess == false) {
            String gameCommand = inputView.readGameCommand();
            isRetry = bridgeGame.retry(gameCommand);
        }
        outputView.printResult(currentBridgeState, isSuccess, tryNumber);

        return isRetry;
    }
}
