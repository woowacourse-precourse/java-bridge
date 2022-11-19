package bridge.Util;

public class Validator {
    private Validator(){}

    public static int validateBridgeInput(String input){
        try{
            int result = Integer.parseInt(input);
            validateBridgeSize(result);
            return result;
        }
        catch (IllegalArgumentException E){
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public static String validateCommand(String input , STATE_CONSTANTS state){
        if(!state.getState().contains(input)){
            throw new IllegalArgumentException("[ERROR]");
        }
        return input;
    }

    private static void validateBridgeSize(int bridgeSize){
        if(bridgeSize > BRIDGE_CONSTANTS.MAX_BRIDGE_COUNT.getCount() || bridgeSize < BRIDGE_CONSTANTS.MIN_BRIDGE_COUNT.getCount()){
            throw new IllegalArgumentException("[ERROR]");
        }
    }

}
