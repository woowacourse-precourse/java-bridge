package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int DOWN = 0;
    private static final int UP = 1;
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
        makeDirectionToMove(bridges, size);
        return Collections.unmodifiableList(bridges);
    }

    public void makeDirectionToMove(List<String> bridges, int size) {
        for(int i = 0; i < size; i++) {
            changeNumberToDirection(bridges);
        }
    }

    public void changeNumberToDirection(List<String> bridges) {
        if(bridgeNumberGenerator.generate() == DOWN) {
            bridges.add("D");
        }
        if(bridgeNumberGenerator.generate() == UP) {
            bridges.add("U");
        }
    }
}
