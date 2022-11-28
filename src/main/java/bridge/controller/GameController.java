package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.OutputView.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    public static int gameCount = 1;
    public static boolean failOrSuccess = true;
    public static List<String> bridgeResult = new ArrayList<>();
    public static StringBuilder first = new StringBuilder();
    public static StringBuilder second = new StringBuilder();

    public void gameStart() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.gameStart();
        int size = InputView.readBridgeSize();
        bridgeResult = bridgeMaker.makeBridge(size);
        gameProgress(inputView, outputView);
        outputView.printResult();
    }

    public void gameProgress(InputView inputView, OutputView outputView) {
        while (bridgeResult.size() > BridgeGame.moveIndex) {
            outputView.moveSpace();
            String moveInput = inputView.readMoving();
            if (BridgeGame.move(moveInput)) {
                gameRetry(inputView, outputView, moveInput);
                continue;
            }
            outputView.printMap(BridgeGame.moveIndex, moveInput, bridgeResult);
            BridgeGame.moveIndex++;
        }
    }

    public void gameRetry(InputView inputView, OutputView outputView, String moveInput) {
        outputView.printMap(BridgeGame.moveIndex, moveInput, bridgeResult);
        outputView.restart();
        String inputRestart = inputView.readGameCommand();
        if (BridgeGame.retry(inputRestart)) {
            BridgeGame.moveIndex = bridgeResult.size();
        }
    }

    public static boolean isValidBridgeNumber(String input) {
        String compare = input.replaceAll("[0-9]", "");
        try {
            if (compare.length() != 0) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER.printMessage());
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return true;
        }
        return false;
    }

    public static boolean isValidBridgeRange(String input) {
        try {
            if (Long.parseLong(input) < 3 || Long.parseLong(input) > 20) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_RANGE.printMessage());
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return true;
        }
        return false;
    }

    public static boolean isValidBridgeAction(String input) {
        try {
            if (!(input.equals("U") || input.equals("D"))) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_UP_DOWN.printMessage());
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return true;
        }
        return false;
    }

    public static boolean isValidBridgeRestart(String input) {
        try {
            if (!(input.equals("R") || input.equals("Q"))) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_RESTART_QUIT.printMessage());
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return true;
        }
        return false;
    }
}
