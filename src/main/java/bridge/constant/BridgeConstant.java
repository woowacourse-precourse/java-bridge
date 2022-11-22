package bridge.constant;

public class BridgeConstant {

    public static final int MAX_BRIDGE_LENGTH = 20;
    public static final int MIN_BRIDGE_LENGTH = 3;
    public static final String DIRECTION_INPUT_REGEX = "^[DU]$";
    public static final String COMMAND_INPUT_REGEX = "^[RQ]$";
    public static final String BRIDGE_START_LETTER = "[ ";
    public static final String BRIDGE_MIDDLE_LETTER = " | ";
    public static final String BRIDGE_END_LETTER = " ]";

    private BridgeConstant() {
    }
}
