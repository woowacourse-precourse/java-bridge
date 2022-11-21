package bridge.view;

import bridge.service.BridgeGame;
import java.util.List;

import static bridge.util.MapMaker.makeMap;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

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
        System.out.println("\n최종 게임 결과");
        printMap(bridgeGame);
        String result = "실패";
        if (bridgeGame.getResults().get(bridgeGame.getResults().size() - 1)) {
            result = "성공";
        }
        System.out.printf("게임 성공 여부: %s\n", result);
        System.out.printf("총 시도한 횟수: %d\n", bridgeGame.getTries());
    }
}
