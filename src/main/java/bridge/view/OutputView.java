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
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Deque<MovementStatusForm> movementResult) {
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
    public void printResult() {
    }
}
