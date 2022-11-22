package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.constants.Constants.*;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    public static final String FUNCTION_ERROR_RANDOM_NUMBER = "[ERROR] 브릿지 생성 랜덤숫자에 오류가 있습니다.";
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
        while (size-- > 0) {
            int random = bridgeNumberGenerator.generate();
            bridge.add(settingValue(random));
        }
        return bridge;
    }

    public String settingValue(int random) {
        if (random == BRIDGE_SETTING_MOVED_UP) {
            return GAME_COMMAND_UP;
        }
        if (random == BRIDGE_SETTING_MOVED_DOWN) {
            return GAME_COMMAND_DOWN;
        }
        throw new IllegalArgumentException(FUNCTION_ERROR_RANDOM_NUMBER);
    }
}
