package bridge.domain;

import java.util.ArrayList;
import java.util.List;

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
        for (int phase = 0; phase < size; phase++) {
            bridge.add(convert(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private String convert(int number) {
        if(number == Command.UP.getStatusInteger()) {
            return Command.UP.getStatusString();
        }
        return Command.DOWN.getStatusString();
    }
}
