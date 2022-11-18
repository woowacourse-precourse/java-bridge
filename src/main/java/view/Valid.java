package view;

public class Valid {
    public static boolean isLengthEmpty(String length) {
        boolean isEmpty = false;
        if (length.length() == 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

    public static boolean isLengthNotNumber(String length) {
        boolean isNumber = false;
        length = length.replaceAll("[0-9]", "");
        if (length.length() != 0) {
            isNumber = true;
        }
        return isNumber;
    }

    public static boolean isLengthNotInRange(String length) {
        boolean isRange = false;
        int numLength = Integer.parseInt(length);
        if (numLength < 3 || numLength > 20) {
            isRange = true;
        }
        return isRange;
    }

    public static void isLengthValid(String length) {
        if (isLengthEmpty(length) || isLengthNotNumber(length) || isLengthNotInRange(length)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3~20 중 하나인 숫자입니다.");
        }
    }

    public static boolean isEnterEmpty(String enter) {
        boolean isEmpty = false;
        if (enter.length() == 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

    public static boolean isEnterNotLetter(String enter) {
        boolean isNotLetter = false;
        enter = enter.replaceAll("[a-zA-z]", "");
        if (!enter.equals("")) {
            isNotLetter = true;
        }
        return isNotLetter;
    }

    public static boolean isEnterNotRequiredLetter(String enter) {
        boolean isNotRequired = false;
        if (!enter.equals("U") && !enter.equals("D")) {
            isNotRequired = true;
        }
        return isNotRequired;
    }

    public static void isEnterValid(String enter) {
        if (isEnterEmpty(enter) || isEnterNotLetter(enter) || isEnterNotRequiredLetter(enter)) {
            throw new IllegalArgumentException("입력시 U, D 중 하나를 입력해주세요.");
        }
    }

    public static boolean isLastEnterNotRequiredLetter(String enter) {
        boolean isNotRequired = false;
        if (!enter.equals("R") && !enter.equals("Q")) {
            isNotRequired = true;
        }
        return isNotRequired;
    }

    public static void isEnterFinishValid(String enter) {
        if (isEnterEmpty(enter) || isEnterNotLetter(enter) || isLastEnterNotRequiredLetter(enter)) {
            throw new IllegalArgumentException("입력시 Q, R 중 하나를 입력해주세요.");
        }
    }

}
