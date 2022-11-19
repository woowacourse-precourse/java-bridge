package bridge.Controller;

import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.View.InputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    InputView inputView;
    BridgeGame bridgeGame;
    BridgeMaker bridgeMaker;

    public GameController(InputView inputView, BridgeGame bridgeGame, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = bridgeMaker;
    }


    public void GAMESTART() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int input = inputView.readBridgeSize();
        bridgeGame.setBridgeSize(input);
        List<String> bridge = bridgeMaker.makeBridge(input);
        bridgeGame.setBridge(bridge);
    }

    public void RUNPROCESS() {
        bridgeGame.increaseGameCount();
        for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
            String input = inputView.readMoving();
            List<String> bridge = bridgeGame.getBridge();
            List<Boolean> matchResult = bridgeGame.getMatchResult();
            boolean match = bridge.get(i).equals(input);
            matchResult.add(match);
            bridgeGame.setMatchResult(matchResult);
            printBridge(matchResult, bridge);
            if (!match) {
                break;
            }
            if (i == bridgeGame.getBridgeSize() - 1) {
                bridgeGame.gameSuccecs();
            }
        }
    }

    public boolean SELECTRESTART() {
        String input = inputView.readGameCommand();
        if (input.equals("R")) {
            bridgeGame.setMatchResult(new ArrayList<>());
        }
        return input.equals("R");
    }

    public void STOPGAME() {
        System.out.println("최종 게임 결과");
        printBridge(bridgeGame.getMatchResult(),bridgeGame.getBridge());
        String success = "성공";
        if (!bridgeGame.isSuccecs()) {
            success = "실패";
        }
        System.out.println("게임 성공 여부: "+success);
        System.out.println("총 시도한 횟수: "+bridgeGame.getGameCount());
    }

    public void printBridge(List<Boolean> matchResult, List<String> bridge) {
        // 첫째줄 출력
        for (int i = 0; i < matchResult.size(); i++) {
            if (i == 0) {
                System.out.print("[");
            }
            if (bridge.get(i).equals("U") && matchResult.get(i)) {
                    System.out.print(" O ");
            }
            if (bridge.get(i).equals("U") && !matchResult.get(i)) {
                    System.out.print("   ");
            }
            if (bridge.get(i).equals("D") && !matchResult.get(i)) {
                System.out.print(" X ");
            }
            if (bridge.get(i).equals("D") && matchResult.get(i)) {
                System.out.print("   ");
            }
            if (i == matchResult.size()-1) {
                System.out.println("]");
                break;
            }
            System.out.print("|");
        }
        // 둘째줄 출력
        for (int i = 0; i < matchResult.size(); i++) {
            if (i == 0) {
                System.out.print("[");
            }
            if (bridge.get(i).equals("D") && matchResult.get(i)) {
                System.out.print(" O ");
            }
            if (bridge.get(i).equals("D") && !matchResult.get(i)) {
                System.out.print("   ");
            }
            if (bridge.get(i).equals("U") && !matchResult.get(i)) {
                System.out.print(" X ");
            }
            if (bridge.get(i).equals("U") && matchResult.get(i)) {
                System.out.print("   ");
            }
            if (i == matchResult.size()-1) {
                System.out.println("]\n");
                break;
            }
            System.out.print("|");
        }

    }

}
