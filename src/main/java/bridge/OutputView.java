package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String STARTING_TEXT = "다리 건너기 게임을 시작합니다.";
    private static final String RESULT_TEXT = "최종 게임 결과";
    private static final String SUCCESS_TEXT = "게임 성공 여부: 성공";
    private static final String FAILURE_TEXT = "게임 성공 여부: 실패";
    private static final String TRY_COUNT_TEXT = "총 시도한 횟수: ";

    public void printStartingText() {
        System.out.println(STARTING_TEXT);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge) {
        int bridgeSize = bridge.size() / 2;

        for (int i = 0; i < bridgeSize * 2; i += 3) {
            System.out.printf("[ ");
            for (int j = 0; j < bridgeSize - 1; j++) {
                System.out.printf(bridge.get(i + j) + " | ");
            }
            System.out.println(bridge.get(i + bridgeSize - 1) + " ]");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, boolean result, int tryCount) {
        System.out.println(RESULT_TEXT);
        printMap(bridge);
        if (result) {
            System.out.println(SUCCESS_TEXT);
        } else {
            System.out.println(FAILURE_TEXT);
        }
        System.out.println(TRY_COUNT_TEXT + tryCount);
    }
}
