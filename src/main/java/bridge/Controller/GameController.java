package bridge.Controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.View.InputView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GameController {
    InputView inputView = new InputView();
    BridgeGame bridgeGame = new BridgeGame();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void GAMESTART() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int input = inputView.readBridgeSize();
        bridgeGame.setBridgeSize(input);
        List<String> bridge = bridgeMaker.makeBridge(input);
        bridgeGame.setBridge(bridge);
    }

    public void RUNPROCESS() {
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
        }
    }

    public boolean SELECTRESTART() {
        String input = inputView.readGameCommand();
        if (input.equals("R")) {
            bridgeGame.setMatchResult(new ArrayList<>());
        }
        return input.equals("R");
    }

    public void printBridge(List<Boolean> matchResult, List<String> bridge) {
        for (int i = 0; i < matchResult.size(); i++) {
            if (i == 0) {
                System.out.print("[");
            }
            if (bridge.get(i).equals("U")) {
                if (matchResult.get(i) ) {
                    System.out.print(" O ");
                } if (!matchResult.get(i)) {
                    System.out.print(" X ");
                }
            }
            if (bridge.get(i).equals("D")) {
                System.out.print("   ");
            }
            if (i == matchResult.size()-1) {
                System.out.println("]");
                break;
            }
            System.out.print("|");
        }

        for (int i = 0; i < matchResult.size(); i++) {
            if (i == 0) {
                System.out.print("[");
            }
            if (bridge.get(i).equals("D")) {
                if (matchResult.get(i) ) {
                    System.out.print(" O ");
                } if (!matchResult.get(i)) {
                    System.out.print(" X ");
                }
            }
            if (bridge.get(i).equals("U")) {
                System.out.print("   ");
            }
            if (i == matchResult.size()-1) {
                System.out.println("]");
                break;
            }
            System.out.print("|");
        }

    }

}
