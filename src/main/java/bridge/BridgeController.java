package bridge;

import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    private Integer bridgeSize;
    private List<String> bridgeList;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }
    void init(){
        outputView.printGameStartMessage();
        outputView.printBridgeRequestMessage();
        bridgeSize = inputView.readBridgeSize();
        bridgeList = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridgeList);
    }

}
