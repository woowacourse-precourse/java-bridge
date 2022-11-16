package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 인스턴스 변수 변경 안됨. 메서드의 인자와 이름, 반환타입 변경 안됨.
 * /**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    public static final int BRIDGE_DOWN_RANDOM_NUMBER = 0;
    public static final int BRIDGE_UP_RANDOM_NUMBER = 1;
    public static final String BRIDGE_DOWN_MARK = "D";
    public static final String BRIDGE_UP_MARK = "U";
    public static final int INIT_SIZE_INDEX = 0;
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
        for (int sizeIndex = INIT_SIZE_INDEX; sizeIndex < size; sizeIndex++) {
            int number = bridgeNumberGenerator.generate();
            chageNumberToMark(bridge, number);
        }
        return bridge;
    }

    private static void chageNumberToMark(List<String> bridge, int number) {
        if (number == BRIDGE_DOWN_RANDOM_NUMBER) {
            bridge.add(BRIDGE_DOWN_MARK);
        }
        if (number == BRIDGE_UP_RANDOM_NUMBER) {
            bridge.add(BRIDGE_UP_MARK);
        }
    }
}
