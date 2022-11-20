package bridge;

import bridge.utils.Converter;
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
    public List<String> makeBridge(int size) {
        List<Integer> bridgeValues = generateBridgeValues(size);

        return Converter.getSituationThrough(bridgeValues);
    }

    private List<Integer> generateBridgeValues(int size) {
        List<Integer> bridgeValues = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            bridgeValues.add(getBridgeValue());
        }
        return bridgeValues;
    }

    private int getBridgeValue() {
        return bridgeNumberGenerator.generate();
    }
}
