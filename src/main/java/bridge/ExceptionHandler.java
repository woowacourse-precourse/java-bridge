package bridge;

public class ExceptionHandler {

    public boolean checkBridgeSize(String bridgeSize) {
        int bridgeInteger;
        try {
            bridgeInteger = convert2Integer(bridgeSize);
            checkBridgeSizeRange(bridgeInteger);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 다리 크기 입력입니다.");
            return false;
        }
        return true;
    }

    public int convert2Integer(String convertString) {
        int convertedInteger;
        try {
            convertedInteger = Integer.parseInt(convertString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return convertedInteger;
    }

    public void checkBridgeSizeRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkMoving(String moving) {
        try {
            if (!moving.equals("U") && !moving.equals("D")) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 이동입니다.");
            return false;
        }
        return true;
    }

    public boolean checkRetry(String retry) {
        try {
            if (!retry.equals("R") && !retry.equals("Q")) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 재시작 커멘드입니다.");
            return false;
        }
        return true;
    }
}
