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
            throw new IllegalArgumentException(ValidMessage.ValidLength.getMessage());
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
        enter = enter.replaceAll("[a-zA-Z]", "");
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
            throw new IllegalArgumentException(ValidMessage.ValidMove.getMessage());
        }
    }

    public static boolean isFinishNotRequiredLetter(String enter) {
        boolean isNotRequired = false;
        if (!enter.equals("R") && !enter.equals("Q")) {
            isNotRequired = true;
        }
        return isNotRequired;
    }

    public static void isEnterFinishValid(String enter) {
        if (isEnterEmpty(enter) || isEnterNotLetter(enter) || isFinishNotRequiredLetter(enter)) {
            throw new IllegalArgumentException(ValidMessage.ValidFinish.getMessage());
        }
    }
}
