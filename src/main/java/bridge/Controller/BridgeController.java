package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {

    private Integer bridgeSize;
    private List<String> bridge;

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public BridgeController() {
        outputView.printStartMessage();
        init();
    }
    public void init(){
        bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }
    public void run(){
        BridgeGame bridgeGame = new BridgeGame(bridge);
        int turn = 0;
        while (turn < bridgeSize) {
            System.out.println(bridge);
            bridgeGame.move(inputView.readMoving());
            turn++;
        }
    }
}
