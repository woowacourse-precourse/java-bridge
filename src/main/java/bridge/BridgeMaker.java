package bridge;

import static bridge.Bridge.UP_BLOCK_MARK;
import static bridge.Bridge.DOWN_BLOCK_MARK;
import static java.util.Collections.unmodifiableList;

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
        List<String> result = new ArrayList<>();
        for (int curr = 0; curr < size; curr++) {
            result.add(
                    makeBlock(this.bridgeNumberGenerator.generate())
            );
        }
        return unmodifiableList(result);
    }

    private String makeBlock(int randomNumber) {
        if (randomNumber == 0) {
            return DOWN_BLOCK_MARK;
        }
        return UP_BLOCK_MARK;
    }
}
