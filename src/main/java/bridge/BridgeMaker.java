package bridge;

import bridge.enums.BridgeMove;

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
        List<String> bridges = new ArrayList<>();
        for (int i=0; i<size; i++) {
            int number= bridgeNumberGenerator.generate();
            bridges.add(convertNumber2Bridge(number));
        }
        return bridges;
    }

    private String convertNumber2Bridge(int number) {
        String bridge = null;
        if (number == 0) {
            bridge = BridgeMove.MOVE_DOWN.getMove();
        }
        if (number == 1) {
            bridge = BridgeMove.MOVE_UP.getMove();
        }
        return bridge;
    }
}
