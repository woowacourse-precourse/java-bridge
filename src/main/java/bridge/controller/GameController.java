package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.GameStatus;
import bridge.model.GameVariable;
import bridge.model.RoundStatus;
import bridge.model.bridge.Bridge;
import bridge.model.bridge.BridgeDirection;
import bridge.model.command.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private GameStatus gameStatus;
    private BridgeGame bridgeGame;
    private GameVariable gameVariable;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameStatus = GameStatus.SETTING_GAME;
    }

    public void play() {
        try {
            // SETTING_GAME
            outputView.printStartGame();

            // CREATING_BRIDGE
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridgeList = bridgeMaker.makeBridge(inputView.readBridgeSize());
            System.out.println(bridgeList);
            Bridge bridge = Bridge.from(bridgeList);

            // INITIALIZING_GAME_VARIABLE
            gameVariable = GameVariable.byInitialValue();
            bridgeGame = new BridgeGame(gameVariable);

            while (true) {

                // START_GAME
                for (int index = 0; index < bridge.getBridgeSize(); index++) {
                    RoundStatus roundStatus = bridgeGame.move(bridge.getBridgeDirection(index),
                            BridgeDirection.from(inputView.readMoving()));
                    updateGameStatus(roundStatus);
                    outputView.printMap(gameVariable.getMaps());

                    if (!gameStatus.isContinueRounds()) {
                        break;
                    }

                    if (bridge.isEndOfBridge(index) && gameStatus == GameStatus.ROUND_SUCCESS) {
                        updateGameStatusToGameSuccess();
                    }

                }

                if (gameStatus == GameStatus.ROUND_FAIL) {
                    handleGameCommand(GameCommand.from(inputView.readGameCommand()));
                }

                if (!gameStatus.isContinueGame()) {
                    break;
                }

            }

            // PRINT_RESULT
            outputView.printResult(gameVariable);

        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

    private void updateGameStatusToGameSuccess() {
        gameStatus = GameStatus.GAME_SUCCESS;
    }

    private void updateGameStatus(RoundStatus roundStatus) {
        gameStatus = GameStatus.fromRoundStatus(roundStatus);
    }

    private void handleGameCommand(GameCommand gameCommand) {
        gameStatus = GameStatus.fromGameCommand(gameCommand);
        if (gameStatus == GameStatus.RETRY_GAME) {
            bridgeGame.retry();
        }
    }

}
