package bridge.view;

import bridge.domain.BridgeGameResult;
import bridge.domain.TryCount;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_SUCCESS_GUIDE = "게임 성공 여부: ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String TRY_COUNT_GUIDE = "총 시도한 횟수: ";
    private static final String PRINT_RESULT_GUIDE = "최종 게임 결과";
    private static final String NEW_LINE = "\n";

    private final OutputFormat outputFormat;

    public OutputView() {
        this.outputFormat = new OutputFormat();
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGameResult result) {
        System.out.println(outputFormat.printMapFormat(result));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGameResult bridgeGameResult, TryCount tryCount) {
        StringBuilder result = new StringBuilder();
        result.append(PRINT_RESULT_GUIDE);
        result.append(outputFormat.printMapFormat(bridgeGameResult));
        result.append(NEW_LINE);
        result.append(printGameSuccessFormat(bridgeGameResult));
        result.append(NEW_LINE);
        result.append(printTryCountFormat(tryCount));
        System.out.println(result);
    }

    public String printTryCountFormat(TryCount tryCount) {
        return TRY_COUNT_GUIDE + tryCount.count();
    }

    public String printGameSuccessFormat(BridgeGameResult bridgeGameResult) {
        if (bridgeGameResult.isSuccess()) {
            return GAME_SUCCESS_GUIDE + SUCCESS;
        }
        return GAME_SUCCESS_GUIDE + FAIL;
    }
}
