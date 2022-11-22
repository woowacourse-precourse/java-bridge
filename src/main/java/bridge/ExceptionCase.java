package bridge;

public class ExceptionCase {
    public int validateBridgeSizeIsInteger(String bridgeSizeString) {
        try {
            return Integer.parseInt(bridgeSizeString);
        }
        catch (NumberFormatException error){
            System.out.println("[ERROR] 숫자는 정수형으로 하나만 입력하시야 합니다.\n");
            return new InputView().readBridgeSize();
        }
    }


}
