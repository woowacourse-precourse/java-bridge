package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.GameCommand;
import bridge.domain.MoveCommand;

import java.util.List;
import java.util.Objects;

import static bridge.domain.MoveCommand.DOWN;
import static bridge.domain.MoveCommand.UP;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String START = "[";
    private final String END = "]";
    private final String BETWEEN = "|";

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void guideInputBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void guideInputMoving() {
        StringBuilder builder = new StringBuilder();
        builder.append("이동할 칸을 선택해주세요. (");

        final MoveCommand[] MOVE_COMMANDS = MoveCommand.values();
        for (MoveCommand command : MOVE_COMMANDS) {
            builder.append(String.format(", %s: %s", command.getWord(), command.getCommand()));
        }
        String message = builder.append(")").toString().replaceFirst(", ", "");
        System.out.println(message);
    }

    public void printMap(final BridgeGame bridgeGame) {
        List<String> bridgeRoute = bridgeGame.getBridge().getRoute();
        List<String> playerMoves = bridgeGame.getPlayer().getMoves();

        System.out.println(START + getFloor(UP, bridgeRoute, playerMoves) + END);
        System.out.println(START + getFloor(DOWN, bridgeRoute, playerMoves) + END);
    }

    private String getFloor(final MoveCommand marker, final List<String> bridgeRoutes, final List<String> playerMoves) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < playerMoves.size(); i++) {
            builder.append(BETWEEN + " ");
            String mark = marker(marker.getCommand(), playerMoves.get(i), bridgeRoutes.get(i));
            builder.append(mark).append(" ");
        }
        return builder.toString().replaceFirst("\\|", "");
    }

    private String marker(final String floorCommand, final String playerMove, final String bridgeRoute) {
        if (!Objects.equals(floorCommand, playerMove)) {
            return " ";
        }
        if (Objects.equals(playerMove, bridgeRoute)) {
            return MoveMarker.CORRECT.getMark();
        }
        return MoveMarker.WRONG.getMark();
    }

    public void guideInputGameOver() {
        StringBuilder builder = new StringBuilder();
        builder.append("게임을 다시 시도할지 여부를 입력해주세요. (");

        final GameCommand[] GAME_COMMANDS = GameCommand.values();
        for (GameCommand command : GAME_COMMANDS) {
            builder.append(String.format(", %s: %s", command.getWord(), command.getCommand()));
        }
        String message = builder.append(")").toString().replaceFirst(", ", "");
        System.out.println(message);
    }

    public void printResult(final String result, final BridgeGame bridgeGame) {
        int tryCount = bridgeGame.getTryCount();

        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}
