package bridge.view;

import bridge.BridgeGame;
import bridge.constant.ErrorMessage;
import bridge.constant.GuidanceMessage;
import bridge.MovingHistory;
import bridge.SideMap;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final static String BRIDGE_START = "[ ";
    private final static String BRIDGE_END = " ]";

    public void printGameIntro() {
        System.out.println(GuidanceMessage.GAME_INTRO);
        printNewLine();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MovingHistory movingHistory) {
        SideMap upSideMap = movingHistory.getUpSideMap();
        SideMap downSideMap = movingHistory.getDownSideMap();

        printSideMap(upSideMap);
        printSideMap(downSideMap);
        printNewLine();
    }

    private void printSideMap(SideMap sideMap) {
        System.out.print(BRIDGE_START);
        System.out.print(sideMap);
        System.out.println(BRIDGE_END);
    }

    private void printNewLine() {
        System.out.println();
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

    private void printGameResult(BridgeGame bridgeGame) {
        System.out.print(GuidanceMessage.INFORM_IS_SUCCESS);
        System.out.println(bridgeGame.getGameResult().getMessage());
    }

    private void printTrialCount(BridgeGame bridgeGame) {
        System.out.print(GuidanceMessage.INFORM_TRIAL_COUNT);
        System.out.println(bridgeGame.getTrialCount());
    }

    public void printError(IllegalArgumentException error) {
        System.out.print(ErrorMessage.PREFIX);
        System.out.println(error.getMessage());
    }
}
