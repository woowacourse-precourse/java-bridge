package bridge.Game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.View.InputView;

import java.util.List;

public class Bridge extends BridgeMaker {

    // TODO: 다리를 건널때 input을 활용한다.
    // TODO: 클래스변수 bridge 의 값이 바뀌어야 한다.
    // TODO: 건너는 다리 상태를 보여줄 수 있는 기능이 있어야한다.
    // TODO: 누적 시도한 값을 가지고 있어야한다.

    private final InputView input;
    private static List<String> bridge;

    public Bridge() {
        super(new BridgeRandomNumberGenerator());
        this.input = new InputView();

        int size = input.readBridgeSize();
        this.bridge = makeBridge(size);
    }

    public boolean passBridge() {
        String direction = input.readMoving();
        return true;
    }

    public boolean isArrived() {
        return false;
    }

}
