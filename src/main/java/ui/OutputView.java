package ui;

import bridge.BridgeGame;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    String[] mapData;
    BridgeGame bridgeGame;

    public OutputView(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        for (String bridgeResult : mapData) {
            System.out.println(bridgeResult);
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println("최종 게임 결과");
        printMap();

        System.out.println("게임 성공 여부: " + bridgeGame.printGamePassStateByKorean());
        System.out.println("총 시도한 횟수: " + bridgeGame.getGameTryCount());
    }

    public void makeResults(String userMoving, String moveResult) {
        List<String> gameResults = bridgeGame.getCurrentGameResults();
        String commonResult = makeCommonResult(gameResults);
        String upBridgeResult = makeUpBridgeResult(commonResult, moveResult, userMoving);
        String downBridgeResult = makeDownBridgeResult(commonResult, moveResult, userMoving);

        mapData = new String[]{upBridgeResult, downBridgeResult};
    }


    private String makeCommonResult(List<String> gameResults) {
        return gameResults.stream().
                collect(Collectors.joining(" | ", "[ ", " ]"));
    }

    private String makeUpBridgeResult(String commonResult, String moveResult, String userMoving) {
        String upBridgeResult = commonResult.replace("U", "O").
                replace("D", " ");

        upBridgeResult = changeUpBridgeResultToDeleteX(upBridgeResult, moveResult, userMoving);

        return upBridgeResult;
    }

    private String makeDownBridgeResult(String commonResult, String moveResult, String userMoving) {
        String downBridgeResult = commonResult.replace("U", " ").
                replace("D", "O");

        downBridgeResult = changeDownBridgeResultToDeleteX(downBridgeResult, moveResult, userMoving);

        return downBridgeResult;
    }

    private String changeUpBridgeResultToDeleteX(String upBridgeResult, String moveResult, String userMoving) {
        if (moveResult.equals("X") && userMoving.equals("D")) {
            upBridgeResult = upBridgeResult.replace("X", " ");
        }

        return upBridgeResult;
    }

    private String changeDownBridgeResultToDeleteX(String downBridgeResult, String moveResult, String userMoving) {
        if (moveResult.equals("X") && userMoving.equals("U")) {
            downBridgeResult = downBridgeResult.replace("X", " ");
        }

        return downBridgeResult;
    }

    public void printCurrentGameResult(String userMoving, String moveResult) {
        makeResults(userMoving, moveResult);
        printMap();
    }
}
