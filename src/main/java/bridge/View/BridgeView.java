package bridge.View;

import bridge.InputView;

//View
public class BridgeView {

    private final InputView inputView = new InputView();

    public int readBridgeSize() {
        System.out.println("다리의 개수를 입력해주세요.");
        return inputView.readBridgeSize();
    }

}
