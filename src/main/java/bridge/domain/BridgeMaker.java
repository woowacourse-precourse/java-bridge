package bridge.domain;

import bridge.domain.common.BridgeNumberGenerator;
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

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
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
