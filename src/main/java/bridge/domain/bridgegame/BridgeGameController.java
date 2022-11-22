package bridge.domain.bridgegame;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGameStarter;
import bridge.io.input.InputView;
import bridge.io.output.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController implements BridgeGameStarter {
    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;
    private List<String> bridge;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridgeGame = new BridgeGame();
        this.bridge = new ArrayList<>();
    }

    @Override
    public void start() {
        outputView.printStartMessage();
        int bridgeSize = inputView.readBridgeSize();
        System.out.println();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        while (!moveUser()) {
            if (!wantRetry()) {
                break;
            }
            bridgeGame.reset();
        }
        outputView.printResult(bridgeGame.getGameStatus());
    }

    private boolean moveUser() {
        for (int index = 0; index < bridge.size(); index++) {
            String movement = inputView.readMoving();
            boolean flag = bridge.get(index).equals(movement);
            bridgeGame.move(movement, flag, index);
            outputView.printMap(bridgeGame.getGameStatus());
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    public boolean wantRetry() {
        return bridgeGame.retry(inputView.readGameCommand());
    }
}
