package bridge;

import bridge.exception.CheckBridgeLengthException;
import bridge.exception.CheckRetryQuitException;

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
    private static final int ERROR = 99;

    public static int stringToInt(String goToNumber) {
        int checkNumber = ZERO;
        try {
            checkNumber = Integer.parseInt(goToNumber);
            if (checkNumber < MININUM_BRIDGE_SIZE) {
                checkNumber = ZERO;
                System.out.println(CHECK_INPUT_RANGE);
            }
            if (checkNumber > MAXINUM_BRIDGE_SIZE) {
                checkNumber = ZERO;
                System.out.println(CHECK_INPUT_RANGE);
            }
        } catch (NumberFormatException e) {
            System.out.println(CHECK_INPUT_RANGE);
            throw new CheckBridgeLengthException();
        } finally {
            return checkNumber;
        }
    }

    public static int isItNumber(String haveToCheck) {
        try {
            for (int i = ZERO; i < haveToCheck.length(); i++)
                Character.isDigit(haveToCheck.charAt(i));
        } catch (NumberFormatException e) {
            System.out.println(CHECK_INPUT_RANGE);
            return ERROR;
        }
        return ZERO;
    }

    public static int isUpDown(String haveToCheck) {
        try {
            if (!haveToCheck.equals(ICON_UP) && !haveToCheck.equals(ICON_DOWN)) {
                System.out.println(ENTER_U_OR_D);
                return ERROR;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ENTER_U_OR_D);
        }
        return ZERO;
    }

    public static int isRestart(String haveToCheck) {
        try {
            if (!haveToCheck.equals(ICON_RETRY) && !haveToCheck.equals(ICON_QUIT)) {
                System.out.println(ENTER_R_OR_Q);
                return ERROR;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ENTER_R_OR_Q);
            throw new CheckRetryQuitException();
        }
        return ZERO;
    }

}
