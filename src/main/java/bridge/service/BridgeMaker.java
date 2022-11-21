package bridge.service;

import bridge.domain.Moving;
import bridge.util.BridgeNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    
    public final static int LOWER_BRIDGE_LENGTH = 3;
    public final static int UPPER_BRIDGE_LENGTH = 20;

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
                .mapToObj(v -> bridgeNumberConverter(bridgeNumberGenerator.generate()))
                .collect(Collectors.toList());
    }

    private String bridgeNumberConverter(int number) {
        if (number == 0) return Moving.DOWN.getDirection();
        if (number == 1) return Moving.UP.getDirection();
        throw new IllegalArgumentException();
    }
}
