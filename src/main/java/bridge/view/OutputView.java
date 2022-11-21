package bridge.view;

import static bridge.domain.BridgeGame.DOWN_BRIDGE;
import static bridge.domain.BridgeGame.UP_BRIDGE;

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

    public void printEnterBridgeSize() {
        println("다리의 길이를 입력해주세요.");
    }

    public void printEnterMoving() {
        println("이동할 칸을 선택해주세요. (위: %s, 아래: %s)", UP_BRIDGE, DOWN_BRIDGE);
    }

    public void printEnterGameCommand() {
        final String RETRY = "R";
        final String QUIT = "Q";

        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)", RETRY, QUIT);
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

    public void printError(String message) {
        println("[ERROR] %s", message);
    }
}
