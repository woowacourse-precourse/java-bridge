package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_RESULT = "최종 게임 결과";
    private static final String SUCCESS_OR_NOT = "게임 성공 여부: ";
    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";
    private static final String TRY_COUNT = "총 시도한 횟수: ";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String CROSSABLE_SIGN = "O";
    private static final String UNABLE_TO_CROSS_SIGN = "X";
    private static final String BLANK = " ";
    private static final String DELIMITER = " | ";
    private static final String BRIDGE_PREFIX = "[ ";
    private static final String BRIDGE_SUFFIX = " ]";
    private static final String ERROR_PREFIX = "[ERROR]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeGame bridgeGame) {
        List<String> bridge = bridgeGame.getBridge();
        Player player = bridgeGame.getPlayer();
        List<String> upperLine = drawUpperLine(bridge, player);
        List<String> lowerLine = drawLowerLine(bridge, player);
        printOneLine(upperLine);
        printOneLine(lowerLine);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame) {
        System.out.println(GAME_RESULT);
        printMap(bridgeGame);
        System.out.print(SUCCESS_OR_NOT);
        printSuccessOrFailure(bridgeGame.isReached());
        System.out.print(TRY_COUNT);
        System.out.println(bridgeGame.getPlayer().getTryCount());
    }

    private static List<String> drawUpperLine(List<String> bridge, Player player) {
        List<String> upperLine = new ArrayList<>();
        for (int i = 0; i < player.getCurrentPosition(); i++) {
            String correctDirection = bridge.get(i);
            drawCell(upperLine, UP, correctDirection);
        }
        if (!player.getMoving()) {
            drawFailedCell(upperLine, UP, bridge.get(player.getCurrentPosition()));
        }
        return upperLine;
    }

    private static List<String> drawLowerLine(List<String> bridge, Player player) {
        List<String> lowerLine = new ArrayList<>();
        for (int i = 0; i < player.getCurrentPosition(); i++) {
            String correctDirection = bridge.get(i);
            drawCell(lowerLine, DOWN, correctDirection);
        }
        if (!player.getMoving()) {
            drawFailedCell(lowerLine, DOWN, bridge.get(player.getCurrentPosition()));
        }
        return lowerLine;
    }

    private static void drawCell(List<String> line, String lineType, String correctDirection) {
        if (correctDirection.equals(lineType)) {
            line.add(CROSSABLE_SIGN);
            return;
        }
        line.add(" ");
    }

    private static void drawFailedCell(List<String> line, String lineType, String correctDirection) {
        if (!correctDirection.equals(lineType)) {
            line.add(UNABLE_TO_CROSS_SIGN);
            return;
        }
        line.add(" ");
    }

    private static void printOneLine(List<String> line) {
        System.out.println(BRIDGE_PREFIX + String.join(DELIMITER, line) + BRIDGE_SUFFIX);
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    private static void printSuccessOrFailure(boolean isSuccessful) {
        if (isSuccessful) {
            System.out.println(SUCCESS);
        }
        if (!isSuccessful) {
            System.out.println(FAILURE);
        }
    }
}
