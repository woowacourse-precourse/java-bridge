package bridge.exception;

public class BridgeException {
    private static final String REGEX = "^[0-9]+";
    public void validateBridgeSizeFormat(String size) {
        if (!size.matches(REGEX)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자만 입력 가능합니다.");
        }
    }
    public void validateBridgeSizeLange(String size) {
        if (Integer.parseInt(size) < 3 || Integer.parseInt(size) > 20){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
