package bridge.domain;

import bridge.domain.common.BridgeNumberGenerator;
import bridge.domain.common.Side;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for(int bridgeBlock = 0 ; bridgeBlock < size ; bridgeBlock ++){
            bridge.add(makeBlock());
        }
        return bridge;
    }

    private String makeBlock() {
        int randomNumber = bridgeNumberGenerator.generate();
        if (randomNumber == Side.UP.ofNumber()) {
            return Side.UP.ofString();
        }
        if (randomNumber == Side.DOWN.ofNumber()) {
            return Side.DOWN.ofString();
        }
        throw new IllegalArgumentException("랜덤으로 생성되는 번호는 0 또는 1 입니다.");
    }
}
