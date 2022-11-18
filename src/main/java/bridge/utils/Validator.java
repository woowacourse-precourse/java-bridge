package bridge.utils;// @ author ninaaano

import bridge.exception.Exception;

public class Validator {

    public static int validateBridgeLength(String bridgeLength){
        return Exception.checkBridgeLength(Exception.checkString(bridgeLength));
    }

    public static String validateMove(String userInput){
        return Exception.checkMove(userInput);
    }

    public static String validateRestartOrQuit(String userInput){
        return Exception.checkRestartOrQuit(userInput);
    }
}
