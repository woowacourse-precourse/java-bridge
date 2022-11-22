package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String RESULT_SUCCESS_FAIL_MESSAGE = "게임 성공 여부: ";
    private static final String TOTAL_TRY_COUNT_MESSAGE = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> map) {
        System.out.print("[");
        for (int index = 0; index < map.size(); index++) {
            System.out.print(" " + map.get(index) + " ");
            if (index < map.size() - 1) {
                System.out.print("|");
            }
        }
        System.out.println("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String statusSuccessFail, Integer tryCount) {
        System.out.println();
        System.out.println(RESULT_SUCCESS_FAIL_MESSAGE + statusSuccessFail);
        System.out.println(TOTAL_TRY_COUNT_MESSAGE + tryCount);
    }
}
