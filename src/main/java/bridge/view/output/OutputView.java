package bridge.view.output;

import bridge.view.console.Printer;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String NEW_LINE = "\n";

    public void printStart() {
        Printer.printLine(OutputMessage.START);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> bridgeMap) {
        bridgeMap
                .forEach(bridge ->
                        Printer.printLine(OutputFormatter.format(bridge)));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(
            List<List<String>> finalBridgeMap,
            String successOrFailure,
            String trial
    ) {
        Printer.printLine(OutputMessage.RESULT);
        printMap(finalBridgeMap);

        Printer.print(NEW_LINE);
        Printer.printLine(OutputMessage.SUCCESS_OR_FAILURE.format(successOrFailure));
        Printer.printLine(OutputMessage.TRIAL.format(trial));
    }
}
