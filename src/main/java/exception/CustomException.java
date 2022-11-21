package exception;

public class CustomException {

    public boolean checkBridgeSize(String input) {
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize >= 3 && bridgeSize <= 20) return true;
        return false;
    }

    public boolean checkMove(String input) {
        return true;
    }
}
