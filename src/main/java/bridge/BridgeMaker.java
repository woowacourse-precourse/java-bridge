package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {


    private final BridgeNumberGenerator bridgeNumberGenerator;
    static int now_size = 1;
    static List<String> bridge_answer = new ArrayList<>();
    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        for (int i = 0; i < size; i++) {
            int a = bridgeRandomNumberGenerator.generate();
            if (a == 0)
                bridge_answer.add("U");
            if (a == 1)
                bridge_answer.add("D");
        }
        return bridge_answer;
    }

    public String resultBridge(int size){

        return null;
    }


}
