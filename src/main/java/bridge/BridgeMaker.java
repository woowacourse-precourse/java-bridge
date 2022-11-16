package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final String TOP_ROW = "U";
    private static final String BOTTOM_ROW = "D";
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> result = new ArrayList<>(size);
        makeRandomBridge(result, size);
        return result;
    }

    /**
     * @param result 건널 수 있는 다리의 정보를 가지고 있는 List<String>
     * @param size generate 함수 호출 횟수
     * BridgeNumberGenerator 의 generate 함수를 통해 0을 받으면 "D"를 1을 받으면 "U"를 result 에 추가 한다.
     */
    private void makeRandomBridge(List<String> result, int size) {
        for (int i = 0; i < size; ++i) {
            if (this.bridgeNumberGenerator.generate() == 0) {
                result.add(BOTTOM_ROW);
                continue;
            }
            result.add(TOP_ROW);
        }
    }
}
