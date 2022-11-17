package bridge.domain;

import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static bridge.utils.ErrorMessages.ERROR_OUT_OF_RANGE;

public class BridgeGenerator {
    public BridgeGenerator(int bridgeSize) {
        validateSize(bridgeSize);
    }

    private void validateSize(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }
}
