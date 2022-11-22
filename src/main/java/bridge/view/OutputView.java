package bridge.view;

import bridge.domain.BridgeGameStatus;
import bridge.domain.GameResult;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final static String FINAL_GAME_RESULT = "게임 성공 여부: ";
    private final static String TOTAL_RUN_COUNT = "총 시도한 횟수: ";
    private final static String START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private final static String END_MESSAGE = "\n최종 게임 결과";
    public final static String ERROR_PREFIX = "[ERROR]";

    public void printGameStartMessage() {
        System.out.println(START_MESSAGE);
    }
    
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * @param bridgeGameStatus
     */
    public void printMap(BridgeGameStatus bridgeGameStatus) {
        System.out.println(bridgeGameStatus);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * @param bridgeGameStatus
     */
    public void printResult(BridgeGameStatus bridgeGameStatus) {
        System.out.println(END_MESSAGE);
        System.out.println(bridgeGameStatus);
        final boolean gameResult = bridgeGameStatus.isGameSuccessfulEnd();
        final String gameResultMessage = GameResult.getGameResultMessage(gameResult);
        System.out.println(FINAL_GAME_RESULT + gameResultMessage);
        System.out.println(TOTAL_RUN_COUNT + bridgeGameStatus.getRunCount());
    }
}
