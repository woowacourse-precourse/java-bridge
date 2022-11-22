package bridge.view;

import bridge.service.constant.ChoiceResult;
import bridge.view.constant.BridgeStyle;
import bridge.view.constant.ChoiceResultStyle;
import bridge.view.constant.GameResultExpressions;
import bridge.view.constant.ResultPhrase;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static OutputView instance = new OutputView();

    private OutputView() {}

    public static OutputView getInstance() {
        return instance;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<ChoiceResult>> gameLog) {
        gameLog.stream().map(this::styleChoiceResult)
                .map(this::styleBridgeLine)
                .forEach(System.out::println);
    }

    private List<String> styleChoiceResult (List<ChoiceResult> logOfBridgeLine) {
        return logOfBridgeLine.stream()
                .map(ChoiceResultStyle::findStyleByChoiceResult)
                .collect(Collectors.toList());
    }

    private String styleBridgeLine (List<String> line) {
        return line.stream().collect(Collectors.joining(
                BridgeStyle.DELIMITER.get(),
                BridgeStyle.START.get(),
                BridgeStyle.END.get()
        ));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<ChoiceResult>> gameLog, boolean isGameCleared, int attemptCount) {
        System.out.println(ResultPhrase.TITLE.get());
        printMap(gameLog);
        insertLineBreak();
        System.out.println(createGameResultDisplay(isGameCleared));
        System.out.println(createAttemptCountDisplay(attemptCount));
    }

    private String createGameResultDisplay (boolean isGameCleared) {
        return String.format(
                ResultPhrase.RESULT.get(),
                GameResultExpressions.findExpressionByBooleanValue(isGameCleared)
        );
    }

    private String createAttemptCountDisplay (int attemptCount) {
        return String.format(ResultPhrase.ATTEMPT_COUNT.get(), attemptCount);
    }

    public void insertLineBreak() {
        System.out.println();
    }

    public void printErrorMessage (String errorMessage) {
        System.out.println(errorMessage);
        insertLineBreak();
    }
}
