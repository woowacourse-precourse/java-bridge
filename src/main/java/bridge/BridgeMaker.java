package bridge;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int MINIMUM_LENGTH = 3;
    private static final int MAXIMUM_LENGTH = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateSizeRange(size);
        return Stream.generate(bridgeNumberGenerator::generate)
                     .limit(size)
                     .map(Direction::getPosition)
                     .collect(toList());
    }

    private void validateSizeRange(int size) {
        if (size < MINIMUM_LENGTH || MAXIMUM_LENGTH < size) {
            throw new IllegalArgumentException();
        }
    }

}
