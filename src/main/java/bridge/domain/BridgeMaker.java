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
     * 입력한 다리 사이즈만큼 "U", "D"의 정보를 담은 문자열 리스트를 생성하기
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(final int size) {
        List<String> bridge = new ArrayList<>();

        for (int currentSize = 0; currentSize < size; ++currentSize) {
            int number = bridgeNumberGenerator.generate();

            bridge.add(BridgeMapper.findUpDownStatus(number).getUpDownInformation());
        }
        return bridge;
    }
}
