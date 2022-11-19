package bridge.contoller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private BridgeGame bridgeGame;


    public void start() {
        outputView.printGameStartMessage();
        bridgeGame = new BridgeGame(inputLength());
        crossBridge();
    }

    private List<String> inputLength() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> list = bridgeMaker.makeBridge(inputView.readBridgeSize());
        return list;
    }

    private void crossBridge() {
        do {
            tryMove();

            if (bridgeGame.isEnd()) {
                break;
            }
        } while (bridgeGame.retry(inputView.readGameCommand()));

        outputView.printResult(bridgeGame);
    }

    private void tryMove() {
        while (!bridgeGame.isEnd()) {
            if (bridgeGame.move(inputView.readMoving())) {
                outputView.printMap(bridgeGame.getBridgeTokens());
                continue;
            }
            outputView.printMap(bridgeGame.getBridgeTokens());
            break;
        }
    }

}