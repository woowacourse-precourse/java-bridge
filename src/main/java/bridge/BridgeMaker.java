package bridge;

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
        validate(size);
        return binaryToString(generateRandomBinary(size));
    }

    private void validate(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3이상 20이하여야 합니다.");
        }
    }

    private List<Integer> generateRandomBinary(int size) {
        List<Integer> binaryBridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            binaryBridge.add(this.bridgeNumberGenerator.generate());
        }
        return binaryBridge;
    }

    private List<String> binaryToString(List<Integer> binaryBridge) {
        return binaryBridge.stream()
                .map(this::binaryToString)
                .collect(Collectors.toList());
    }

    private String binaryToString(int binary) {
        if (binary == 0) {
            return "D";
        }
        if (binary == 1) {
            return "U";
        }
        throw new IllegalArgumentException("[ERROR] 다리 생성을 위한 숫자 배열은 0과 1로만 이루어져야 합니다.");
    }
}
