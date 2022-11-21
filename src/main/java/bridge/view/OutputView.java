package bridge.view;

import bridge.GameStatus;
import bridge.domain.Result;
import bridge.view.util.BridgeMapDrawer;


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static final String BLANK = "   |";
    public static final String O = " O |";
    public static final String X = " X |";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Result result) {
        String map = BridgeMapDrawer.draw(result);
        System.out.println(map);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameStatus gameStatus, Result result) {
        System.out.println(Message.FINAL_RESULT.getMessage());
        printMap(result);
        if (gameStatus.isSuccess()) {
            System.out.println(Message.FAIL_TRY_COUNT.getMessage() + gameStatus.getTryCount());
            return;
        }
        System.out.println(Message.SUCCESS_TRY_COUNT.getMessage() + gameStatus.getTryCount());
    }
}
