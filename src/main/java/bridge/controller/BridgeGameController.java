package bridge.controller;

import bridge.domain.ClearStatus;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void gameStart() {
        outputView.printGameStart();
        outputView.printDivisionLine();

        gameSetting(getMakeBridgeSize());
        outputView.printDivisionLine();

        gamePlay();
    }

    private int getMakeBridgeSize() {
        String input;

        do {
            input = inputView.readBridgeSize();
        } while (!validateInputSetting(input));

        return Integer.parseInt(input);
    }

    private boolean validateInputSetting(String userInput) {
        try {
            bridgeGame.validateBridgeSize(userInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return false;
        }

        return true;
    }

    private void gameSetting(int bridgeSize) {
        bridgeGame.initBridge(bridgeSize);
    }

    private void gamePlay() {
        do {
            moveAndResult();
            if (bridgeGame.isClearGame()) {
                break;
            }
        } while (bridgeGame.isRestartGame(getReadGameCommand()));

        getFinalResult();
    }

    private void moveAndResult() {
        bridgeGame.initPlayer();

        do {
            bridgeGame.move(getMoveCommand());
            outputView.printMap(bridgeGame.getBridgeMap());
            outputView.printDivisionLine();
        } while (bridgeGame.moveAgain());
    }

    private String getMoveCommand() {
        String input;
        do {
            input = inputView.readMoveCommand();
        } while (isDisallowInputMoveCommand(input));

        return input;
    }

    private boolean isDisallowInputMoveCommand(String input) {
        try {
            bridgeGame.validateInputMoveCommand(input);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return true;
        }
        return false;
    }

    private String getReadGameCommand() {
        String input;
        do {
            input = inputView.readGameCommand();
        } while (isDisallowInputGameCommand(input));

        return input;
    }

    private boolean isDisallowInputGameCommand(String input) {
        try {
            bridgeGame.validateInputGameCommand(input);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return true;
        }
        return false;
    }

    /**
     * 최종 결과 출력
     * */
    private void getFinalResult() {
        List<List<String>> bridgeMap = bridgeGame.getBridgeMap();

        boolean crossAllBridge = bridgeGame.isCrossAllBridge();
        ClearStatus clearStatus = ClearStatus.getMessageByClear(crossAllBridge);
        String clearMessage = clearStatus.getMessage();

        int tryCount = bridgeGame.getTryCount();

        outputView.printResult(bridgeMap, clearMessage, tryCount);
    }

}
