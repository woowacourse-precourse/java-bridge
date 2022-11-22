package bridge;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;


/**
 *  다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 *  필드 변경 불가
 *  시그니처(인자, 이름)와 반환 타입 변경 가능
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;


    public BridgeMaker(final BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(final int size) {
        List<String> bridge = new ArrayList<>();
        for(int i=0; i<size; i++) {
            if(bridgeNumberGenerator.generate() == 1) {
                bridge.add("U");
                continue;
            }
            bridge.add("D");
        }
        return bridge;
    }
}