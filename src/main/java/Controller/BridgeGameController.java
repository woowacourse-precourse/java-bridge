package Controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import bridge.OutputView;

import java.util.List;

public class BridgeGameController {
    private static int currentPosition = 0;

    public void run() {
        OutputView.printGameStartMessage();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        int bridgeSize = InputView.readBridgeSize();
        System.out.println();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridgeSize, bridge);

        startGame(bridgeGame, bridgeSize);
    }

    private void startGame(BridgeGame bridgeGame, int bridgeSize) {
        while (true) {
            if(play(bridgeGame, bridgeSize)) {
                break;
            }
            if (InputView.readGameCommand().equals("Q")) {
                break;
            }
            bridgeGame.retry();
        }
        OutputView.printResult(currentPosition, bridgeGame);
    }

    private boolean play(BridgeGame bridgeGame, int bridgeSize) {
        currentPosition = 0;
        for (; currentPosition < bridgeSize; currentPosition++) {
            String cmd = InputView.readMoving();
            boolean isSuccess = bridgeGame.move(cmd, currentPosition);
            OutputView.printMap(currentPosition+1, bridgeGame.getBridgeMap());
            if(!isSuccess) {
                return false;
            }
        }
        return true;
    }
}
