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


}
