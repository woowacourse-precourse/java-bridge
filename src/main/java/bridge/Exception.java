package bridge;

public class Exception {
    public static int checkBridgeSize (String BridgeNumber){
        if(BridgeNumber == null || BridgeNumber.matches("-?\\d+")){
            throw new IllegalArgumentException();
        }
        if( Integer.valueOf(BridgeNumber) > 20 || Integer.valueOf(BridgeNumber)< 3){
            throw new IllegalArgumentException();
        }
        return Integer.valueOf(BridgeNumber);
    }
    public static void checkMoving(String move){
        if(!(move.equals("U")&&move.equals("D"))){
            throw new IllegalArgumentException();
        }
    }
}
