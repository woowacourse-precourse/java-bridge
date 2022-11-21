package bridge.view;

import bridge.domain.MovingMap;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final OutputFormatter formatter;

    public OutputView(OutputFormatter formatter) {
        this.formatter = formatter;
    }

    private void println(String format, Object... args) {
        System.out.printf(format + "\n", args);
    }

    public void println() {
        println("");
    }

    public void printStartGame() {
        println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MovingMap movingMap) {
        String map = formatter.formatMovingMap(movingMap);
        println(map);
    }

    private void printIsClear(boolean isClear) {
        if (isClear) {
            println("게임 성공 여부: 성공");
        }
        if (!isClear) {
            println("게임 성공 여부: 실패");
        }
    }

    private void printTryCount(int tryCount) {
        println("총 시도한 횟수: %d", tryCount);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(MovingMap movingMap, boolean isClear, int tryCount) {
        println("최종 게임 결과");
        printMap(movingMap);
        println();
        printIsClear(isClear);
        printTryCount(tryCount);
    }
}
