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
        try {
            playUntilQuit(bridgeMaker, inputView, outputView);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private static void playUntilQuit(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        outputView.printGameStartMessage();

        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()), new MoveResult());
        while (true) {
            if (play(bridgeGame, inputView, outputView).equals(QUIT)) {
                outputView.printResult(bridgeGame.getMoveResult());
                break;
            }
        }
    }

    public static GameCommand play(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
            bridgeGame.move(i, inputView.readMoving());
            outputView.printMap(bridgeGame.getMoveResult());
            if (!bridgeGame.getMoveResult().isSuccess()) {
                return bridgeGame.retry(inputView.readGameCommand());
            }
        }
        return QUIT;
    }
}
