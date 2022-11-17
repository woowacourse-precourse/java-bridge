package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameStarter {

    private List<String> bridge = new ArrayList<>();
    private List<String> result = new ArrayList<>();
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    public BridgeGameStarter(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
    }

    public void initialize() {
        outputView.printGameStartContext();
        outputView.printInputBridgeSize();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        System.out.println(bridge);
        outputView.printInputMoving();
        result = bridgeGame.move(inputView.readMoving(), bridge, 0);
        outputView.printMap(result);
    }

    public boolean run() {
        int index = 1;
        while (!bridgeGame.isGameDone(result) && index < bridge.size()) {
            outputView.printInputMoving();
            result = bridgeGame.move(inputView.readMoving(), bridge, index);
            outputView.printMap(result);
            index ++;
        }
        outputView.printInputGameCommand();
        return bridgeGame.retry(inputView.readGameCommand());
    }

    public void reInitialize() {
        outputView.printInputBridgeSize();
        outputView.printInputMoving();
        bridgeGame.initializeLeftRightResult();
        result = bridgeGame.move(inputView.readMoving(), bridge, 0);
        outputView.printMap(result);
    }

    public void closeGame(int tryCount) {
        outputView.printSuccessStatus(true);
        outputView.printResult(tryCount);
    }
}
