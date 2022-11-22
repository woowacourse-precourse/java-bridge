package bridge.game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Model;

import java.util.List;

import static bridge.game.GameState.*;
import static bridge.io.IO_msg.*;
import static bridge.model.Model.*;

public class BridgeGame {

    public static int tryCount;
    public int indexOfBridge;

    public BridgeGame(int bridgeSize) {
        Model.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        indexOfBridge = 0;
        tryCount = 1;
    }

    /**
     * about the input command, compare with created bridge(at correspond position in rounds).
     * then, add the game result map to Model(upperBridgeMap and lowerBridgeMap respectively).
     * then, return game state.
     *
     * @param moveCommand
     * @return
     * 0 : the state code represent 'On game'<br>
     * 1 : the state code represent "Game over'<br>
     * 2 : the state code represent 'Game clear(success)'
     */
    public int move(String moveCommand) {
        String bridgeStateAtIndex = Model.bridge.get(indexOfBridge);
        addBridgeMapForTrue(bridgeStateAtIndex, moveCommand);
        addBridgeMapForFalse(bridgeStateAtIndex, moveCommand);
        indexOfBridge++;
        return gameState();
    }
    private void addBridgeMapForTrue(String bridgeEachRound, String moveCommand) {
        if (moveCommand.equals(U.msg) && bridgeEachRound.equals(moveCommand)) {
            Model.upperBridgeMap.add(O.msg);
            Model.lowerBridgeMap.add(BLANK.msg);
        }
        if (moveCommand.equals(D.msg) && bridgeEachRound.equals(moveCommand)) {
            Model.upperBridgeMap.add(BLANK.msg);
            Model.lowerBridgeMap.add(O.msg);
        }
    }
    private void addBridgeMapForFalse(String bridgeEachRound, String moveCommand) {
        if (moveCommand.equals(U.msg) && !bridgeEachRound.equals(moveCommand)) {
            Model.upperBridgeMap.add(X.msg);
            Model.lowerBridgeMap.add(BLANK.msg);
        }
        if (moveCommand.equals(D.msg) && !bridgeEachRound.equals(moveCommand)) {
            Model.upperBridgeMap.add(BLANK.msg);
            Model.lowerBridgeMap.add(X.msg);
        }
    }

    private int gameState() {
        String upperLastElement = lastElementOfList(upperBridgeMap);
        String lowerLastElement = lastElementOfList(lowerBridgeMap);
        return calculateGameState(upperLastElement, lowerLastElement);
    }
    private int calculateGameState(String upperElement, String lowerElement) {
        if (upperElement.equals(X.msg) || lowerElement.equals(X.msg)) {
            return GAME_OVER_STATE.value;
        }
        if ((upperElement.equals(O.msg) || lowerElement.equals(O.msg)) && indexOfBridge == bridge.size()) {
            return GAME_CLEAR_STATE.value;
        }
        return GAME_ON_STATE.value;
    }
    private String lastElementOfList(List<String> list) {
        return list.get(list.size()-1);
    }

    /**
     * if the bridge game is over, decide the game state through input game command "R" or "Q".
     * if the input command is "R", initialize the related variables.
     *
     * @param gameCommand
     * @return decided game state
     */
    public int retry(String gameCommand) {
        if (gameCommand.equals(R.msg)) {
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
