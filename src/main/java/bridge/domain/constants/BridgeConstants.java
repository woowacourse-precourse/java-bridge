package bridge.domain.constants;

import bridge.exception.UtilClassCreateException;

public class BridgeConstants {
    public static final String UPPER_COMPARTMENT = "U";
    public static final String LOWER_COMPARTMENT = "D";
    
    private BridgeConstants() {
        throw new UtilClassCreateException();
    }
}
