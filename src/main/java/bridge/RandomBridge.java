package bridge;

import java.util.List;

public class RandomBridge {

    private final InputView inputView;
    private List<String> bridge;

    public RandomBridge(){
        inputView = new InputView();
    }

    //브릿지의 크기를 입력
    private int readBirdgeSize() {
        while (true) {
            System.out.println("다리의 길이를 입력해주세요.");
            int bridgeSize = inputView.readBridgeSize();
            if (bridgeSize != -1)
                return bridgeSize;
        }
    }

    // 사이즈를 받아서 그 크기만큼 랜덤 할당
    private void makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        bridge = bridgeMaker.makeBridge(bridgeSize);
    }


}
