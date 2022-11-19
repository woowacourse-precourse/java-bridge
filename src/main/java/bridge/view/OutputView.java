package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String PRINT_END = "최종 게임 결과";
    private static final String PRINT_RESULT = "게임 성공 여부: ";
    private static final String PRINT_COUNT = "총 시도한 횟수: ";
    private static final String PRINT_START = "다리 건너기 게임을 시작합니다.";

    public OutputView() {

    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String[][] realTimeMap) {
        for (int row = 0; row < realTimeMap.length; row++) {
            for (int column = 0; column < realTimeMap[0].length; column++) {
                System.out.print(realTimeMap[row][column]);
            }
            System.out.println();
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, int count, String[][] realTimeMap) {
        System.out.println();
        System.out.println(PRINT_END);
        printMap(realTimeMap);
        System.out.println();
        System.out.println(PRINT_RESULT + result);
        System.out.println(PRINT_COUNT + count);
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printStartMessage() {
        System.out.println(PRINT_START);
    }
}
