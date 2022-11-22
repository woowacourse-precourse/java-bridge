package bridge.controller;

import static bridge.constant.Constant.MOVE_UP;
import static bridge.constant.Constant.correctBridge;
import static bridge.constant.Constant.wrongBridge;
import static bridge.constant.Constant.emptyBridge;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.User;
import bridge.domain.BridgeGame;
import bridge.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private final StringBuilder upBuilder = new StringBuilder("[");
    private final StringBuilder downBuilder = new StringBuilder("[");
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public void game() {
        BridgeGame bridgeGame = create();
        User user = new User();
        Go(bridgeGame, user);
    }

    public BridgeGame create() {
        outputView.printStartBridgeGame();
        outputView.printBridgeLengthQuestion();
        String bridgeSize = inputView.readBridgeSize();
        int size = Integer.parseInt(bridgeSize);
        return new BridgeGame(bridgeMaker.makeBridge(size));
    }

    public void Go(BridgeGame bridgeGame, User user) {
        while (!user.getQuit() && !bridgeGame.comparePositionLength()) {
            outputView.printMoveUpOrDown();
            String moveInput = inputView.readMoving();
            checkCorrect(moveInput, bridgeGame, user);
        }
        printResult(bridgeGame, user);
    }

    public void checkCorrect(String moveInput, BridgeGame bridgeGame, User user) {
        if (bridgeGame.correct(moveInput)) {
            correctCase(moveInput, bridgeGame);
            return;
        }
        wrongCase(moveInput, bridgeGame, user);
    }

    public void editBuilder(BridgeGame bridgeGame) {
        if (!bridgeGame.comparePositionLength()) {
            upBuilder.replace(upBuilder.length() - 1, upBuilder.length(), "|");
            downBuilder.replace(downBuilder.length() - 1, downBuilder.length(), "|");
        }
    }

    public void correctCase(String moveInput, BridgeGame bridgeGame) {
        correctPrintMap(moveInput);
        printBuilder();
        bridgeGame.move();
        editBuilder(bridgeGame);
    }

    public void wrongCase(String moveInput, BridgeGame bridgeGame, User user) {
        wrongPrintMap(moveInput);
        printBuilder();
        outputView.printRestartOrQuit();
        String retryInput = inputView.readGameCommand();
        RetryOrQuit(retryInput, bridgeGame , user);
    }

    public void RetryOrQuit(String retryInput, BridgeGame bridgeGame, User user) {
        if (GoRetry(retryInput)) {
            bridgeGame.retry();
            initBuilder();
            user.addPlayingCount();
            return;
        }
        user.setQuit();
    }

    public boolean GoRetry(String retryInput) {
        return retryInput.equals("R");
    }

    public void printResult(BridgeGame bridgeGame, User user) {
        outputView.printResult(upBuilder, downBuilder);
        outputView.printSuccessOrFailure(bridgeGame.comparePositionLength());
        outputView.printPlayerTryCount(user.getPlayingCount());
    }

    public void correctPrintMap(String userInputValue) {
        if (userInputValue.equals(MOVE_UP)) {
            upBuilder.append(correctBridge);
            downBuilder.append(emptyBridge);
            return;
        }
        downBuilder.append(correctBridge);
        upBuilder.append(emptyBridge);
    }

    public void wrongPrintMap(String userInputValue) {
        if (userInputValue.equals(MOVE_UP)) {
            upBuilder.append(wrongBridge);
            downBuilder.append(emptyBridge);
            return;
        }
        downBuilder.append(wrongBridge);
        upBuilder.append(emptyBridge);
    }
}