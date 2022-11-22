package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final static String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final static String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private final static String SUCCESS_MESSAGE = "게임 성공 여부: 성공";
    private final static String FAIL_MESSAGE = "게임 성공 여부: 실패";
    private final static String GAME_COUNT_MESSAGE = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> resultBridge) {
        printEachBridge(resultBridge, 0);
        printEachBridge(resultBridge, 1);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> resultBridge, int gameCount, boolean isSuccess) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(resultBridge);
        if (isSuccess) {
            System.out.println(SUCCESS_MESSAGE);
            System.out.println(GAME_COUNT_MESSAGE + gameCount);
            return;
        }
        System.out.println(FAIL_MESSAGE);
        System.out.println(GAME_COUNT_MESSAGE + gameCount);
    }

    /**
     * 게임 시작 메시지를 출력한다.
     */
    public void printStartMessage() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리 칸을 출력한다.
     * 0은 위 칸 1은 아래 칸
     */
    public void printEachBridge(List<String> resultBridge, int upOrDown) {
        System.out.print("[ ");
        for (int i = upOrDown; i < resultBridge.size(); i += 2) {
            System.out.print(resultBridge.get(i));
            if (i + 2 < resultBridge.size()) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");
    }
}
