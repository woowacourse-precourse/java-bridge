package bridge;

import static bridge.utils.Constants.UPPER_NUMBER;

public class BridgeSpecificNumberGenerator implements BridgeNumberGenerator {

    @Override
    public int generate() {
        return UPPER_NUMBER;
    }
}
