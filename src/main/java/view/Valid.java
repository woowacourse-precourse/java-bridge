package view;

public class Valid {
    public static boolean isLengthEmpty(String length) {
        boolean isEmpty = true;
        if (length.length() == 0) {
            isEmpty = false;
        }
        return isEmpty;
    }

    public static boolean isLengthNotNumber(String length) {
        boolean isNumber = true;
        length = length.replaceAll("[0-9]", "");
        if (length.length() != 0) {
            isNumber = false;
        }
        return isNumber;
    }

    public static boolean isLengthNotInRange(String length) {
        boolean isRange = true;
        int numLength = Integer.parseInt(length);
        if (numLength < 3 || numLength > 20) {
            isRange = false;
        }
        return isRange;
    }

    public static void isLengthValid(String length) {
        if (isLengthEmpty(length) || isLengthNotNumber(length) || isLengthNotInRange(length)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3~20 중 하나인 숫자입니다.");
        }
    }

}
