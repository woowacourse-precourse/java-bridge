package bridge.view;

import bridge.BridgeGame;
import bridge.Judge;

import java.util.List;

import static bridge.constant.PrintMessage.*;

public class OutputView {

    public void printMap(List<String> upBridge, List<String> downBridge) {
        printBridgeInFormat(upBridge);
        printBridgeInFormat(downBridge);
        System.out.println("");
    }

    public void printBridgeInFormat(List<String> ox) {
        System.out.print(BRIDGE_OPEN);
        for (int i = 0; i < ox.size(); i++) {
            System.out.print(ox.get(i));
            if (i != ox.size() - 1)
                System.out.print(BRIDGE_BAR);
        }
        System.out.println(BRIDGE_CLOSE);
    }

    public void printResult(BridgeGame bridgeGame, int attempts) {

        System.out.println(GAME_RESULT);
        printMap(bridgeGame.getUpBridge(), bridgeGame.getDownBridge());

        Judge judge = new Judge(bridgeGame.getBridge(), bridgeGame.getPlayer());
        System.out.println(SUCCESS_FAIL + judge.isSuccess().getKorean());
        System.out.println(ATTEMPTS_CNT + attempts);
    }
}
