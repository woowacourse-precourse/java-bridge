package bridge;

import java.util.*;

public class BridgeGameManager {


    public boolean inputChanger(String userUpDown, BridgeGame newGame, UpperBridge upperBridge, LowerBridge lowerBridge) {

        BridgeGameManager newManager = new BridgeGameManager();

        newGame.bridge.add(userUpDown);
        String checkedStatus = checkBridge(userUpDown, newGame);
        newGame.bridgeCheck.add(checkedStatus);
        inputBridge(userUpDown, newGame, checkedStatus, upperBridge, lowerBridge);
        OutputView.printMap(upperBridge, lowerBridge);
        System.out.println();
        if (checkedStatus == "X") {
            newGame.retry(newGame, upperBridge, lowerBridge);
            return false;
        }
        return true;

    }

    public void inputBridge(String userUpDown, BridgeGame newGame, String checkedStatus, UpperBridge upperBridge, LowerBridge lowerBridge) {

        upperBridge.manageInput(userUpDown, checkedStatus);
        lowerBridge.manageInput(userUpDown, checkedStatus);
    }

    public String checkBridge(String userUpDown, BridgeGame newGame) {
        String shouldBe = BridgeMaker.bridgeStructure.get(newGame.bridge.size() - 1);

        if (shouldBe.equals(userUpDown)) {
            return "O";
        }
        return "X";
    }
    public static void finish(String successOrFail,UpperBridge upperBridge, LowerBridge lowerBridge) {
        OutputView.printResult(successOrFail, upperBridge, lowerBridge);
    }
}
