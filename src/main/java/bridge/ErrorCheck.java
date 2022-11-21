package bridge;

import bridge.exception.CheckBridgeLengthException;
import bridge.exception.CheckRetryQuitException;
import bridge.exception.CheckUpDownException;

public class ErrorCheck {
    private static final String ICON_UP = "U";
    private static final String ICON_DOWN = "D";
    private static final String ICON_RETRY = "R";
    private static final String ICON_QUIT = "Q";
    private static final int MININUM_BRIDGE_SIZE = 3;
    private static final int MAXINUM_BRIDGE_SIZE = 2;
    private static final int ZERO = 0;

    public static int stringToInt(String goToNumber) {
        int checkNumber = Integer.parseInt(goToNumber);
        if(checkNumber<MININUM_BRIDGE_SIZE)
            throw new CheckBridgeLengthException();
        if(checkNumber>MAXINUM_BRIDGE_SIZE)
            throw new CheckBridgeLengthException();
        return checkNumber;
    }

    public static void isItNumber(String haveToCheck) {
        for (int i = ZERO; i < haveToCheck.length(); i++)
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
