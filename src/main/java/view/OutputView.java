package view;

import bridge.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_COMMENT = "다리 건너기 게임을 시작합니다.\n";
    private static final String FINAL_GAME_RESULT_COMMENT = "최종 게임 결과\n";
    private static final String GAME_SUCCESS_OR_FAIR_COMMENT = "게임 성공 여부: %s\n";
    private static final String GAME_RETRY_COUNT_COMMENT = "총 시도한 횟수: %d\n";

    public void printGameStart() {
        System.out.println(GAME_START_COMMENT);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String currentState) {
        System.out.println(currentState);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, String finalState) {
        System.out.print(FINAL_GAME_RESULT_COMMENT);
        System.out.println(finalState);
        System.out.println();
        System.out.printf(GAME_SUCCESS_OR_FAIR_COMMENT, bridgeGame.getGameResult());
        System.out.printf(GAME_RETRY_COUNT_COMMENT, bridgeGame.getTryCount());
    }
}
