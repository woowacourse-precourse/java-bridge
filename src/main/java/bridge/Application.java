package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<List<String>> currentBridge = new ArrayList<>();
        List<String> upBridgeResult = new ArrayList<>();
        List<String> downBridgeResult = new ArrayList<>();
        currentBridge.add(upBridgeResult);
        currentBridge.add(downBridgeResult);

        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        for (int turn = 0; turn < bridgeSize; turn++) {
            String moveCommand = inputView.readMoving();
            boolean isPossibleMove = bridgeGame.isPossibleMove(bridge, moveCommand, turn);
            bridgeGame.move(currentBridge, moveCommand, isPossibleMove);
            outputView.printMap(currentBridge);
        }

    }
}
