package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String RESTART_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String END_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_OR_FAILURE = "게임 성공 여부: %s";
    private static final String COUNT_MESSAGE = "총 시도한 횟수: %d";

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printRestart() {
        System.out.println(RESTART_MESSAGE);
    }

    public void printEndGame() {
        System.out.println(END_MESSAGE);
    }

    public void printSuccessOrFailure(String result) {
        System.out.printf(SUCCESS_OR_FAILURE, result);
        System.out.println();
    }

    public void printCount(int count) {
        System.out.printf(COUNT_MESSAGE, count);
        System.out.println();
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> bridge) {
        bridge.forEach(this::printBridge);
    }

    private void printBridge(List<String> row) {
        System.out.println("[" + String.join("|", row) + "]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> bridge, String result, int count) {
        printEndGame();
        printMap(bridge);
        printSuccessOrFailure(result);
        printCount(count);
    }
}
