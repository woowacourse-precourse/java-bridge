package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final String MOVE_UP_VALUE = "U";
    private static final String MOVE_DOWN_VALUE = "D";
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<Integer> randomNums = makeRandomNums(size);
        return randomNums
                .stream()
                .map(this::convertToMatchingValue)
                .collect(Collectors.toList());
    }

    private List<Integer> makeRandomNums(int size) {
        return IntStream.rangeClosed(1,size)
                .mapToObj(i -> bridgeNumberGenerator.generate())
                .collect(Collectors.toList());
    }

    private String convertToMatchingValue(int randomNum) {
        final int MOVE_UP_NUMBER = 1;
        if (randomNum == MOVE_UP_NUMBER) {
            return MOVE_UP_VALUE;
        }
        return MOVE_DOWN_VALUE;
    }
}
