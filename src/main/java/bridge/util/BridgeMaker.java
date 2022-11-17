package bridge.util;

import java.util.ArrayList;
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
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) { //TODO U, D Enum이나 HashMap을 만들어서 0 -> D , 1 -> U 반환 만들기
        List<String> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            int up_and_down = bridgeNumberGenerator.generate();
            list.add(String.valueOf(up_and_down));
        }
        return list;
    }
}
