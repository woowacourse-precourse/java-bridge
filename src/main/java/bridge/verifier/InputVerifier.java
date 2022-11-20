package bridge.verifier;

public class InputVerifier {
    private static final String REGEX_BRIDGE_SIZE_RANGE = "^[3-9]{1}$|^1{1}[0-9]{1}$|^2{1}0{1}$";
    public static void BridgeSize(String bridgeSize){
        if (!bridgeSize.matches(REGEX_BRIDGE_SIZE_RANGE)){
            throw new IllegalArgumentException("[ERROR] 다리의 길이 입력 오류");
        }
    }
}
