package bridge.exception;

import bridge.views.OutputView;

public interface ExceptionCheckedFunction {
    void run();

    static void retryWhenExceptionOrTryOnce(OutputView outputView, ExceptionCheckedFunction function) {
        while (true) {
            if(!retryExceptionChecker(outputView, function)){
                break;
            }
        }
    }

    private static boolean retryExceptionChecker (OutputView outputView, ExceptionCheckedFunction function){
        try {
            function.run();
            return false;
        } catch (IllegalArgumentException | IllegalStateException exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
        return true;
    }
}
