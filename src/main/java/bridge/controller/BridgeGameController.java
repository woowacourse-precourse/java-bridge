package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.config.NumberGeneratorDependencyContainer;
import bridge.service.BridgeGame;
import bridge.view.iterator.BridgeLengthInputIterator;
import bridge.view.iterator.MoveInputIterator;
import bridge.view.OutputView;
import bridge.view.iterator.RestartInputIterator;
import bridge.vo.GameProgressMessage;

import java.util.List;

public class BridgeGameController {

    private InputController inputController;
    private OutputView outputView;
    private List<StringBuilder> currentBridgeStatus;
    private BridgeGame bridgeGame;
    private BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeGameController(NumberGeneratorDependencyContainer numberGeneratorDependencyContainer) {
        inputController = new InputController();
        outputView = new OutputView();
        bridgeNumberGenerator = numberGeneratorDependencyContainer.bridgeNumberGenerator();
    }

    public void setUpGame() {
        outputView.printGameProgressMessage(GameProgressMessage.GAME_START_MESSAGE);
        String inputLength = inputController.getInput(new BridgeLengthInputIterator());

        List<String> createdBridge = new BridgeMaker(bridgeNumberGenerator)
                .makeBridge(Integer.parseInt(inputLength));

        bridgeGame = new BridgeGame(createdBridge);
        outputView.printSpace();
    }

    public void move() {
        while (!bridgeGame.isUserDead() && !bridgeGame.checkPlayerCrossedAllBridge()) {
            String stepInput = inputController.getInput(new MoveInputIterator());
            currentBridgeStatus = bridgeGame.move(stepInput);
            outputView.printMap(currentBridgeStatus);
        }
    }

    public void printResult() {
        long gameTryCount = bridgeGame.getGameTryCount();

        String gameResultMessage = checkGameResultMessage();
        outputView.printResult(currentBridgeStatus, gameTryCount, gameResultMessage);
    }

    public String checkGameResultMessage() {
        final String SUCCESS_MESSAGE = "성공";
        final String FAIL_MESSAGE = "실패";

        if (bridgeGame.checkPlayerCrossedAllBridge()) {
            return SUCCESS_MESSAGE;
        }

        return FAIL_MESSAGE;
    }

    public boolean GameKeepGoingOrNot() {
        if (!bridgeGame.checkPlayerCrossedAllBridge()) {
            String retryInput = inputController.getInput(new RestartInputIterator());

            return bridgeGame.retry(retryInput);
        }
        return false;
    }

    public void exceptionalGameEnd(String errorMessage) {
        outputView.printErrorMessage(errorMessage);
    }
}
