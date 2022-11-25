package bridge.view;

import java.util.List;

public class OutputView {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_OR_FAIL_MESSAGE = "게임 성공 여부: ";
    private static final String ATTEMPT_MESSAGE = "총 시도한 횟수: ";

    public void printStart() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    public void printMap(List<String> map) {
        for (String bridge : map) {
            System.out.println(bridge);
        }
        System.out.println();
    }

    public void printResult(List<String> maps, List<String> result) {
        System.out.println(RESULT_MESSAGE);
        printMap(maps);
        System.out.println(SUCCESS_OR_FAIL_MESSAGE + result.get(0));
        System.out.println(ATTEMPT_MESSAGE + result.get(1));
    }

    public void printError(String message) {
        System.out.println(message);
        System.out.println();
    }
}
