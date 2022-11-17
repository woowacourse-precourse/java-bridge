package bridge;


import static bridge.GameRetry.Q;
import static bridge.GameRetry.R;
import static bridge.MoveDirection.D;
import static bridge.MoveDirection.U;
import static bridge.BridgeLength.MIN;
import static bridge.BridgeLength.MAX;

public class InputValidation {

    public boolean isNumber(String bridgeLength){
        try {
            Integer.parseInt(bridgeLength);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isValidRange(int bridgeLength) {
        if (bridgeLength >= MIN.bridgeLength && bridgeLength <= MAX.bridgeLength)
            return true;
        return false;
    }

}
