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
        bridgeGame.setBridge(bridgeMaker.makeBridge(input));
    }

    public void RUNPROCESS() {
        bridgeGame.increaseGameCount();
        for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
            List<String> bridge = bridgeGame.getBridge();
            List<Boolean> matchResult = bridgeGame.getMatchResult();
            String input = inputView.readMoving();
            boolean match = bridge.get(i).equals(input);
            matchResult.add(match);
            bridgeGame.setMatchResult(matchResult);
            printBridge(matchResult, bridge);
            if (!match) { break; }
            if (i == bridgeGame.getBridgeSize() - 1) {
                bridgeGame.gameSuccecs();
            }
        }
    }

    public boolean SELECTRESTART() {
        if (inputView.readGameCommand().equals("R")) {
            bridgeGame.setMatchResult(new ArrayList<>());
            return true;
        }
        return false;
    }

    public void STOPGAME() {
        System.out.println("최종 게임 결과");
        printBridge(bridgeGame.getMatchResult(),bridgeGame.getBridge());
        String success = "성공";
        if (!bridgeGame.isSuccecs()) { success = "실패"; }
        System.out.println("게임 성공 여부: "+ success);
        System.out.println("총 시도한 횟수: "+ bridgeGame.getGameCount());
    }

    public void printBridge(List<Boolean> matchResult, List<String> bridge) {
        System.out.print("[");
        printBridgeCell(matchResult,bridge,"U");
        System.out.println("]");
        System.out.print("[");
        printBridgeCell(matchResult,bridge,"D");
        System.out.println("]");
    }

    public void printBridgeCell(List<Boolean> matchResult, List<String> bridge, String way) {
        for (int i = 0; i < matchResult.size(); i++) {
            printBridgeCellLoop(matchResult,bridge,way,i);
        }
    }

    public void printBridgeCellLoop(List<Boolean> matchResult, List<String> bridge, String way, int i) {
        if (bridge.get(i).equals(way)) {
            String correct = " O ";
            if (!matchResult.get(i)) { correct = "   "; }
            System.out.print(correct);
        }
        if (!bridge.get(i).equals(way)) {
            String wrong = " X ";
            if (matchResult.get(i)) { wrong = "   "; }
            System.out.print(wrong);
        }
        if (i != matchResult.size()-1) { System.out.print("|"); }
    }

}
