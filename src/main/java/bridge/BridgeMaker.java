package bridge;

import java.util.ArrayList;
import java.util.List;
import bridge.BridgeRandomNumberGenerator;

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
    public static List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        int temp; String correct_direction;
        for(int i = 0; i < size; i++){
            temp = BridgeRandomNumberGenerator.generate_num();
            if(temp == 1) {
                correct_direction = "U";
                bridge.add(i, correct_direction); }
            else if(temp == 0) {
                correct_direction = "D";
                bridge.add(i, correct_direction); }
        } return bridge;
    }
}
