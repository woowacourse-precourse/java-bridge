package bridge;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

public class Application {

    static final int RIGHT_MATCH_DOWN = 0;
    static final int RIGHT_MATCH_UP = 1;
    static final int WRONG_MATCH_DOWN = 2;
    static final int WRONG_MATCH_UP = 3;

    static final int GAME_TRY_SUCCESS = 0;
    static final int GAME_TRY_FAIL = 1;
    static final int GAME_TRY_EXIT = 2;

    static final int UP_BRIDGE = 0;
    static final int DOWN_BRIDGE = 1;


    static final InputView inputCommand = new InputView();
    static final BridgeGame bridgeGame = new BridgeGame();
    static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static final OutputView outputView = new OutputView();
    static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    static int gameTryInfo = GAME_TRY_FAIL;

    public static List<List<String>> judgeBridge(int bridgeSize,List<String> bridge) {
        List<List<String>> resultBridge = new ArrayList<>();
        List<String> upBridgeMap = new ArrayList<>();
        List<String> downBridgeMap = new ArrayList<>();
        for (int i = 0; i < bridgeSize; i++) {
            String move = inputCommand.readMoving();
            int judge = bridgeGame.move(bridge, i, move);
            if (judge == RIGHT_MATCH_DOWN) {
                upBridgeMap = outputView.storeAnotherMap(upBridgeMap, i);
                downBridgeMap = outputView.storeRightMap(downBridgeMap, i);
            }
            if (judge == RIGHT_MATCH_UP) {
                upBridgeMap = outputView.storeRightMap(upBridgeMap, i);
                downBridgeMap = outputView.storeAnotherMap(downBridgeMap, i);
            }
            if (judge == WRONG_MATCH_DOWN || judge == WRONG_MATCH_UP) {
                if (judge == WRONG_MATCH_DOWN) {
                    upBridgeMap = outputView.storeAnotherWrongMap(upBridgeMap, i);
                    downBridgeMap = outputView.storeWrongMap(downBridgeMap, i);
                }
                if (judge == WRONG_MATCH_UP) {
                    upBridgeMap = outputView.storeWrongMap(upBridgeMap, i);
                    downBridgeMap = outputView.storeAnotherWrongMap(downBridgeMap, i);
                }
                resultBridge.add(upBridgeMap);
                resultBridge.add(downBridgeMap);
                return resultBridge;
            }
        }
        gameTryInfo = GAME_TRY_SUCCESS;
        resultBridge.add(upBridgeMap);
        resultBridge.add(downBridgeMap);
        return resultBridge;
    }

    public static int judgeRestart() {
        String restart = inputCommand.readGameCommand();
        return bridgeGame.retry(restart);
    }

    public static void judgeWin(int gameTryInfo) {
        if (gameTryInfo == GAME_TRY_EXIT) {
            System.out.println("게임 성공 여부: 실패");
        }
        if (gameTryInfo == GAME_TRY_SUCCESS) {
            System.out.println("게임 성공 여부: 성공");
        }
    }

    public static void finalResult(List<List<String>> bridgeResult) {
        System.out.println("최종 게임 결과");
        if (gameTryInfo == GAME_TRY_EXIT) {
            outputView.printResult(bridgeResult.get(UP_BRIDGE));
            outputView.printResult(bridgeResult.get(DOWN_BRIDGE));
        }
        if (gameTryInfo == GAME_TRY_SUCCESS) {
            int lastJudgeIndex = bridgeResult.get(UP_BRIDGE).size() - 2;
            bridgeResult.get(UP_BRIDGE).set(lastJudgeIndex," O ");
            bridgeResult.get(DOWN_BRIDGE).set(lastJudgeIndex," O ");
            outputView.printResult(bridgeResult.get(UP_BRIDGE));
            outputView.printResult(bridgeResult.get(DOWN_BRIDGE));
        }
    }


    public static void bridgeGame() {
        int bridgeSize = inputCommand.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        List<List<String>> bridgeResult = new ArrayList<>();
        int gameTryCount = 0;

        while (gameTryInfo != GAME_TRY_SUCCESS && gameTryInfo != GAME_TRY_EXIT) {
            bridgeResult = judgeBridge(bridgeSize,bridge);
            if (gameTryInfo == GAME_TRY_FAIL) {
                gameTryInfo = judgeRestart();
            }
            gameTryCount++;
        }
        finalResult(bridgeResult);
        judgeWin(gameTryInfo);
        System.out.println("총 시도한 횟수: " + gameTryCount);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            bridgeGame();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
