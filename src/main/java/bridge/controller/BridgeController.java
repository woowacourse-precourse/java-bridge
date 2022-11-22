package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.User;
import bridge.util.BridgeMaker;
import bridge.util.DataTypeChanger;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    DataTypeChanger dataTypeChanger = new DataTypeChanger();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final StringBuilder upBridge = new StringBuilder("[");
    private final StringBuilder downBridge = new StringBuilder("[");
    private static final String correctBridge = " O ]";
    private static final String wrongBridge = " X ]";
    private static final String emptyBridge = "   ]";

    public void game() {
        BridgeGame bridgeGame = create();
        User user = new User();
        play(bridgeGame, user);
    }

    private BridgeGame create() {
        outputView.printStartBridgeGame();
        outputView.printBridgeLengthQuestion();
        String bridgeSize = inputView.readBridgeSize();
        int size = dataTypeChanger.StringToInteger(bridgeSize);
        return new BridgeGame(bridgeMaker.makeBridge(size));
    }

    private void play(BridgeGame bridgeGame, User user) {
        while (!user.getQuit() && !bridgeGame.comparePositionLength()) {
            outputView.printMoveToWhereQuestion();
            String moveInput = inputView.readMoving();
            checkCorrect(moveInput, bridgeGame, user);
        }
        printResult(bridgeGame, user);
    }

    private void checkCorrect(String moveInput, BridgeGame bridgeGame, User user) {
        if (bridgeGame.checkThisStep(moveInput)) {
            correctCase(moveInput, bridgeGame);
            return;
        }
        wrongCase(moveInput, bridgeGame, user);
    }

    private void correctCase(String moveInput, BridgeGame bridgeGame) {
        correctPrintMap(moveInput);
        printBuilder();
        bridgeGame.move();
        editBuilder(bridgeGame);
    }

    private void wrongCase(String moveInput, BridgeGame bridgeGame, User user) {
        wrongPrintMap(moveInput);
        printBuilder();
        outputView.printRestartOrDoneQuestion();
        String retryInput = inputView.readGameCommand();
        gameRetry(retryInput, bridgeGame, user);
    }

    private void correctPrintMap(String userInputValue) {
        if (userInputValue.equals("U")) {
            upBridge.append(correctBridge);
            downBridge.append(emptyBridge);
            return;
        }
        downBridge.append(correctBridge);
        upBridge.append(emptyBridge);
    }

    private void wrongPrintMap(String userInputValue) {
        if (userInputValue.equals("U")) {
            upBridge.append(wrongBridge);
            downBridge.append(emptyBridge);
            return;
        }
        downBridge.append(wrongBridge);
        upBridge.append(emptyBridge);
    }

    private void initBuilder() {
        upBridge.setLength(0);
        upBridge.append("[");
        downBridge.setLength(0);
        downBridge.append("[");
    }

    private void editBuilder(BridgeGame bridgeGame) {
        if (!bridgeGame.comparePositionLength()) {
            upBridge.replace(upBridge.length() - 1, upBridge.length(), "|");
            downBridge.replace(downBridge.length() - 1, downBridge.length(), "|");
        }
    }

    private void printBuilder() {
        outputView.printMap(upBridge, downBridge);
    }

    private void gameRetry(String retryInput, BridgeGame bridgeGame, User user) {
        if (userRetry(retryInput)) {
            bridgeGame.retry();
            initBuilder();
            user.addPlayCount();
            return;
        }
        user.setQuit();
    }

    private boolean userRetry(String retryInput) {
        return retryInput.equals("R");
    }

    private void printResult(BridgeGame bridgeGame, User user) {
        outputView.printResult(upBridge, downBridge);
        outputView.printSuccessOrDefeat(bridgeGame.comparePositionLength());
        outputView.printPlayerTryCount(user.getPlayCount());
    }
}
