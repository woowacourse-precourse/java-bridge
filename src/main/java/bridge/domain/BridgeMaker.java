package bridge.domain;

import bridge.BridgeNumberGenerator;

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
        return null;
    }

    /**
     * 위, 아래의 정보를 가진 다리를 생성하기
     */
    public List<Integer> generateUpDownInformation(final int size) {
        List<Integer> bridgeUpDownInformation = new ArrayList<>();

        for (int currentSize = 0; currentSize < size; ++currentSize) {
            bridgeUpDownInformation.add(bridgeNumberGenerator.generate());
        }
        return bridgeUpDownInformation;
    }
}
