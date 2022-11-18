package bridge.utils;

public class Validator {
    public static void checkIsNumber(String number) {
        String numberRegularExpression = "^[0-9]+$";
        boolean isNotNumber = !number.matches(numberRegularExpression);
        if (isNotNumber) {
            throw new IllegalArgumentException("다리 길이는 숫자입니다.");
        }
    }

    public static void checkIsSide(String moveSide) {
        String sideRegularExpression = "^[UD]$";
        boolean isNotSide = !moveSide.matches(sideRegularExpression);
        if (isNotSide) {
            throw new IllegalArgumentException("선택할 수 있는 칸은 위(U) 또는 아래(D) 입니다.");
        }
    }

    public static void checkIsRetry(String retry) {
        String retryRegularExpression = "^[RQ]$";
        boolean isNotRetry = !retry.matches(retryRegularExpression);
        if (isNotRetry) {
            throw new IllegalArgumentException("선택할 수 있는 값은 재시도(R) 또는 종료(Q) 입니다.");
        }
    }
}
