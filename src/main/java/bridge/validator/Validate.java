package bridge.validator;

public class Validate {

    public static void vaildateBridgeSize(String bridgeSizeInput) {
        for (int i = 0; i < bridgeSizeInput.length(); i++) {
            if (!Character.isDigit(bridgeSizeInput.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }

    }
    public static void vaildateCheckRetry(String command){
        if(!command.equals("Q") && !command.equals("R")){
            throw new IllegalArgumentException();
        }

    }
}
