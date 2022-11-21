package view;

import bridge.BridgeGame;

public class OutputView {
    private static final String GAME_START_COMMENT = "다리 건너기 게임을 시작합니다.\n";
    private static final String FINAL_GAME_RESULT_COMMENT = "최종 게임 결과\n";
    private static final String GAME_SUCCESS_OR_FAIR_COMMENT = "게임 성공 여부: %s\n";
    private static final String GAME_RETRY_COUNT_COMMENT = "총 시도한 횟수: %d\n";

    public void printGameStart() {
        System.out.println(GAME_START_COMMENT);
    }

    public void printMap(String currentState) {
        System.out.println(currentState);
        System.out.println();
    }

    public void printResult(BridgeGame bridgeGame, String finalState) {
        System.out.print(FINAL_GAME_RESULT_COMMENT);
        System.out.println(finalState);
        System.out.println();
        System.out.printf(GAME_SUCCESS_OR_FAIR_COMMENT, bridgeGame.getGameResult());
        System.out.printf(GAME_RETRY_COUNT_COMMENT, bridgeGame.getTryCount());
    }
}
