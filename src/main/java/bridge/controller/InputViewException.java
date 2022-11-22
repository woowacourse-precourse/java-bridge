package bridge.controller;

public class InputViewException {
    public static final String error01 = "[ERROR] 01 사용자가 아무것도 입력하지 않았습니다.";
    public static final String error02 = "[ERROR] 02 사용자가 숫자 이외의 문자를 입력하였습니다.";
    public static final String error03 = "[ERROR] 03 숫자의 범위가 올바르지 않습니다. (3 이상, 20 이하)";
    public static final String error04 = "[ERROR] 04 잘못된 칸을 입력하였습니다. (위: U, 아래: D)";
    public static final String error05 = "[ERROR] 05 잘못된 문자를 입력하였습니다. (재시도: R, 종료:  Q)";


    /**
     * Helper method to catch a NumberFormatException and change it into a IllegalArgumentException
     *
     * @param str String to confirm if integer or not
     * @return false if String is an integer, true otherwise
     */
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }



    private static void error01Check(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(error01);
        }
    }

    private static void error02Check(String input) {
        if (isInteger(input)) {
            throw new IllegalArgumentException(error02);
        }
    }

    private static void error03Check(String input) {
        if ((Integer.parseInt(input) < 3) || (Integer.parseInt(input) > 20)) {
            throw new IllegalArgumentException(error03);
        }
    }


    private static void error04Check(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(error04);
        }
    }

    private static void error05Check(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(error05);
        }
    }



    public void readBridgeSizeException(String input) {
        error01Check(input);
        error02Check(input);
        error03Check(input);
    }


}
