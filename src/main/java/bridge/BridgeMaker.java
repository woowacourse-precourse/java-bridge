package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    public static final Integer MIN_SIZE = 1;
    private final BridgeNumberGenerator bridgeNumberGenerator;
    
    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateSize(size);
        List<String> result = new ArrayList<>(size);
        
        for (int i = 0; i < size; i++) {
            result.add(BridgeDirection.generateByNumber(bridgeNumberGenerator.generate()).getSelect());
        }
        
        return result;
    }
    
    private void validateSize(int size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException("다리 길이는 최소 1이상으로 입력해주세요.");
        }
    }
}
