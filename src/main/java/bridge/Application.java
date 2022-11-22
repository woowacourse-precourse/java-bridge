package bridge;

import java.util.List;

public class Application {

    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CurrentBridgeState currentBridgeState = new CurrentBridgeState();
        int tryNumber = 1;

        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        while (true) {
            boolean isPossibleMove = true;
            for (int turn = 0; turn < bridgeSize; turn++) {
                String moveCommand = inputView.readMoving();
                isPossibleMove = bridgeGame.isPossibleMove(bridge, moveCommand, turn);
                currentBridgeState.recordBridgeMove(moveCommand, isPossibleMove);
                outputView.printMap(currentBridgeState);
                if (isPossibleMove == false) {
                    String gameCommand = inputView.readGameCommand();
                    if (gameCommand.equals("Q")) {
                        outputView.printResult(currentBridgeState, isPossibleMove, tryNumber);
                        return ;
                    } else if (gameCommand.equals("R")) {
                        break;
                    }
                }
            }
            if (isPossibleMove == true) {
                outputView.printResult(currentBridgeState, isPossibleMove, tryNumber);
                return ;
            }
            tryNumber++;
        }

    }
}
