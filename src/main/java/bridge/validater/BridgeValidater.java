package bridge.validater;

public class BridgeValidater {
    public static boolean compareInputAndResult(String input, String result) {
        if(input.equals(result)) {
            return true;
        }
        return false;
    }
}
