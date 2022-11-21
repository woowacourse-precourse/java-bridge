package bridge.view;

import bridge.MovementStatusForm;
import bridge.Site;

import java.util.Deque;
import java.util.Iterator;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_MAP_MARK = "[";
    private static final String END_MAP_MARK = "]";
    private static final String SEPARATOR_MARK = "|";
    private static final String BLANK_MARK = "   ";
    private static final String RIGHT_MARK = " O ";
    private static final String WRONG_MARk = " X ";
    private static final String WIN_MSG = "성공";
    private static final String LOSE_MSG = "실패";
    private static final String FINAL_RESULT_MSG = "최종 게임 결과";
    private static final String GAME_WIN_LOSE_CASE_MSG = "게임 성공 여부: %s";
    private static final String GAME_TRY_COUNT_MSG = "총 시도한 횟수: %d";
    private static final String ERROR_MSG = "[ERROR] %s";
    private static final String INTRO_MSG = "다리 건너기 게임을 시작합니다.\n";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(Deque<MovementStatusForm> movementResult) {
        drawBySite(movementResult, Site.UP);
        drawBySite(movementResult, Site.DOWN);
        System.out.println();
    }

    private static void drawBySite(Deque<MovementStatusForm> movementResult, Site site) {
        Iterator<MovementStatusForm> movementResultIterator = movementResult.iterator();
        System.out.printf(START_MAP_MARK);
        while (movementResultIterator.hasNext()) {
            drawShapeBySite(site, movementResultIterator.next());
            if (movementResultIterator.hasNext()) System.out.print(SEPARATOR_MARK);
        }
        System.out.printf(END_MAP_MARK);
        System.out.println();
    }

    private static void drawShapeBySite(Site site, MovementStatusForm bridgeResult) {
        if (Site.UP.equals(site)) drawShape(bridgeResult
                , MovementStatusForm.UP_O
                , MovementStatusForm.UP_X);
        if (Site.DOWN.equals(site)) drawShape(bridgeResult
                , MovementStatusForm.DOWN_O
                , MovementStatusForm.DOWM_X);
    }

    private static void drawShape(MovementStatusForm bridgeResult, MovementStatusForm pass_case, MovementStatusForm wrong_case) {
        if (pass_case.equals(bridgeResult)) {
            System.out.printf(RIGHT_MARK);
            return;
        }
        if (wrong_case.equals(bridgeResult)) {
            System.out.printf(WRONG_MARk);
            return;
        }
        System.out.printf(BLANK_MARK);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(int play_count, boolean isWin, Deque<MovementStatusForm> movementResult) {
        System.out.println(FINAL_RESULT_MSG);
        printMap(movementResult);

        String winning_msg = LOSE_MSG;
        if (isWin) winning_msg = WIN_MSG;
        System.out.println(String.format(GAME_WIN_LOSE_CASE_MSG, winning_msg));
        System.out.println(String.format(GAME_TRY_COUNT_MSG, play_count));
    }

    public static void printError(String error_msg) {
        System.out.println(String.format(ERROR_MSG, error_msg));
    }

    public static void printIntro() {
        System.out.println(INTRO_MSG);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
