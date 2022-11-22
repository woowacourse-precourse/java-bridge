package bridge.view;

import bridge.dto.BridgeResultDto;
import bridge.dto.GameResultDto;

import java.util.List;


public class OutputView {

    private static final String BRIDGE_FROM = "[ %s ]";
    private static final String BRIDGE_MIDDLE = " | ";
    private static final String GAME_INIT = "다리 건너기 게임을 시작합니다.";
    private static final String FINAL_RESULT = "최종 게임 결과";
    private static final String GAME_SUCCESS = "게임 성공 여부: %s";
    private static final String RETRY_COUNT = "총 시도한 횟수: %d";

    public void printInit() {
        System.out.println(GAME_INIT);
    }

    public void printMap(BridgeResultDto resultDto) {
        printBridgeFormat(resultDto.getUpResult());
        printBridgeFormat(resultDto.getDownResult());
    }

    public void printResult(GameResultDto gameResult) {
        System.out.println(FINAL_RESULT);
        printMap(gameResult.getBridgeResultDto());
        printGameSuccess(gameResult.getSuccess());
        printTotalRetryCount(gameResult.getRetryCount());
    }

    private void printBridgeFormat(List<String> bridge) {
        String formatBridge = String.join(BRIDGE_MIDDLE, bridge);
        String outputBridge = String.format(BRIDGE_FROM, formatBridge);
        System.out.println(outputBridge);
    }

    private void printGameSuccess(String success) {
        String result = String.format(GAME_SUCCESS, success);
        System.out.println(result);
    }

    private void printTotalRetryCount(int retryCount) {
        String result = String.format(RETRY_COUNT, retryCount);
        System.out.println(result);
    }
}
