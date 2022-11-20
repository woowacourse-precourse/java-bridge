package bridge.validation;

public class ReadBridgeSizeValidation {
    public void validate(String inputBridgeSize) {
        validateInputIsInteger(inputBridgeSize);
        validateSizeRange(inputBridgeSize);
    }

    public void validateInputIsInteger(String inputBridgeSize) {
        try {
            Integer.parseInt(inputBridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이를 숫자로 입력해주세요.");
        }
    }

    public void validateSizeRange(String inputBridgeSize) {
        int bridgeSize = Integer.parseInt(inputBridgeSize);

        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3이상, 20이하여야 합니다.");
        }
    }

}
