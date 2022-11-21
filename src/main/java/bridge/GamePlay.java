package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class GamePlay {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void start(){
        outputView.printStartMessage();
        int size = inputView.readBridgeSize();
//        bridgeMaker.makeBridge(size);
        System.out.println(bridgeMaker.makeBridge(size));
    }
}
