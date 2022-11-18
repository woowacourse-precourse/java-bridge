package bridge;

import static bridge.domain.GameCommand.QUIT;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.GameCommand;
import bridge.domain.MoveResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize), new MoveResult());
        playUntilQuit(bridgeGame, bridgeSize, inputView, outputView);
    }

    private static void playUntilQuit( BridgeGame bridgeGame, int bridgeSize,
        InputView inputView, OutputView outputView) {
        while (true) {
            if (play(bridgeGame, bridgeSize, inputView, outputView).equals(QUIT)) {
                outputView.printResult(bridgeGame.getMoveResult());
                break;
            }
        }
    }

    public static GameCommand play(BridgeGame bridgeGame, int bridgeSize, InputView inputView,
        OutputView outputView) {
        for (int i = 0; i < bridgeSize; i++) {
            bridgeGame.move(i, inputView.readMoving());
            outputView.printMap(bridgeGame.getMoveResult());
            if (!bridgeGame.getMoveResult().isSuccess()) {
                return bridgeGame.retry(inputView.readGameCommand());
            }
        }
        return QUIT;
    }
}
