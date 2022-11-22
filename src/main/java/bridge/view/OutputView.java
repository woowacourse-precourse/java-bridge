package bridge.view;

import bridge.model.BridgeGame;
import bridge.model.Direction;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String BRIDGE_START = "[ ";
    public static final String BRIDGE_FINISH = " ]";
    public static final String DIVIDING_LINE = " | ";
    public static final String SUCCESS = "O";
    public static final String FAIL = "X";
    public static final String BLANK = " ";

    private static StringBuilder upRow;
    private static StringBuilder downRow;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printRoute(BridgeGame bridgeGame) {
        List<Direction> route = bridgeGame.getRoute();
        writeBridgeStart();
        writeRoute(bridgeGame, route);
        writeBridgeFinish();
        System.out.println(upRow);
        System.out.println(downRow);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printRoute(bridgeGame);
        printSuccessOrNot(bridgeGame);
        System.out.printf("총 시도한 횟수: %d\n", bridgeGame.getTotalTryCount());
    }

    public void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    private static void writeBridgeStart() {
        upRow = new StringBuilder(BRIDGE_START);
        downRow = new StringBuilder(BRIDGE_START);
    }

    private static void writeRoute(BridgeGame bridgeGame, List<Direction> route) {
        int lastIndex = route.size() - 1;
        for (int index = 0; index < lastIndex; index++) {
            Direction direction = route.get(index);
            writeMessageByDirection(SUCCESS, direction);
            writeDividingLine();
        }
        if (bridgeGame.isFailed()) {
            writeMessageByDirection(FAIL, route.get(lastIndex));
            return;
        }
        writeMessageByDirection(SUCCESS, route.get(lastIndex));
    }

    private static void writeBridgeFinish() {
        upRow.append(BRIDGE_FINISH);
        downRow.append(BRIDGE_FINISH);
    }

    private static void writeMessageByDirection(String message, Direction direction) {
        if (direction == Direction.UP) {
            upRow.append(message);
            downRow.append(BLANK);
            return;
        }
        upRow.append(BLANK);
        downRow.append(message);
    }

    private static void writeDividingLine() {
        upRow.append(DIVIDING_LINE);
        downRow.append(DIVIDING_LINE);
    }

    private static void printSuccessOrNot(BridgeGame bridgeGame) {
        System.out.print("게임 성공 여부: ");
        if (bridgeGame.isCrossed()) {
            System.out.println("성공");
            return;
        }
        System.out.println("실패");
    }
}