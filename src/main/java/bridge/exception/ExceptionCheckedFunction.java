package bridge.exception;

import bridge.views.OutputView;

public interface ExceptionCheckedFunction {
    void run();

    static void retryWhenExceptionOrTryOnce(OutputView outputView, ExceptionCheckedFunction function)
            throws IllegalAccessException {
        int count = 0;
        while (true) {
            if (!retryExceptionChecker(outputView, function)) {
                return;
            }
            if (++count > 10) {
                throw new IllegalAccessException("10회 이상 잘못된 입력을 했습니다. 프로그램을 종료합니다.");
            }
        }
    }

    private static boolean retryExceptionChecker(OutputView outputView, ExceptionCheckedFunction function) {
        try {
            function.run();
            return false;
        } catch (IllegalArgumentException | IllegalStateException exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
        return true;
    }
}
