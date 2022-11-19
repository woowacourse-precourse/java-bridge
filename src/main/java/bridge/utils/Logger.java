package bridge.utils;

/**
 * 사용자가 아닌, 개발자 측에서 확인할 메시지를 로깅합니다.
 */
public class Logger {

    private static final String ERROR_BASE = "[FATAL] ";

    public static void error(String message) {
        System.out.println(ERROR_BASE + message);
    }
}
