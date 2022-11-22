package bridge;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

public class Application {

    static final InputView inputCommand = new InputView();
    static final BridgeGame bridgeGame = new BridgeGame();
    static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static final OutputView outputView = new OutputView();
    static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    static int gameTryInfo = 1;

    public static List<List<String>> judgeBridge(int bridgeSize,List<String> bridge) {
        List<List<String>> resultBridge = new ArrayList<>();
        List<String> upBridgeMap = new ArrayList<>();
        List<String> downBridgeMap = new ArrayList<>();
        for (int i = 0; i < bridgeSize; i++) {
            String move = inputCommand.readMoving();
            int judge = bridgeGame.move(bridge, i, move);
            if (judge == 0) {
                upBridgeMap = outputView.storeAnotherMap(upBridgeMap, i);
                downBridgeMap = outputView.storeRightMap(downBridgeMap, i);
            }
            if (judge == 1) {
                upBridgeMap = outputView.storeRightMap(upBridgeMap, i);
                downBridgeMap = outputView.storeAnotherMap(downBridgeMap, i);
            }
            if (judge == 2 || judge == 3) {
                if (judge == 2) {
                    upBridgeMap = outputView.storeAnotherWrongMap(upBridgeMap, i);
                    downBridgeMap = outputView.storeWrongMap(downBridgeMap, i);
                }
                if (judge == 3) {
                    upBridgeMap = outputView.storeWrongMap(upBridgeMap, i);
                    downBridgeMap = outputView.storeAnotherWrongMap(downBridgeMap, i);
                }
                resultBridge.add(upBridgeMap);
                resultBridge.add(downBridgeMap);
                return resultBridge;
            }
        }
        gameTryInfo = 0;
        resultBridge.add(upBridgeMap);
        resultBridge.add(downBridgeMap);
        return resultBridge;
    }

    public static int judgeRestart() {
        String restart = inputCommand.readGameCommand();
        if(restart.equals("R")) {
            return 1;
        }
        return 2;
    }

    public static void judgeWin(int gameTryInfo) {
        if(gameTryInfo == 2) {
            System.out.println("게임 성공 여부: 실패");
        }
        if(gameTryInfo == 0) {
            System.out.println("게임 성공 여부: 성공");
        }
    }

    public static void finalResult(List<List<String>> bridgeResult) {
        System.out.println("최종 게임 결과");
        if(gameTryInfo == 2) {
            outputView.printResult(bridgeResult.get(0));
            outputView.printResult(bridgeResult.get(1));
        }
        if(gameTryInfo == 0) {
            int lastJudgeIndex = bridgeResult.get(0).size() - 2;
            bridgeResult.get(0).set(lastJudgeIndex," O ");
            bridgeResult.get(1).set(lastJudgeIndex," O ");
            outputView.printResult(bridgeResult.get(0));
            outputView.printResult(bridgeResult.get(1));
        }
    }


    public static void bridgeGame() {
        int bridgeSize = inputCommand.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        List<List<String>> bridgeResult = new ArrayList<>();
        int gameTryCount = 0;

        while (gameTryInfo != 0 && gameTryInfo != 2) {
            bridgeResult = judgeBridge(bridgeSize,bridge);
            if (gameTryInfo == 1) {
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
