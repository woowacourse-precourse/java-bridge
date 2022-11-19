package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        inputView.getBridgeGameStartMsg();
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        int step = 0;
        while(step != bridgeSize){
            String moving = inputView.readMoving();
            boolean isEqual = bridgeGame.move(moving, step);
            outputView.printMap(bridgeGame);
            if (!isEqual){

            }
            step++;
        }
    }
}
