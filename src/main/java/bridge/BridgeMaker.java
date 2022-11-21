package bridge;

import bridge.enums.UpDown;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final int START_RANGE = 3;
    private final int END_RANGE = 20;


    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        isValidate(size);
        return IntStream.range(0, size)
                .mapToObj(i -> UpDown.getStringByNum(bridgeNumberGenerator.generate()))
                .collect(Collectors.toList());
    }

    private void isValidate(int size) {
        isCorrectRange(size);
    }

    private void isCorrectRange(int size) {
        if (size < START_RANGE || size > END_RANGE) {
            throw new IllegalArgumentException("It is out of range");
        }
    }
}
