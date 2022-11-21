package bridge.view;

import bridge.model.Moving;
import bridge.model.Player;
import bridge.model.PlayerStatus;
import bridge.service.BridgeGame;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String INIT_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String MAP_HEAD = "[ ";
    public static final String MAP_TAIL = " ]";
    public static final String MOVING_DELIMITER = " | ";
    private static OutputView instance;

    private OutputView() {}

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }
    public void printInit() {
        System.out.println(INIT_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Player player) {
        printPartialMap(player, Moving.U);
        printPartialMap(player, Moving.D);
    }

    private void printPartialMap(Player player, Moving expected) {
        List<Moving> movingHistory = player.getHistory();
        System.out.print(MAP_HEAD);
        for (int i = 0; i < movingHistory.size() - 1; i++) {
            printMoving(movingHistory.get(i), expected);
            System.out.print(MOVING_DELIMITER);
        }
        printLastMoving(movingHistory.get(movingHistory.size() - 1), expected, player.getPlayerStatus());
        System.out.println(MAP_TAIL);
    }

    private void printMoving(Moving moving, Moving expected) {
        if (moving != expected) {
            System.out.print(" ");
            return;
        }
        System.out.print("O");
    }

    private void printLastMoving(Moving moving, Moving expected, PlayerStatus playerStatus) {
        if (moving != expected) {
            System.out.print(" ");
            return;
        }
        if (playerStatus == PlayerStatus.DEAD) {
            System.out.print("X");
            return;
        }
        System.out.print("O");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Player player, BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(player);

        System.out.printf("게임 성공 여부: %s\n", player.getPlayerStatus() == PlayerStatus.DEAD ?
                "실패" : "성공");
        System.out.printf("총 시도한 횟수: %d\n", bridgeGame.getTrialCount().getCount());
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
