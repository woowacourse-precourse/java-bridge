package bridge;

import static bridge.domain.enums.Move.D;
import static bridge.domain.enums.Move.U;

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
        List<String> bridge = new ArrayList<>(size);
        for (int count = 0; count < size; count++) {
            String value = getValue(bridgeNumberGenerator.generate());
            bridge.add(value);
        }

        return bridge;
    }

    private String getValue(int number) {
        if (number == 1) {
            return U.name();
        }
        return D.name();
    }
}
