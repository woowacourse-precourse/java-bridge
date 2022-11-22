package bridge.exception;

import bridge.view.console.Printer;

public class ExceptionHandler {
    public static void throwException(
            RuntimeException exception,
            ExceptionMessage exceptionMessage
    ) {
        Printer.printLine(exceptionMessage);
        throw exception;
    }
}
