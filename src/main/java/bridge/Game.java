package bridge;

import message.InputMessage;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static int count = 0;

    private InputView inputView = new InputView();
    private BridgeGame bridgeGame = new BridgeGame();
    private OutputView outputView = new OutputView();

    public boolean run(Bridge bridge) {
        List<String> upBridge = new ArrayList<>(List.of("[" + " "));
        List<String> downBridge = new ArrayList<>(List.of("[" + " "));
        while (bridgeGame.move(bridge.getBridge(), upBridge, downBridge)) {
            count += 1;
            if (count > bridge.getBridge().size()) {
                return true;
            }
            upBridge.add("|" + " ");
            downBridge.add("|" + " ");
        }
        if (inputView.readGameCommand().equals(InputMessage.REGAME)) {
            upBridge.add("|" + " ");
            downBridge.add("|" + " ");
            return false;
        }
        InputMessage.print(InputMessage.TOTAL_RESULT);
        outputView.printResult(upBridge, downBridge);
        return true;
    }



}
