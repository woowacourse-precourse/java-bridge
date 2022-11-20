package bridge.verifier;

public class InputVerifier {
    private static final String REGEX_BRIDGE_SIZE_RANGE = "^[3-9]{1}$|^1{1}[0-9]{1}$|^2{1}0{1}$";
    private static final String MOVING_UP = "U";
    private static final String MOVING_DOWN = "D";

    public static void BridgeSize(String bridgeSize) {
        if (!bridgeSize.matches(REGEX_BRIDGE_SIZE_RANGE)) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이 입력 오류");
        }
    }

    public static void moving(String moving){
        if (!(moving.equals(MOVING_UP) || moving.equals(MOVING_DOWN))){
            throw new IllegalArgumentException("[ERROR] 이동할 칸 입력 오류");
        }
    }
}
