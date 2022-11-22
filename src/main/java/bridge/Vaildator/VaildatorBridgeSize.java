package bridge.Vaildator;

public class VaildatorBridgeSize {

    private static String userInputBridgeString;
    public static int userInputBridgeSize;

    public VaildatorBridgeSize(String userInputBridgeString){
        this.userInputBridgeString = userInputBridgeString;

        validate();
    }

    private void validate() {
        integerValidate();
        rangeValidate();
    }
    private void integerValidate() {
        if (!userInputBridgeString.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }

    }

    private void rangeValidate() {
        userInputBridgeSize = Integer.parseInt(userInputBridgeString);

        if (! (userInputBridgeSize >=3 && userInputBridgeSize<=20 )) {
            throw new IllegalArgumentException("[ERROR] 3~20사이의 값을 입력해주세요.");
        }

    }




}
