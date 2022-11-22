package bridge;

import java.util.List;
import java.util.Objects;

public class Output {
    private static OutputView outputView;

    private Output() {

    }

    /**
     * 현재 다리 상태를 출력한다.
     */
    public static void printMap(List<String> bridge, List<String> move) {
        getInstance().printMap(bridge, move);
    }

    /**
     * 최종 결과를 출력한다.
     */
    public static void printGameResult(List<String> bridge, List<String> move, int count) {
        getInstance().printResult(bridge, move, count);
    }

    public static void printGameStart() {
        getInstance().printGameStartMessage();
    }

    public static void printReadBridgeSize() {
        getInstance().printInputBridgeSizeMessage();
    }

    public static void printReadMove() {
        getInstance().printInputMoveMessage();
    }

    public static void printNewLine() {
        getInstance().printNewLine();
    }

    public static void printGameReStart() {
        getInstance().printRestartMessage();
    }

    /**
     * @return 싱글턴 {@link OutputView} 객체
     * <p>
     * {@link OutputView} 싱글턴 객체를 생성해 반환한다.
     */
    private static OutputView getInstance() {
        if (Objects.isNull(outputView)) {
            outputView = new OutputView();
        }
        return outputView;
    }
}
