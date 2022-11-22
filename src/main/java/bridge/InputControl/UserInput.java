package bridge.InputControl;

public class UserInput {

    private static int userInputBridgeSize;
    private static String userInputString;


    public UserInput(int userInputBridgeSize) {
        this.userInputBridgeSize = userInputBridgeSize;
    }

    public static int getUserInputBridgeSize(){
        return userInputBridgeSize;
    }

    public UserInput(String userInputString) {
        this.userInputString = userInputString;
    }


}
