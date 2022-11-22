package bridge;

import bridge.BridgeNumberGenerator;
import bridge.domain.BridgeConstant;
import bridge.domain.BridgeType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        validateSize(size);
        List<Integer> bridgeNumbers = getRandomBridgeNumbers(size);

        return bridgeNumbers.stream()
            .map(number -> BridgeType.valueOf(number).name())
            .collect(Collectors.toList());
    }

    private List<Integer> getRandomBridgeNumbers(int size) {
        List<Integer> bridgeNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridgeNumbers.add(bridgeNumberGenerator.generate());
        }
        return bridgeNumbers;
    }

    private void validateSize(int size) {
        if (size > BridgeConstant.MAX_SIZE) {
            throw new IllegalArgumentException("허용 가능한 다리 길이의 최대값보다 큽니다.");
        }
        if (size < BridgeConstant.MIN_SIZE) {
            throw new IllegalArgumentException("허용 가능한 다리 길이의 최소값보다 작습니다.");
        }
    }
}
