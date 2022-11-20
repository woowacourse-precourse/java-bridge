package bridge;

import java.util.List;

public class RandomBridge {

    private final InputView inputView;
    private List<String> bridge;

    public RandomBridge(){
        inputView = new InputView();
    }

    // 사이즈를 받아서 그 크기만큼 랜덤 할당
    private void makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        bridge = bridgeMaker.makeBridge(bridgeSize);
    }


}
