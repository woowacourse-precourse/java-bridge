package bridge;

import bridge.enums.BridgeMakerMapping;
import bridge.enums.BridgeSizeBound;
import bridge.enums.ErrorMessage;
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
        validateBridgeSize(size);

        return getNumbers(size).stream()
                .map(this::convertNumToString)
                .collect(Collectors.toList());
    }

    private void validateBridgeSize(int size) {
        if (size < BridgeSizeBound.LOWER.getBound() || BridgeSizeBound.UPPER.getBound() < size) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_EXCEPTION.getMessage());
        }
    }

    private List<Integer> getNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randNum = bridgeNumberGenerator.generate();
            numbers.add(randNum);
        }

        return numbers;
    }

    private String convertNumToString(int num) {
        return BridgeMakerMapping.findBy(num).getStr();
    }

}
