package bridge;

import java.util.List;

public class BridgeGameInit {

    protected InputView inputView;
    protected OutputView outputView;

    protected List<String> bridge;

    BridgeGameInit() {
        init();
    }


    protected void init(){
        initViews();
        initBridge();
    }

    protected void initBridge() {
        int ladderLen = getLength();
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker maker = new BridgeMaker(generator);
        this.bridge = maker.makeBridge(ladderLen);
    }

    protected void initViews() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    protected int getLength(){
        return inputView.readBridgeSize();
    }



    public void bridgeToString() {
        System.out.println(bridge.toString());
    }
}
