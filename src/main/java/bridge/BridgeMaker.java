package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final String UPPER_MOVING = "U";
    private static final String LOWER_MOVING = "D";
    private static final int BRIDGE_EXIST_NUMBER = 1;
    
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
                .mapToObj(count -> parsePartBridgeState())
                .collect(Collectors.toUnmodifiableList());
    }
    
    private String parsePartBridgeState() {
        if (isPartBridgeExist(partBridgeCreateRandomNumber())) {
            return UPPER_MOVING;
        }
        
        return LOWER_MOVING;
    }
    
    private int partBridgeCreateRandomNumber() {
        return bridgeNumberGenerator.generate();
    }
    
    private boolean isPartBridgeExist(final int generate) {
        return generate == BRIDGE_EXIST_NUMBER;
    }
}
