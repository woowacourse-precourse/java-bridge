package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator; // 멤버 변수 (인터페이스)

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) { // BridgeMaker 클래스의 생성자
        this.bridgeNumberGenerator = bridgeNumberGenerator; // 해당 객체의 멤버변수(인터페이스)는 매개변수로 입력받은 인터페이스임
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for(int count = 0; count < size; count++){
            int direction = bridgeNumberGenerator.generate();
            bridge.add("D");
            if (direction == 1) {bridge.set(count,"U");}
        }
        return bridge;
    }
}
