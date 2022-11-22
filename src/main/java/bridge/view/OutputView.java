package bridge.view;

import bridge.domain.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String MESSAGE_TO_OUTPUT_START = "다리 건너기 게임을 시작합니다.";
    private static final String MESSAGE_TO_OUTPUT_FINAL_RESULT = "\n최종 게임 결과";
    private static final String MESSAGE_TO_OUTPUT_RESULT_SUCCESS = "게임 성공 여부: ";
    private static final String MESSAGE_TO_OUTPUT_RESULT_TRY_COUNT = "총 시도한 횟수: ";

    public void printStart() {
        System.out.println(MESSAGE_TO_OUTPUT_START);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(BridgeGame bridgeGame) {
        System.out.println(bridgeGame.getPlayerStatus());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(MESSAGE_TO_OUTPUT_FINAL_RESULT);

        printMap(bridgeGame);
        printSuccessOrFail(bridgeGame);
        printTrtCount(bridgeGame);
    }

    public void printSuccessOrFail(BridgeGame bridgeGame) {
        System.out.println(MESSAGE_TO_OUTPUT_RESULT_SUCCESS + bridgeGame.getGameResult());
    }

    public void printTrtCount(BridgeGame bridgeGame) {
        System.out.println(MESSAGE_TO_OUTPUT_RESULT_TRY_COUNT + bridgeGame.getPlayerTryCount());
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

}
