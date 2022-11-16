package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 * TODO 필드(인스턴스 변수) 변경 불가!!!!!!
 * TODO 메서드의 시그니처(인자, 이름)와 반환 타입은 변경 불가!!!!!
 */
public class BridgeMaker {

    private static final String NOT_VALID_BRIDGE_LENGTH = "다리의 길이는 3 이상 20 이하여야 합니다.";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateBridgeSize(size);
        List<String> results = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            if (randomNumber == 1) {
                results.add("U");
                continue;
            }

            results.add("D");
        }

        return results;
    }

    private void validateBridgeSize(int size) {
        final int MIN_SIZE = 3;
        final int MAX_SIZE = 20;
        if (size < MIN_SIZE || MAX_SIZE < size) {
            throw new IllegalArgumentException(NOT_VALID_BRIDGE_LENGTH);
        }
    }
}
