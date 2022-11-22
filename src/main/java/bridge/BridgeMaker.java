package bridge;

import static bridge.controller.BridgeController.RANGE_END;
import static bridge.controller.BridgeController.RANGE_START;

import bridge.model.Direction;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return IntStream.range(0, size)
                .map(i -> bridgeNumberGenerator.generate())
                .mapToObj(Direction::by)
                .map(Direction::getDirection)
                .collect(Collectors.toList());
    }

    private void validate(int size) {
        if (outOfRange(size)) {
            throw new IllegalArgumentException(
                    String.format("다리 길이는 %d부터 %d 사이의 숫자여야 합니다. 입력 : %d",
                            RANGE_START, RANGE_END, size));
        }
    }

    private boolean outOfRange(int size) {
        return RANGE_START > size || RANGE_END < size;
    }

}
