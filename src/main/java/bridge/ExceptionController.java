package bridge;

public class ExceptionController {
    public ExceptionController() {
    }
    public boolean validateBridgeLengthIsNum(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public void validateBridgeLength(String num) {
        if (!this.validateBridgeLengthIsNum(num)) {
            throw new IllegalArgumentException("[ERROR] 다리길이는 숫자로 입력해주세요");
        }
    }
}
