package bridge.view;

import bridge.domain.result.BridgeResult;
import bridge.domain.result.GameState;

public class OutputView {

    public static final String BLANK = " ";

    private final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String TOTAL_TRY_COUNT_MESSAGE = "총 시도한 횟수: ";
    private static final String PASS_OR_FAIL_MESSAGE = "게임 성공 여부: ";
    private static final String PASS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";
    private static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printMap(BridgeResult movingResults) {
        printMapOfCase(movingResults);
    }

    private void printMapOfCase(BridgeResult bridgeResult) {
        System.out.println("[ "+ bridgeResult.upperMapToString() + " ]");
        System.out.println("[ "+ bridgeResult.lowerMapToString() + " ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param bridgeResult
     * @param gameState
     */
    public void printResult(BridgeResult bridgeResult, GameState gameState) {
        System.out.println(FINAL_RESULT_MESSAGE);
        printMapOfCase(bridgeResult);
        System.out.println(PASS_OR_FAIL_MESSAGE + checkPassOrFail(gameState.isKeepGoing()));
        System.out.println(TOTAL_TRY_COUNT_MESSAGE + gameState.getTryCnt());
    }

    private String checkPassOrFail(boolean keepGoing) {
        if(keepGoing)
            return PASS_MESSAGE;
        return FAIL_MESSAGE;
    }
}
