package bridge.validator;

public class Validate {

    public static void validateBridgeSize(String bridgeSizeInput) {
        for (int i = 0; i < bridgeSizeInput.length(); i++) {
            if (!Character.isDigit(bridgeSizeInput.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }

    }
    public static void validateCheckRetry(String command){
        if(!command.equals("Q") && !command.equals("R")){
            throw new IllegalArgumentException();
        }

    }
    public static void validateCheckMove(String userMove){
        if(!userMove.equals("U") && !userMove.equals("D")){
            throw new IllegalArgumentException();
        }
    }
}
