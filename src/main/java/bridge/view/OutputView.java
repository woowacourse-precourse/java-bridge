package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    static final String ERROR_HEADER = "[ERROR] ";

    public void printGameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_HEADER + errorMessage);
    }

    public void printMap(List<String> results) {
        for (String result : results) {
            System.out.printf("[%s]%n", result);
        }
    }

    public void printFinalMessage() {
        System.out.println("\n최종 게임 결과");
    }

    public void printResult(List<String> results) {
        System.out.printf("%n게임 성공 여부: %s", results.get(0));
        System.out.printf("%n총 시도한 횟수: %s", results.get(1));
    }
}
