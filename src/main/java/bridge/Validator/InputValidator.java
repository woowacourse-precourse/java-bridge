package bridge.Validator;

public class InputValidator {

    public static void checkBridgeSize(String size) {
        if (!(checkOnlyNumber(size))) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
        if (!(checkBoundaryNumber(size))) {
            throw new IllegalArgumentException("[ERROR] 범위가 아닙니다.");
        }
    }

    public static boolean checkBoundaryNumber(String size) {
        Integer bridgeSize = Integer.parseInt(size);
        if (bridgeSize < 3 || bridgeSize > 20) {
            return false;
        }
        return true;
    }

    public static boolean checkOnlyNumber(String size) {
        try {
            Integer.parseInt(size);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void checkMoving(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))){
            throw new IllegalArgumentException("[ERROR] 유효한 값이 아닙니다.");
        }
    }

    public static void checkRetry(String retryInput) {
        if(!(retryInput.equals("Q") || retryInput.equals("R"))){
            throw new IllegalArgumentException("[ERROR] 유효한 값이 아닙니다.");
        }
    }
}
