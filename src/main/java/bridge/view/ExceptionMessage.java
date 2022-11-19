package bridge.view;

public class ExceptionMessage {

    public static String isProper;

    public static String isNumberMsg() {
        return "입력하신 값이 숫자가 아닙니다.";
    }

    public static String isRangeNumberMsg() {
        return "3이상 20이하의 숫자를 입력해야합니다.";
    }

    public static String isProperMsg() {
        return "U 또는 D를 입력해주세요";
    }
}
