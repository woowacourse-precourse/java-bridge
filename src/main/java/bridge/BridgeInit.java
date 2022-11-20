package bridge;

import java.util.List;

public class BridgeService {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    BridgeService(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker){
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public List<String> makeGame(){
        int bridgeLength = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeLength);
    }

    private String getNextStep(){
        return inputView.readMoving();
    }
}
