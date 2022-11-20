package bridge.validation;

public class ReadBridgeSizeValidation {
    public void validateInputIsInteger(String inputBridgeSize) {
        try {
            Integer.parseInt(inputBridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이를 숫자로 입력해주세요.");
        }
    }
}
