package bridge;

public class BridgeGameManager {


    public boolean addInputToBridge(String userUpDown, BridgeGame newGame, UpperBridge upperBridge, LowerBridge lowerBridge) {
        newGame.bridge.add(userUpDown);
        String checkedStatus = checkBridge(userUpDown, newGame);
        newGame.bridgeCheck.add(checkedStatus);

        setBridge(userUpDown, newGame, checkedStatus, upperBridge, lowerBridge);
        printBridge(upperBridge, lowerBridge);

        return checkStatus(checkedStatus, newGame, upperBridge, lowerBridge);
    }

    public boolean checkStatus(String checkedStatus, BridgeGame newGame, UpperBridge upperBridge, LowerBridge lowerBridge){
        if (checkedStatus == "X") {
            newGame.retry(newGame, upperBridge, lowerBridge);
            return false;
        }
        return true;
    }


    public void printBridge(UpperBridge upperBridge, LowerBridge lowerBridge){
        OutputView.printMap(upperBridge, lowerBridge);
        System.out.println();
    }

    public void setBridge(String userUpDown, BridgeGame newGame, String checkedStatus, UpperBridge upperBridge, LowerBridge lowerBridge) {
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
