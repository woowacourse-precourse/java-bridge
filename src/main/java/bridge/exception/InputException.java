package bridge.exception;

public class InputException {
    public void validateBridgeSize(String bridgeSize) {
        try {
             Integer.parseInt(bridgeSize);
        } catch (NumberFormatException exception) {
            System.out.println("[ERROR] 숫자가 아닌 값을 입력했습니다.");
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(bridgeSize) < 3 || Integer.parseInt(bridgeSize) > 20) {
            System.out.println("[ERROR] 3이상 20이하 범위의 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
}
