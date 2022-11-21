package bridge;

import java.util.LinkedList;
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
        List<String> bridge = new LinkedList<>();
        for (int choice = 0; choice < size; choice++) {
            int siteAvailabliityCode = bridgeNumberGenerator.generate();
            if (SiteAvailability.ACCESS_UP_SITE.isSameValue(siteAvailabliityCode))
                Site.UP.saveMovementCommandInBridge(bridge);

            if (SiteAvailability.ACCESS_DOWN_SITE.isSameValue(siteAvailabliityCode))
                Site.DOWN.saveMovementCommandInBridge(bridge);
        }
        return bridge;
    }
}
