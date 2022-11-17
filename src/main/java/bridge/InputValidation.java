package bridge;

import static bridge.GameRetry.Q;
import static bridge.GameRetry.R;
import static bridge.MoveDirection.D;
import static bridge.MoveDirection.U;
import static bridge.BridgeLength.MAX;
import static bridge.BridgeLength.MIN;

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

    public boolean isValidInputOfBridgeLength(String bridgeLength){
        if(!isNumber(bridgeLength))
            return false;

        if(!isValidRange(Integer.parseInt(bridgeLength)))
            return false;

        return true;
    }

    public boolean isValidDirection(String moveDirection){
        if(U.equals(moveDirection) || D.equals(moveDirection))
            return true;
        return false;
    }

    public boolean isValidGameRetryInput(String gameRetryInput){
        if(R.equals(gameRetryInput) || Q.equals(gameRetryInput))
            return true;
        return false;
    }

}
