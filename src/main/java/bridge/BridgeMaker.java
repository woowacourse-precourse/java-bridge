package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public String changeNumToStr(int _num) {
        if (_num == Constant.UP_CONTROL.getConstant()) {
            return "U";
        }
        if (_num == Constant.DOWN_CONTROL.getConstant()) {
            return "D";
        }
        return "ERROR";
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i+= Constant.MOVE_DISTANCE.getConstant()) {
            String randomUpOrDown = changeNumToStr(bridgeNumberGenerator.generate());
            bridge.add(randomUpOrDown);
        }
        return bridge;
    }
}
