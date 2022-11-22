package bridge.view;

import bridge.domain.BridgeState;
import bridge.domain.FinalGameResult;
import bridge.domain.GameResult;
import bridge.domain.MoveResult;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]";
    private static final String BRIDGE_PARTITION = " | ";
    private static final String BRIDGE_BLANK = " ";
    private static final String START_STRING = "다리 건너기 게임을 시작합니다.\n";
    private static final String LAST_GAME_RESULT_STRING = "최종 게임 결과";
    private static final String WHETHER_SUCCESS_OR_NOT_STRING = "게임 성공 여부: ";
    private static final String TOTAL_TRY_COUNT_STRING = "총 시도한 횟수: ";

    public void printStart() {
        System.out.println(START_STRING);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameResult gameResult) {
        printRow(gameResult, BridgeState.UP);
        printRow(gameResult, BridgeState.DOWN);
        System.out.println();
    }

    public void printRow(GameResult gameResult, BridgeState bridgeState) {
        System.out.printf(BRIDGE_START);
        List<BridgeState> userStates = gameResult.getBridgeStates();
        for (int i = 0; i < userStates.size() - 1; i++) {
            printPreviousTile(userStates.get(i), bridgeState);
        }
        printCurrentTile(gameResult.getMoveResult(), userStates.get(userStates.size() - 1), bridgeState);
        System.out.println(BRIDGE_END);
    }

    public void printPreviousTile(BridgeState userState, BridgeState bridgeState) {
        if (userState == bridgeState) {
            System.out.printf(MoveResult.SAME.getResult() + BRIDGE_PARTITION);
            return;
        }
        System.out.printf(BRIDGE_BLANK + BRIDGE_PARTITION);
    }

    public void printCurrentTile(MoveResult moveResult, BridgeState userState, BridgeState bridgeState) {
        if ((userState == bridgeState && moveResult.equals(MoveResult.SAME)) ||
                (userState != bridgeState && moveResult.equals(MoveResult.DIFFERENT))) {
            System.out.printf(moveResult.getResult());
            return;
        }
        System.out.printf(BRIDGE_BLANK);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(FinalGameResult finalGameResult, int totalTryCount, GameResult gameResult) {
        System.out.println(LAST_GAME_RESULT_STRING);
        printMap(gameResult);
        System.out.println(WHETHER_SUCCESS_OR_NOT_STRING + finalGameResult.getFinalResult());
        System.out.println(TOTAL_TRY_COUNT_STRING + totalTryCount);
    }
}
