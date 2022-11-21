package bridge.view;

import bridge.service.BridgeGame;
import java.util.List;

import static bridge.util.MapMaker.makeMap;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";
    private static final String RESULT_FORMAT_MESSAGE = "게임 성공 여부: ";
    private static final String TRIES_FORMAT_MESSAGE = "총 시도한 횟수: ";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(BridgeGame bridgeGame) {
        List<String> userMoves = bridgeGame.getUserMoves();
        List<Boolean> results = bridgeGame.getResults();
        System.out.println(makeMap(userMoves, results));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println();
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(bridgeGame);
        String result = FAIL_MESSAGE;
        if (bridgeGame.getResults().get(bridgeGame.getResults().size() - 1)) {
            result = SUCCESS_MESSAGE;
        }
        System.out.printf(RESULT_FORMAT_MESSAGE + result);
        System.out.printf(TRIES_FORMAT_MESSAGE + bridgeGame.getTries());
    }
}
