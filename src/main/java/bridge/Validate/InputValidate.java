package bridge.Validate;

import bridge.Message.Error;

public class InputValidate {
    public void validateBridgeSize(String length) {
        try {
            int bridgeSize = Integer.parseInt(length);
            if (bridgeSize < 3 || bridgeSize > 20) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.WRONG_BRIDGE_NUMBER);
        }
    }

    public void validateMoving(String direction){
        if(direction != "U" || direction != "D"){
            throw new IllegalArgumentException(Error.WRONG_MOVING_DISTANCE);
        }
    }
}
