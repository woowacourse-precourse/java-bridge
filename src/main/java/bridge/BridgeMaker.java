package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    // 이 클래스의 필드(인스턴스 변수)를 변경할 수 없다!!!
    // 이 클래스의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다!!!

    private static final String UP = "U";
    private static final String DOWN = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        return IntStream.range(0, size)
                .mapToObj(e -> {
                    if (bridgeNumberGenerator.generate() == 1) {
                        return UP;
                    }

                    return DOWN;
                })
                .collect(Collectors.toList());
    }
}
