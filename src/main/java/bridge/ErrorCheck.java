package bridge;

import bridge.exception.CheckBridgeLengthException;
import bridge.exception.CheckRetryQuitException;
import bridge.exception.CheckUpDownException;

public class ErrorCheck {
    private static final String ICON_UP = "U";
    private static final String ICON_DOWN = "D";
    private static final String ICON_RETRY = "R";
    private static final String ICON_QUIT = "Q";

    public static int stringToInt(String goToNumber) {
        int checkNumber = Integer.parseInt(goToNumber);
        if(checkNumber<3)
            throw new CheckBridgeLengthException();
        if(checkNumber>20)
            throw new CheckBridgeLengthException();
        return checkNumber;
    }

    public static void isItNumber(String haveToCheck) {
        for (int i = 0; i < haveToCheck.length(); i++)
            if (!Character.isDigit(haveToCheck.charAt(i)))
                throw new CheckBridgeLengthException();
    }

    public static void isUpDown(String haveToCheck) {
        if (!haveToCheck.equals(ICON_UP) && !haveToCheck.equals(ICON_DOWN))
            throw new CheckUpDownException();
    }

    public static void isRestart(String haveToCheck) {
        if (!haveToCheck.equals(ICON_RETRY) && !haveToCheck.equals(ICON_QUIT))
            throw new CheckRetryQuitException();
    }

}
