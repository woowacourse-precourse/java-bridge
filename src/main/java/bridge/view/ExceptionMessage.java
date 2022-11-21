package bridge.view;

public class ExceptionMessage {

    public static String isNumberMsg() {
        return "[ERROR] 입력하신 값이 숫자가 아닙니다.";
    }

    public static String isRangeNumberMsg() {
        return "[ERROR] 3이상 20이하의 숫자를 입력해야합니다.";
    }

    public static String isProperMsg() {
        return "[ERROR] U 또는 D를 입력해주세요";
    }

    public static String isReplyMsg() {
        return "[ERROR] R 또는 Q를 입력해주세요";
    }
}
