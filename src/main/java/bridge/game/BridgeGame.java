package bridge.game;

import bridge.BridgeRandomNumberGenerator;
import java.util.List;

import static bridge.game.GameState.*;
import static bridge.model.Model.*;

public class BridgeGame {

    public static int tryCount;
    public int indexOfBridge;

    public BridgeGame(int bridgeSize) {
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        indexOfBridge = 0;
        tryCount = 1;
    }


    public int move(String moveCommand) {
        String bridgeStateAtIndex = bridge.get(indexOfBridge);
        addBridgeMapForTrue(bridgeStateAtIndex, moveCommand);
        addBridgeMapForFalse(bridgeStateAtIndex, moveCommand);
        indexOfBridge++;
        return gameState();
    }
    private void addBridgeMapForTrue(String bridgeEachRound, String moveCommand) {
        if (moveCommand.equals("U") && bridgeEachRound.equals(moveCommand)) {
            upperBridgeMap.add("O");
            lowerBridgeMap.add(" ");
        }
        if (moveCommand.equals("D") && bridgeEachRound.equals(moveCommand)) {
            upperBridgeMap.add(" ");
            lowerBridgeMap.add("O");
        }
    }
    private void addBridgeMapForFalse(String bridgeEachRound, String moveCommand) {
        if (moveCommand.equals("U") && !bridgeEachRound.equals(moveCommand)) {
            upperBridgeMap.add("X");
            lowerBridgeMap.add(" ");
        }
        if (moveCommand.equals("D") && !bridgeEachRound.equals(moveCommand)) {
            upperBridgeMap.add(" ");
            lowerBridgeMap.add("X");
        }
    }


    public int gameState() {
        String upperLastElement = lastElementOfList(upperBridgeMap);
        String lowerLastElement = lastElementOfList(lowerBridgeMap);
        if (upperLastElement.equals("X") || lowerLastElement.equals("X")) {
            return GAME_OVER_STATE.value;
        }
        if ((upperLastElement.equals("O") || lowerLastElement.equals("O")) && indexOfBridge == bridge.size()) {
            return GAME_CLEAR_STATE.value;
        }
        return GAME_ON_STATE.value;
    }
    private String lastElementOfList(List<String> list) {
        return list.get(list.size()-1);
    }


    public int retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            operateRetry();
            return 0;
        }
        return 2;
    }
    private void operateRetry() {
        indexOfBridge = 0;
        tryCount++;
        clearBridgeMap();
    }
}
