package bridge.controller;

import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.enumeration.ExceptionMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {

    public static List<List<String>> upAndDown = new ArrayList<>();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame = new BridgeGame();
    public static int inputSize;
    private static List<String> bridges;
    private static Boolean trueOrFalse = true;
    private static int attempts = 0;
    private static String successOrFail = "";
    private static List<String> upFloor = new ArrayList<>();
    private static List<String> downFloor = new ArrayList<>();

    public void init() {

        inputSize = getBridgeSize();
        bridges = makeRandomBridges(inputSize);

        while (trueOrFalse) {
            attempts = getAttempts(inputSize);
        }
        printResult();
    }

    private int getBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_ONLY_NUMBER.getExceptionMessage());
        }
    }

    private List<String> makeRandomBridges(int inputSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(inputSize);
    }

    private int getAttempts(int inputSize) {;
        cleanAndAdd();
        int lengthOfBridge = 0;
        lengthOfBridge = startGame(inputSize, lengthOfBridge);
        successOrFail = getSuccess(inputSize, lengthOfBridge);
        trueOrFalse = getFalse();

        attempts++;

        return attempts;
    }

    private void cleanAndAdd() {
        upFloor.clear();
        downFloor.clear();
        upAndDown.add(upFloor);
        upAndDown.add(downFloor);
    }

    private int startGame(int inputSize, int lengthOfBridge) {
        while (lengthOfBridge < inputSize) {
            String inputMoving = getInputMoving();
            lengthOfBridge = bridgeGame.move(bridges, lengthOfBridge, inputMoving);

            List<String> toStringBridges = new ArrayList<>();
            addforBridges(toStringBridges);
            outputView.printMap(toStringBridges);
            lengthOfBridge++;
        }
        return lengthOfBridge;
    }

    private String getInputMoving() {

        String inputMoving = inputView.readMoving();

        if (!inputMoving.equals("U") && !inputMoving.equals("D")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MOVING_COMMAND.getExceptionMessage());
        }
        return inputMoving;
    }

    private static void addforBridges(List<String> toStringBridges) {
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
        String restartOrEnd = inputView.readGameCommand();
        return bridgeGame.retry(restartOrEnd);
    }

    private boolean getFalse() {
        if (!successOrFail.isEmpty()) {
            return false;
        }
        return true;
    }

    private static void printResult() {

        List<String> finalMap = new ArrayList<>();
        addforBridges(finalMap);

        outputView.printResult(finalMap, successOrFail, attempts);
    }
}

