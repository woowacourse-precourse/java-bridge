package bridge;

import bridge.Messages.Error;

public class Validate {
    static public void checkRange(int number){
        if (number > 20 || number < 3)
            throw new IllegalArgumentException(Error.INVALID_RANGE.getMessage());
    }

    static public void checkLetter(String check, String opt1, String opt2){
        if (!check.equals(opt1) && !check.equals(opt2))
            throw new IllegalArgumentException(Error.INVALID_LETTER.getMessage());
    }
}
