package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.constants.Constants.*;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

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
