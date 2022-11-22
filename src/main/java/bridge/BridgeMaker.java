package bridge;

import bridge.constant.Error;
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
        require(size < 3, Error.SIZE);
        require(size > 25, Error.SIZE);
        return IntStream.range(0, size).map(i -> bridgeNumberGenerator.generate())
            .mapToObj(this::getString).collect(Collectors.toList());
    }

    private void require(boolean condition, Error size) {
        if (condition) throw new IllegalArgumentException(size.getMsg());
    }

    private String getString(int k) {
        if (k == 0) return "D";
        return "U";
    }
}
