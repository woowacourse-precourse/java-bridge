package bridge;

import domain.Bridge;
import view.InputView;
import view.OutputView;

public class BridgeController {

    private InputView inputView = new InputView();
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private Bridge bridge;
    private int size;

    public BridgeController() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridgeGame = new BridgeGame();
    }

    public void start() {
        OutputView.printStartMessage();
        size = inputView.readBridgeSize();
        bridge = new Bridge(bridgeMaker.makeBridge(size));
        System.out.println(bridge.getBridge());
        run();
    }

    public void run() {
        for (int i = 0; i < size; i++) {
            String move = inputView.readMoving();
            bridgeGame.move(move, bridge.getBridge());
        }
    }

}
