package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final int maxSize = 20;
    private final int minSize = 3;
    private final int up = 1;
    private final int down = 0;
    private final List<String> bridge = new ArrayList<String>();
    private int generatedNumber;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        if(size > maxSize || size < minSize) throw new IllegalArgumentException("[ERROR] 다리의 크기는 3이상 20이하입니다.");
        for(int i = 0; i < size; i++){
            generatedNumber = bridgeNumberGenerator.generate();
            if(generatedNumber == up) bridge.add("U");
            if(generatedNumber == down) bridge.add("D");
        }
        return bridge;
    }
}