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
    private RoundStatus roundStatus;
    private BridgeGame bridgeGame;
    private GameVariable gameVariable;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameStatus = GameStatus.SETTING_GAME;
        this.roundStatus = RoundStatus.ROUND_FAIL;
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

                if (gameStatus == GameStatus.GAME_FAIL) {
                    // RETRY_GAME or QUIT_GAME
                    handleGameCommand(GameCommand.from(inputView.readGameCommand()));
                }

                if (gameStatus.isExitGame()) {
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
            moveOneRound(bridge, index);

            if (roundStatus.isRoundFail()) {
                updateGameStatus(GameStatus.GAME_FAIL);
                break;
            }
            if (bridge.isEndOfBridge(index) && roundStatus.isRoundSuccess()) {
                updateGameStatus(GameStatus.GAME_SUCCESS);
            }
        }
    }

    private void moveOneRound(Bridge bridge, int index) {
        RoundStatus roundStatus = bridgeGame.move(bridge.getBridgeDirection(index),
                BridgeDirection.from(inputView.readMoving()));
        updateRoundStatus(roundStatus);
        outputView.printMap(gameVariable.getMaps());
    }

    private void updateGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    private void updateRoundStatus(RoundStatus roundStatus) {
        this.roundStatus = roundStatus;
    }

    private void handleGameCommand(GameCommand gameCommand) {
        gameStatus = GameStatus.fromGameCommand(gameCommand);
        if (gameStatus == GameStatus.RETRY_GAME) {
            bridgeGame.retry();
        }
    }

}
