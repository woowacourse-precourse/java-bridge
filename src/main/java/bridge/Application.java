package bridge;

import java.util.List;

public class Application {

    private final static InputView inputView = new InputView();
    private final static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CurrentBridgeState currentBridgeState = new CurrentBridgeState();
        int tryNumber = 1;
        boolean isPossibleMove = true;
        boolean isRetry = true;
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        while (isRetry) {
            for (int turn = 0; turn < bridgeSize; turn++) {
                isPossibleMove = bridgeGame.move(bridge, currentBridgeState, bridgeSize);
                if (isPossibleMove == false) {
                    isRetry = bridgeGame.retry(currentBridgeState, isPossibleMove, tryNumber);
                }else if (isPossibleMove == true) {
                    outputView.printResult(currentBridgeState, isPossibleMove, tryNumber);
                    return ;
                }
            }
            tryNumber++;
        }
    }
}
