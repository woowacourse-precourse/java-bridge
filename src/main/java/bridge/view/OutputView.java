package bridge.view;

import bridge.model.Moving;
import bridge.model.Player;
import bridge.model.PlayerStatus;
import bridge.model.TrialCount;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String INIT_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String MAP_HEAD = "[ ";
    public static final String MAP_TAIL = " ]";
    public static final String MOVING_DELIMITER = " | ";
    public static final String GOOD_CHOICE_FORM = "O";
    public static final String BAD_CHOICE_FORM = "X";
    public static final String NO_CHOICE_FORM = " ";
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
        printBlankLine();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Player player) {
        printMap(player, Moving.U);
        printMap(player, Moving.D);
        printBlankLine();
    }

    private void printMap(Player player, Moving movingToPrint) {
        System.out.print(MAP_HEAD);
        printMovings(player, movingToPrint);
        System.out.println(MAP_TAIL);
    }

    private void printMovings(Player player, Moving movingToPrint) {
        List<Moving> movings = player.getHistory();
        for (int i = 0; i < movings.size() - 1; i++) {
            System.out.print(generateMovingResult(movings.get(i), movingToPrint));
            System.out.print(MOVING_DELIMITER);
        }
        System.out.print(generateLastMovingResult(player, movingToPrint));
    }

    private String generateMovingResult(Moving moving, Moving movingToPrint) {
        if (moving != movingToPrint) {
            return NO_CHOICE_FORM;
        }
        return GOOD_CHOICE_FORM;
    }

    private String generateLastMovingResult(Player player, Moving movingToPrint) {
        if (getLastMoving(player) != movingToPrint) {
            return NO_CHOICE_FORM;
        }
        if (player.isDead()) {
            return BAD_CHOICE_FORM;
        }
        return GOOD_CHOICE_FORM;
    }

    private Moving getLastMoving(Player player) {
        List<Moving> movings = player.getHistory();
        return movings.get(movings.size() - 1);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Player player, TrialCount trialCount) {
        System.out.println("최종 게임 결과");
        printMap(player);

        System.out.printf("게임 성공 여부: %s\n", player.getPlayerStatus() == PlayerStatus.DEAD ?
                "실패" : "성공");
        System.out.printf("총 시도한 횟수: %d\n", trialCount.getCount());
    }

    private void printBlankLine() {
        System.out.println();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
