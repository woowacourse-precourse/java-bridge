package bridge;

import bridge.exception.CheckBridgeLengthException;
import bridge.exception.CheckRetryQuitException;
import bridge.exception.CheckUpDownException;

import static bridge.exception.CheckBridgeLengthException.CHECK_INPUT_RANGE;
import static bridge.exception.CheckRetryQuitException.ENTER_R_OR_Q;
import static bridge.exception.CheckUpDownException.ENTER_U_OR_D;

public class ErrorCheck {
    private static final String ICON_UP = "U";
    private static final String ICON_DOWN = "D";
    private static final String ICON_RETRY = "R";
    private static final String ICON_QUIT = "Q";
    private static final int MININUM_BRIDGE_SIZE = 3;
    private static final int MAXINUM_BRIDGE_SIZE = 20;
    private static final int ZERO = 0;

    public static int stringToInt(String goToNumber) {
        int checkNumber = ZERO;
        try {
            checkNumber = Integer.parseInt(goToNumber);
            if (checkNumber < MININUM_BRIDGE_SIZE)
                throw new CheckBridgeLengthException();
            if (checkNumber > MAXINUM_BRIDGE_SIZE)
                throw new CheckBridgeLengthException();
        } catch (NumberFormatException e) {
            System.out.println(CHECK_INPUT_RANGE);
            throw new CheckBridgeLengthException();
        }
        finally {
            return checkNumber;
        }
    }

    public static void isItNumber(String haveToCheck) {
        try {
            for (int i = ZERO; i < haveToCheck.length(); i++)
                Character.isDigit(haveToCheck.charAt(i));
        } catch (NumberFormatException e) {
            System.out.println(CHECK_INPUT_RANGE);
            throw new CheckBridgeLengthException();
        }
    }

    public static void isUpDown(String haveToCheck) {
        try {
            if (!haveToCheck.equals(ICON_UP) && !haveToCheck.equals(ICON_DOWN))
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(ENTER_U_OR_D);
            throw new CheckUpDownException();
        }
    }

    public static void isRestart(String haveToCheck) {
        try {
            if (!haveToCheck.equals(ICON_RETRY) && !haveToCheck.equals(ICON_QUIT))
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(ENTER_R_OR_Q);
            throw new CheckRetryQuitException();
        }
    }

}
