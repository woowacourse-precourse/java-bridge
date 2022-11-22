package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.Player;
import utils.UpDown;
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
    private static final String O_SIGN = "O";
    private static final String X_SIGN = "X";
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
        List<String> upperLine = drawLine(bridgeGame, UpDown.UP.getLetter());
        List<String> lowerLine = drawLine(bridgeGame, UpDown.DOWN.getLetter());
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
        printSuccessOrFailure(bridgeGame.isReached());
        printTryCount(bridgeGame);
    }

    private static List<String> drawLine(BridgeGame bridgeGame, String lineType) {
        List<String> bridge = bridgeGame.getBridge();
        Player player = bridgeGame.getPlayer();
        List<String> Line = new ArrayList<>();
        for (int i = 0; i < player.getCurrentPosition(); i++) {
            drawCell(Line, lineType, bridge.get(i));
        }
        if (!player.getMoving()) {
            drawFailedCell(Line, lineType, bridge.get(player.getCurrentPosition()));
        }
        return Line;
    }

    private static void drawCell(List<String> line, String lineType, String correctDirection) {
        if (correctDirection.equals(lineType)) {
            line.add(O_SIGN);
            return;
        }
        line.add(BLANK);
    }

    private static void drawFailedCell(List<String> line, String lineType, String correctDirection) {
        if (!correctDirection.equals(lineType)) {
            line.add(X_SIGN);
            return;
        }
        line.add(BLANK);
    }

    private static void printOneLine(List<String> line) {
        System.out.println(BRIDGE_PREFIX + String.join(DELIMITER, line) + BRIDGE_SUFFIX);
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    private static void printSuccessOrFailure(boolean isSuccessful) {
        System.out.print(SUCCESS_OR_NOT);
        if (isSuccessful) {
            System.out.println(SUCCESS);
        }
        if (!isSuccessful) {
            System.out.println(FAILURE);
        }
    }

    private static void printTryCount(BridgeGame bridgeGame) {
        System.out.print(TRY_COUNT);
        System.out.println(bridgeGame.getPlayer().getTryCount());
    }
}
