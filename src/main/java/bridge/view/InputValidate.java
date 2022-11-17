package bridge.view;

public class InputValidate {
    public static boolean isNumber(String beforeChangeNum) {
        try {
            int num = Integer.parseInt(beforeChangeNum);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    public static boolean isInteger(String beforeChangeNum) {
        if(beforeChangeNum.contains(".")) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    public static boolean possibleBridgeSize(int num) {
        if(num < 3 || num > 20) {
            throw new IllegalArgumentException();
        }

        return true;
    }
}
