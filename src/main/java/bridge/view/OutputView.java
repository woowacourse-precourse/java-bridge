package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeGame bridgeGame) {
        List<String> bridge = bridgeGame.getBridge();
        Player player = bridgeGame.getPlayer();
        int currentPosition = player.getCurrentPosition();
        boolean isMoving = player.getMoving();
        List<String> upperLine = drawUpperLine(bridge, currentPosition, isMoving);
        List<String> lowerLine = drawLowerLine(bridge, currentPosition, isMoving);
        printOneLine(upperLine);
        printOneLine(lowerLine);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame) {
        System.out.println("게임 종료");
        System.out.println("retryCount = " + bridgeGame.getPlayer().getTryCount());
    }

    private static List<String> drawUpperLine(List<String> bridge, int currentPosition, boolean isMoving) {
        List<String> upperLine = new ArrayList<>();
        for (int i = 0; i < currentPosition; i++) {
            String correctDirection = bridge.get(i);
            drawCell(upperLine, "U",correctDirection);
        }
        if (!isMoving) {
            drawFailedCell(upperLine, "U", bridge.get(currentPosition));
        }
        return upperLine;
    }

    private static List<String> drawLowerLine(List<String> bridge, int currentPosition, boolean isMoving) {
        List<String> lowerLine = new ArrayList<>();
        for (int i = 0; i < currentPosition; i++) {
            String correctDirection = bridge.get(i);
            drawCell(lowerLine, "D",correctDirection);
        }
        if (!isMoving) {
            drawFailedCell(lowerLine, "D", bridge.get(currentPosition));
        }
        return lowerLine;
    }

    private static void drawCell(List<String> line, String lineType, String correctDirection) {
        if (correctDirection.equals(lineType)) {
            line.add("O");
            return;
        }
        line.add(" ");
    }

    private static void drawFailedCell(List<String> line, String lineType, String correctDirection) {
        if (!correctDirection.equals(lineType)) {
            line.add("X");
            return;
        }
        line.add(" ");
    }

    private static void printOneLine(List<String> line) {
        System.out.println("[" + String.join(" | ", line) + "]");
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}
