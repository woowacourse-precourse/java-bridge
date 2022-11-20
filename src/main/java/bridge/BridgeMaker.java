package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
        List<String> bridge = new ArrayList<>(size);
        for (int count = 0; count < size; count++) {
            bridge.add(
                    BridgeCell.toString(bridgeNumberGenerator.generate())
            );
        }
        validBridge(bridge);
        return bridge;
    }

    private void validBridge(List<String> bridge) {
        if (bridge.contains("UNDEFINED")) {
            throw new NoClassDefFoundError("[ERROR]: 동작이 정의되지 않은 번호를 입력받았습니다.");
        }
    }
}
