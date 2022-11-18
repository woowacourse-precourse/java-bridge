package bridge.utils;// @ author ninaaano

import bridge.exception.Exception;

public class Validator {

    public static int validateBridgeLength(String bridgeLength){
        return Exception.checkBridgeLength(Exception.checkString(bridgeLength));
    }
    
}
