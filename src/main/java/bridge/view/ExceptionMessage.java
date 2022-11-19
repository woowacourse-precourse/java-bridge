package bridge.view;

public class ExceptionMessage {

    public static String isProper;

    public static String isNumberMsg() {
        return "입력하신 값이 숫자가 아닙니다.";
    }

    public static String isRangeNumberMsg() {
        return "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    }

    public static String isProperMsg() {
        return "U 또는 D를 입력해주세요";
    }
}
