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


    public void run() {
        start();
        bridgeGame = new BridgeGame(inputLength());
        crossBridge();
    }


    public void start() {
        outputView.printGameStartMessage();
    }

    public List<String> inputLength() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        try {
            List<String> list = bridgeMaker.makeBridge(inputView.readBridgeSize());
            return list;
        } catch (IllegalArgumentException i) {
            System.out.println("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return inputLength();
    }


    public void crossBridge() {
        do {
            tryMove();
        } while (!bridgeGame.isEnd() && bridgeGame.retry(inputView.readGameCommand()));
        outputView.printResult(bridgeGame);
    }

    private void tryMove() {
        while (!bridgeGame.isEnd()) {
            if (!bridgeGame.move(inputView.readMoving())) {
                outputView.printMap(bridgeGame.getBridgeTokens());
                break;
            }
            outputView.printMap(bridgeGame.getBridgeTokens());
        }
    }
}