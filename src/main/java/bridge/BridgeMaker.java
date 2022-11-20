package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    // 다리 통행 가능 정보를 담고 있는 리스트
    public static List<String> bridge_info;
    // 현재 체크 중인 다리 인덱스
    public static int bridge_index = 0;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        bridge_info = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            int random_bridge_number = bridgeNumberGenerator.generate();
            if (random_bridge_number == 0){
                bridge_info.add("D");
            }
            if (random_bridge_number == 1){
                bridge_info.add("U");
            }
        }
        return bridge_info;
    }
}
