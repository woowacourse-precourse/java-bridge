package bridge;

import bridge.view.InputView;

import java.util.List;

public class Controller {

    private final InputView inputView;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void run(){
        inputView.getBridgeGameStartMsg();
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        while(true){
            String moving = inputView.readMoving();

        }
    }
}
