package bridge.view;

import bridge.BridgeGame;
import bridge.Bridges;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String MESSAGE_GAME_START = "다리 건너기 게임을 시작합니다.\n";
    private static final String MESSAGE_GAME_RESULT = "최종 게임 결과";
    private static final String GAME_RESULT_CLEAR_SUCCESS = "게임 성공 여부: 성공";
    private static final String GAME_RESULT_CLEAR_FAIL = "게임 성공 여부: 실패";
    private static final String GAME_RESULT_TRY_COUNT = "총 시도한 횟수: ";

    public void printGameStart() {
        System.out.println(MESSAGE_GAME_START);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridges bridges) {
        System.out.println(bridges);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame game) {
        System.out.println(MESSAGE_GAME_RESULT);
        System.out.println(game.getGameBridges().toString());
        if (game.isCleared()) {
            System.out.println(GAME_RESULT_CLEAR_SUCCESS);
        }
        if (!game.isCleared()) {
            System.out.println(GAME_RESULT_CLEAR_FAIL);
        }
        System.out.println(GAME_RESULT_TRY_COUNT + game.getTryCount());
    }
}
