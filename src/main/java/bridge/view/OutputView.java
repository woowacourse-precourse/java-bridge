package bridge.view;

import bridge.view.constants.OutputFormat;
import bridge.view.constants.OutputMessage;
import bridge.view.constants.ResultKeyword;
import bridge.view.template.MovingMap;
import bridge.view.validator.ArgumentValidator;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 클래스
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(MovingMap movingMap) {
        ConsolePrinter.printLine(movingMap + "\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult(boolean hasFailed, int trialCount) {
        ConsolePrinter.printFormattedLine(OutputFormat.RESULT_HAS_SUCCEED, ResultKeyword.convertValueByKey(!hasFailed));
        ConsolePrinter.printFormattedLine(OutputFormat.RESULT_TRIAL_COUNT, trialCount);
    }

    public void printMessage(OutputMessage message) {
        ConsolePrinter.printLine(message.getValue());
    }

    public void printGameErrorMessage(String errorMessage) {
        ConsolePrinter.printFormattedLine(OutputFormat.ERROR_GAME_MESSAGE, errorMessage);
    }

    public void printUserInputErrorMessage(String errorMessage) {
        ConsolePrinter.printFormattedLine(OutputFormat.ERROR_USER_INPUT_MESSAGE, errorMessage);
    }

    /**
     * 콘솔 창에 주어진 정보를 출력하는 내부 클래스
     */
    private static class ConsolePrinter {

        static void printLine(Object content) throws NullPointerException {
            ArgumentValidator.validateContentNotNull(content);
            System.out.println(content);
        }

        static void printFormattedLine(OutputFormat format, Object content) throws NullPointerException {
            ArgumentValidator.validateContentNotNull(content);
            ArgumentValidator.validateFormatValueNotNull(format);
            System.out.printf(format.getValue() + "\n", content);
        }
    }
}
