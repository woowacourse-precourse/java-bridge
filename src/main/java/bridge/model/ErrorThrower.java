package bridge.model;

import java.util.logging.Logger;

public class ErrorThrower {
    public static final String ERROR_BRIDGE_SIZE = "[ERROR] 3-20사이의 숫자가 아닙니다.";
    public static final String ERROR_MOVING = "[ERROR] Moving 문자를 잘못 입력하셨습니다.";
    public static final String ERROR_RETRY = "[ERROR] Retry 문자를 잘못 입력하셨습니다.";

    private static final Logger logger = Logger.getLogger(ErrorThrower.class.getName());

    public static void throwError(String errorMessage) {
        try {
            throw new IllegalArgumentException(errorMessage);
        } catch (IllegalArgumentException e) {
            logger.warning(errorMessage);
            System.out.println(e.getMessage());
        }
    }
}
