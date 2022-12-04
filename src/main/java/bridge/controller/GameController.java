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

    private BridgeGame bridgeGame;
    private GameVariable gameVariable;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

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
                moveRounds(bridge);

                if (gameVariable.isGameFail()) {
                    // RETRY_GAME or QUIT_GAME
                    handleGameCommand(GameCommand.from(inputView.readGameCommand()));
                }

                if (gameVariable.isExitGame()) {
                    break;
                }

            }

            // PRINT_RESULT
            outputView.printResult(gameVariable);

        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

    private void moveRounds(Bridge bridge) {
        for (int index = 0; index < bridge.getBridgeSize(); index++) {
            RoundStatus roundStatus = moveOneRound(bridge, index);

            if (roundStatus.isRoundFail()) {
                updateGameStatus(GameStatus.GAME_FAIL);
                break;
            }
            if (bridge.isEndOfBridge(index) && roundStatus.isRoundSuccess()) {
                updateGameStatus(GameStatus.GAME_SUCCESS);
            }
        }
    }

    private RoundStatus moveOneRound(Bridge bridge, int index) {
        RoundStatus roundStatus = bridgeGame.move(bridge.getBridgeDirection(index),
                BridgeDirection.from(inputView.readMoving()));
        updateRoundStatus(roundStatus);
        outputView.printMap(gameVariable.getMaps());
        return roundStatus;
    }

    private void updateGameStatus(GameStatus gameStatus) {
        gameVariable.updateGameStatus(gameStatus);
    }

    private void updateRoundStatus(RoundStatus roundStatus) {
        gameVariable.updateRoundStatus(roundStatus);
    }

    private void handleGameCommand(GameCommand gameCommand) {
        updateGameStatus(GameStatus.fromGameCommand(gameCommand));
        if (gameVariable.isRetryGame()) {
            bridgeGame.retry();
        }
    }

}
