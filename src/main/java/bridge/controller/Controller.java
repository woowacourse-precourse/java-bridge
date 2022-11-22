package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.exception.BridgeSizeException;
import bridge.exception.GameRestartInputException;
import bridge.exception.MoveInputException;
import bridge.service.BridgeUserInputComparator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {

    private BridgeUserInputComparator bridgeUserInputComparator = new BridgeUserInputComparator();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeSizeException bridgeSizeException = new BridgeSizeException();
    private MoveInputException moveInputException = new MoveInputException();
    private GameRestartInputException gameRestartInputException = new GameRestartInputException();

    public void bridgeGameStart() {
        BridgeGame bridgeGame = setBridgeGame();
        while (!bridgeGame.getIsBridgeGameEnd()) {
            if (!progressBridgeGame(bridgeGame)) {
                retryBridgeGame(bridgeGame);
            }
            isUserInBridgeEnd(bridgeGame);
        }
        printBridgeGameResult(bridgeGame);
    }

    private BridgeGame setBridgeGame() {
        outputView.printGameStart();
        boolean isUserInputValid = true;
        String bridgeSize;
        do {
            outputView.printBridgeSizeQuestion();
            bridgeSize = inputView.getUserInput();
            isUserInputValid = bridgeSizeException.isBridgeSizeValid(bridgeSize);
        } while (!isUserInputValid);
        return new BridgeGame(Integer.valueOf(bridgeSize));
    }

    private boolean progressBridgeGame(BridgeGame bridgeGame) {
        boolean isUserInputValid = true;
        String userMoveInput;
        do {
            outputView.printBridgeGameUpDownQuestion();
            userMoveInput = inputView.getUserInput();
            isUserInputValid = moveInputException.isInputValid(userMoveInput);
        } while (!isUserInputValid);
        return afterUserInput(bridgeGame, userMoveInput);
    }

    private boolean afterUserInput(BridgeGame bridgeGame, String userMoveInput) {
        boolean userInputCompareResult = bridgeUserInputComparator.compareUserInput(bridgeGame,
                userMoveInput);
        outputView.printMap(bridgeGame);
        return userInputCompareResult;
    }

    private void retryBridgeGame(BridgeGame bridgeGame) {
        boolean isUserInputValid = true;
        String userRetryInput;
        do {
            outputView.printRetryBridgeGame();
            userRetryInput = inputView.getUserInput();
            isUserInputValid = gameRestartInputException.isInputValid(userRetryInput);
        } while (!isUserInputValid);
        switchGameStatus(bridgeGame, userRetryInput);
    }

    private void switchGameStatus(BridgeGame bridgeGame, String userRetryInput) {
        if (userRetryInput.equals("R")) {
            retryGame(bridgeGame);
        }
        if (userRetryInput.equals("Q")) {
            quitGame(bridgeGame);
        }
    }

    private void retryGame(BridgeGame bridgeGame) {
        bridgeGame.setBridgeGameEnd(false);
        bridgeGame.setTryCount(bridgeGame.getTryCount() + 1);
    }

    private void quitGame(BridgeGame bridgeGame) {
        bridgeGame.setBridgeGameEnd(true);
    }

    private void isUserInBridgeEnd(BridgeGame bridgeGame) {
        bridgeGame.setBridgeGameEnd(bridgeUserInputComparator.isUserInBridgeGameEnd(bridgeGame));
    }

    private void printBridgeGameResult(BridgeGame bridgeGame) {
        boolean isGameEnd = bridgeUserInputComparator.isUserInBridgeGameEnd(bridgeGame);
        outputView.printResultTitle();
        outputView.printMap(bridgeGame);
        outputView.printResult(isGameEnd, bridgeGame.getTryCount());
    }

}
