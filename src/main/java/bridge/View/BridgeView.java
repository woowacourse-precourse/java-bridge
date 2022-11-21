package bridge.View;

import bridge.InputView;

//View
public class BridgeView {

    private final InputView inputView = new InputView();

    public int readBridgeSize() {
        System.out.println("다리의 개수를 입력해주세요.");
        return inputView.readBridgeSize();
    }

    public String readNextStep() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return inputView.readMoving();
    }

}
