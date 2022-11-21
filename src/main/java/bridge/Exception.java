package bridge;


import java.util.NoSuchElementException;

public class Exception {
    private static final String ERROR_MESSAGE = "[ERROR]";
    public static int checkBridgeSize (String BridgeNumber){
        try {
            Double.parseDouble(BridgeNumber);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE + "다리 길이는 숫자가 입력되어야 합니다.");
            throw new NoSuchElementException();
        }
        if( Integer.valueOf(BridgeNumber) > 20 || Integer.valueOf(BridgeNumber)< 3){
            throw new IllegalArgumentException(ERROR_MESSAGE + "다리 길이는 3부터 20의 숫자가 입력되어야 합니다.");
        }
        return Integer.valueOf(BridgeNumber);
    }
    public static void checkMoving(String move){
        if(!(move.equals("U"))&&!(move.equals("D"))){
            throw new IllegalArgumentException(ERROR_MESSAGE + "U나 D를 입력하셔야 합니다.");
        }
    }
    public static void checkCommand(String command){
        if(!(command.equals("R"))&&!command.equals("Q")){
            throw new IllegalArgumentException(ERROR_MESSAGE + "R 혹은 Q를 입력하셔야 합니다.");
        }
    }
}
