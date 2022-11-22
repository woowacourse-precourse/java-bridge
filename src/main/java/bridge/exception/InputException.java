package bridge.exception;

import bridge.view.enums.ExceptionString;

import java.util.regex.Pattern;

public class InputException {
    private static final Pattern IsOnlyNumber = Pattern.compile("^[0-9]*?");

    public void sizeIsNotNumber(String size) {
        if (size.isEmpty() ||
                !IsOnlyNumber.matcher(size).matches())
            throw new IllegalArgumentException(ExceptionString.NOT_NUMBER.getPrint());
    }

    public void minOrMaxSize(String size) {
        if (!(3 <= Integer.parseInt(size) && Integer.parseInt(size) <= 20) )
            throw new IllegalArgumentException(ExceptionString.MIN_OR_MAX.getPrint());
    }

    public void sizeException(String size) {
        sizeIsNotNumber(size);
        minOrMaxSize(size);
    }

    public void moveException(String move) {
        if (!(move.equals("U") || move.equals("D")))
            throw new IllegalArgumentException(ExceptionString.NOT_U_D.getPrint());
    }

    public void retryException(String retry) {
        if (!(retry.equals("Q") || retry.equals("R")))
            throw new IllegalArgumentException(ExceptionString.NOT_Q_R.getPrint());
    }
}
