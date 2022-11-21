package bridge.util;

import bridge.BridgeMaker;

public class Converter {
    public static int StringToInteger(String number){
        return Integer.parseInt(number);
    }

    public static String NumberToCharacter(int bridgeNumber){
        if (bridgeNumber == BridgeMaker.getUpBridgeNumber()) {
            return BridgeMaker.getUpBridgeCharacter();
        } else if (bridgeNumber == BridgeMaker.getDownBridgeNumber()) {
            return BridgeMaker.getDownBridgeCharacter();
        }

        return null;
    }
}
