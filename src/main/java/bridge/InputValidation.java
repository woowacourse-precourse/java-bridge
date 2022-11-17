package bridge;


import static bridge.GameRetry.Q;
import static bridge.GameRetry.R;
import static bridge.MoveDirection.D;
import static bridge.MoveDirection.U;

public class InputValidation {

    public boolean isNumber(String bridgeLength){
        try {
            Integer.parseInt(bridgeLength);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}
