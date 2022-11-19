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
        // constant로 대체
        if(num < 3 || num > 20) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    public static boolean possibleMovingSelect(String select) {
        // constant로 대체
        if(!select.equals("U") && !select.equals("D")) {
            throw new IllegalArgumentException();
        }

        return true;
    }
}
