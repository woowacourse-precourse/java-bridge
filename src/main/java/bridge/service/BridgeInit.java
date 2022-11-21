package bridge.service;

import bridge.view.InputView;

import java.util.List;

public class BridgeInit {

    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public BridgeInit(InputView inputView, BridgeMaker bridgeMaker){
        this.inputView = inputView;
        this.bridgeMaker = bridgeMaker;
    }

    public List<String> makeGame(){
        int bridgeLength = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeLength);
    }

    public String getNextStep(){
        return inputView.readMoving();
    }

    public String getNextGameMode(){
        return inputView.readGameCommand();
    }
}
