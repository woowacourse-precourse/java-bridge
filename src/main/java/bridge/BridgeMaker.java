package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int UP = 0;
    private static final int DOWN = 1;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridgeMap = new ArrayList<>();

        for (int i = 0; i < size; ++i) {
            String cell = buildBridgeCell(bridgeNumberGenerator.generate());
            bridgeMap.add(cell);
        }
        return bridgeMap;
    }

    private String buildBridgeCell(int cell) {
        validateBridgeCell(cell);
        if (cell == UP) {
            return BridgeGame.CMD_UP;
        }
        return BridgeGame.CMD_DOWN;
    }

    private static void validateBridgeCell(int cell) {
        if (cell != UP && cell != DOWN) {
            throw new IllegalArgumentException("[ERROR] 브릿지 셀을 만드는 과정에서 예기치 못한 오류가 발생했습니다.");
        }
    }
}
