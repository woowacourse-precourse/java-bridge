package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return Stream.iterate(0, i -> i < size, i -> i + 1)
                .map(i -> mapToUpDown())
                .collect(Collectors.toList());
    }

    /**
     * 숫자 0을 D, 1을 U으로 매핑하는 메소드
     * @return U 또는 D
     */
    private String mapToUpDown() {
        int number = bridgeNumberGenerator.generate();
        if (number == 0) {
            return "D";
        }
        return "U";
    }
}
