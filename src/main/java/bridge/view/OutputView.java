package bridge.view;

import bridge.model.BridgeGame;
import bridge.constant.ErrorMessage;
import bridge.constant.GuidanceMessage;
import bridge.model.MovingHistory;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String BRIDGE_START = "[ ";
    public static final String BRIDGE_END = " ]";
    public static final int STARTING_POINT = 0;
    public static final String BRIDGE_SEPARATOR = " | ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MovingHistory movingHistory) {
        printMapOfSide(movingHistory.getUpSide());
        printMapOfSide(movingHistory.getDownSide());
        printNewLine();
    }

    private void printNewLine() {
        System.out.println();
    }

    private void printMapOfSide(List<String> sideHistory) {
        System.out.print(BRIDGE_START);

        for (int position = STARTING_POINT; position < sideHistory.size(); position++) {
            if (position > STARTING_POINT) {
                System.out.print(BRIDGE_SEPARATOR);
            }
            System.out.print(sideHistory.get(position));
        }
        System.out.println(BRIDGE_END);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(MovingHistory movingHistory, BridgeGame bridgeGame) {
        System.out.println(GuidanceMessage.GAME_OUTRO);
        printMap(movingHistory);
        printGameResult(bridgeGame);
        printTrialCount(bridgeGame);
    }

    private static void printTrialCount(BridgeGame bridgeGame) {
        System.out.print(GuidanceMessage.INFORM_TRIAL_COUNT);
        System.out.println(bridgeGame.getTrialCount());
    }

    private void printGameResult(BridgeGame bridgeGame) {
        System.out.print(GuidanceMessage.INFORM_IS_SUCCESS);
        System.out.println(bridgeGame.getGameResult().getMessage());
    }

    public void printError(IllegalArgumentException error) {
        System.out.print(ErrorMessage.PREFIX);
        System.out.println(error.getMessage());
    }
}
