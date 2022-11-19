package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
/**
 * <주어진 그대로 사용하기>
 * 필드 변경 불가능
 * 메서드 이름, 인자, 반환 타입 변경 불가능
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
        List<String> bridge = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            bridge.add(Integer.toString(bridgeNumberGenerator.generate()));
        }
        Collections.replaceAll(bridge, "1", "U");
        Collections.replaceAll(bridge, "0", "D");

        return bridge;
    }

}
