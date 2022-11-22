package bridge;

public class VaildatorBridgeSize {

    private static String userInputBridgeSize;

    public VaildatorBridgeSize(String userInputBridgeSize){
        this.userInputBridgeSize = userInputBridgeSize;

        validate();


    }

    private void validate() {
        integerValidate();
        rangeValidate();
    }
    private void integerValidate() {
        if (!userInputBridgeSize.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }

    }

    private void rangeValidate() {
        int bridgeSizeInteger = Integer.parseInt(userInputBridgeSize);

        if (! (bridgeSizeInteger >=3 && bridgeSizeInteger<=20 )) {
            throw new IllegalArgumentException("[ERROR] 3~20사이의 값을 입력해주세요.");
        }

    }




}
