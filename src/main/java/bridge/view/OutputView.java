package bridge.view;

import bridge.domain.BridgeMatcher;
import bridge.domain.GameResult;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String OUTPUT_GAME_START = "다리 건너기 게임을 시작합니다.\n";
    private static final String OUTPUT_GAME_RESULT_HEADER = "최종 게임 결과\n";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String OUTPUT_FINAL_GAME_RESULT = "게임 성공 여부: %s\n총 시도한 횟수: %d";

    private GameResult gameResult;

    public OutputView(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public void printGameStart() {
        System.out.println(OUTPUT_GAME_START);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String input, boolean isMatch, BridgeMatcher bridgeMatcher) {
        String map = gameResult.makeBridgeResult(input, isMatch, bridgeMatcher);
        System.out.println(map);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, BridgeMatcher bridgeMatcher) {
        int count = bridgeMatcher.getTryCount();
        boolean isSuccess = bridgeMatcher.isGameSuccess(bridge);
        String finalResult = gameResult.getFinalResult();
        String result = SUCCESS;
        if (!isSuccess) {
            result = FAIL;
        }
        System.out.println(OUTPUT_GAME_RESULT_HEADER + finalResult);
        System.out.printf(OUTPUT_FINAL_GAME_RESULT, result, count);
    }
}
