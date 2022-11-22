package bridge.view;

import bridge.Bridge;
import bridge.PlayerStatus;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_RESULT = "최종 게임 결과";
    private static final String WIN_OR_FAIL = "게임 성공 여부: ";
    private static final String WIN = "성공";
    private static final String FAIL = "실패";
    private static final String TOTAL_TRY_COUNT = "총 시도한 횟수: ";
    private static final String GAME_START = "다리 건너기 게임을 시작합니다";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printBridge(Bridge bridge) {
        System.out.println(bridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Bridge bridge, int tryCount, PlayerStatus playerStatus) {
        System.out.println(GAME_RESULT);
        printBridge(bridge);
        if (playerStatus.isMatch()) {
            System.out.println(WIN_OR_FAIL + WIN);
        }
        if (playerStatus.isMatch()) {
            System.out.println(WIN_OR_FAIL + FAIL);
        }
        System.out.println(TOTAL_TRY_COUNT + tryCount);
    }

    public void printStart() {
        System.out.println(GAME_START);
    }
}
