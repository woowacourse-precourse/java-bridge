package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {

    public static List<List<String>> upAndDown = new ArrayList<>();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame = new BridgeGame();
    private static List<String> bridges;
    private static Boolean trueOrFalse = true;
    private static int triedNumber = 0;
    private static String successOrFail = "";

    public void init() {

        int inputSize = getBridgeSize();
        bridges = makeRandomBridges(inputSize);

        while (trueOrFalse) {
            String inputMoving = inputView.readMoving();
            triedNumber = getTriedNumber(inputSize, inputMoving);
        }
//        printResult();
    }

    private int getBridgeSize() {
        return inputView.readBridgeSize();
    }

    private List<String> makeRandomBridges(int inputSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(inputSize);
    }

    private int getTriedNumber(int inputSize, String inputMoving) {
        cleanAndAdd();

        int lengthOfBridge = 0;
        lengthOfBridge = startGame(inputSize, lengthOfBridge, inputMoving);
        successOrFail = getSuccess(inputSize, lengthOfBridge);
        trueOrFalse = getFalse();

        triedNumber++;

        return triedNumber;
    }

    private void cleanAndAdd() {
        List<String> upFloor = new ArrayList<>();
        List<String> downFloor = new ArrayList<>();
        upAndDown.add(upFloor);
        upAndDown.add(downFloor);
    }

    private static int startGame(int inputSize, int lengthOfBridge, String inputMoving) {
        while (lengthOfBridge < inputSize) {
            lengthOfBridge = bridgeGame.move(bridges, lengthOfBridge, inputMoving);

            List<String> toStringBridges = new ArrayList<>();
            toAddforBridges(toStringBridges);
            outputView.printMap(toStringBridges);
            lengthOfBridge++;
        }
        return lengthOfBridge;
    }

    private static void toAddforBridges(List<String> toStringBridges) {
        String upToString = String.join("", upAndDown.get(0).subList(0, upAndDown.get(0).size()-1));
        String downToString = String.join("", upAndDown.get(1).subList(0, upAndDown.get(1).size()-1));

        toStringBridges.add("[" + upToString + "]");
        toStringBridges.add("[" + downToString + "]");
    }

    private static String getSuccess(int inputSize, int count) {
        if (count == inputSize) {
            return "성공";
        }
        return getSuccessOrFail();
    }

    private static String getSuccessOrFail() {
        String startOrEnd = inputView.readGameCommand();
        return bridgeGame.retry(startOrEnd);
    }

    private boolean getFalse() {
        if (!successOrFail.isEmpty()) {
            return false;
        }
        return true;
    }


}

