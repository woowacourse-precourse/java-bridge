package bridge;

import java.util.*;

public class BridgeGameManager {


    public boolean inputChanger(String userUpDown, BridgeGame newGame, UpperBridge upperBridge, LowerBridge lowerBridge) {

        BridgeGameManager newManager = new BridgeGameManager();

        newGame.bridge.add(userUpDown);

        String checkedStatus = checkBridge(userUpDown, newGame);
        newGame.bridgeCheck.add(checkedStatus);
        inputBridge(userUpDown, newGame, checkedStatus, upperBridge, lowerBridge);

        OutputView.printMap(newGame.bridgeCheck);

        if (checkedStatus == "X") {
            newGame.retry(newGame);
            newGame.finish(newGame, false);
            return false;
        }
        return true;

    }

    public void inputBridge(String userUpDown, BridgeGame newGame, String checkedStatus, UpperBridge upperBridge, LowerBridge lowerBridge) {

        System.out.println("checked status" + checkedStatus);
        upperBridge.manageInput(userUpDown, checkedStatus);

        lowerBridge.manageInput(userUpDown, checkedStatus);
        System.out.println("this is upper bridge" + upperBridge.upperStatus);
        System.out.println("this is lower bridge" + lowerBridge.lowerStatus);

    }

    public String checkBridge(String userUpDown, BridgeGame newGame) {
        System.out.println("this is bridge structure" + BridgeMaker.bridgeStructure);
        System.out.println("this is bridge" + newGame.bridge);
        String shouldBe = BridgeMaker.bridgeStructure.get(newGame.bridge.size() - 1);

        if (shouldBe.equals(userUpDown)) {
            return "O";
        }

        return "X";
    }
}
