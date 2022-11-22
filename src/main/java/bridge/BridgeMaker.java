package bridge;

import bridge.domain.Move;

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
        validate(size);
        List<String> result = new ArrayList<>();

        // 생성된 숫자를 방향값으로 변환하여 반환할 리스트에 추가한다.
        for (int i = 0; i < size; i++) {
            int upDown = bridgeNumberGenerator.generate();
            String direction = Move.from(upDown).getDirection();
            result.add(direction);
        }
        return result;
    }

    private void validate(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("다리 사이즈는 양수여야합니다. (입력:" + size + ")");
        }
    }
}
