package bridge;

import java.util.List;

public class RandomBridge {

    private final InputView inputView;
    private List<String> bridge;

    public RandomBridge() {
        inputView = new InputView();
    }

    /**
     * 브릿지를 초기화 해주는 메소드
     */
    public void initBridge() {
        int bridgeSize = readBirdgeSize();
        makeBridge(bridgeSize);
    }

    /**
     * 브릿지의 크기를 입력하는 메소드
     */
    private int readBirdgeSize() {
        while (true) {
            OutputGameMessage.RANGE_INPUT_MESSAGE.printMessage();
            int bridgeSize = inputView.readBridgeSize();
            if (bridgeSize != -1)
                return bridgeSize;
        }
    }

    /**
     * 사이즈를 받아서 그 크기만큼 랜덤 할당
     */
    private void makeBridge(final int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public List<String> getBridge() {
        return bridge;
    }

}
