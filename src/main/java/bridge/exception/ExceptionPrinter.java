package bridge.exception;

import java.lang.reflect.InvocationTargetException;

public class ExceptionPrinter {
    public static void printException(String message) {
        System.out.println("[ERROR] " + message + " 다시 입력해주세요.");
    }
    public static void printExceptionWithException(Exception e) {
        if(e.getClass().equals(InvocationTargetException.class)) {
            String message = ((InvocationTargetException) e).getTargetException().getMessage();
            printException(message);
            return;
        }
        printException(ExceptionMessage.UNKNOWN_ERROR.getMessage());
    }
}
