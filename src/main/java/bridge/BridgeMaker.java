package bridge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    
    /**
     *
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 지나갈수 있는 칸이 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    // 10줄 초과 리팩토링 필요 //
    public List<String> makeBridge(int size) {
        List<String> bridgeTable = List.of("D","U");
        List<String> bridge = new ArrayList<>(size);
        for(int i = 0 ; i < size; i++){
            int randomNumber = bridgeNumberGenerator.generate();
            bridge.add(bridgeTable.get(randomNumber));
        }
        return bridge;
    }
}
