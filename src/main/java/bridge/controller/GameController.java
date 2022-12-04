package bridge.controller;


import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.bridge.Bridge;
import bridge.model.command.GameCommand;
import bridge.model.game.BridgeGame;
import bridge.model.game.GameVariable;
import bridge.model.status.GameStatus;
import bridge.model.status.RoundStatus;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGame bridgeGame;
    private GameVariable gameVariable;
    private Bridge bridge;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

    }

    public void play() {
        try {
            setGame();
            playGame();
            printResult();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }


    private void setGame() {
        outputView.printStartGame();
        setBridge();
        initializeGameVariables();
    }

    private void setBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridgeList = bridgeMaker.makeBridge(inputView.readBridgeSize());
        bridge = Bridge.from(bridgeList);
    }

    private void initializeGameVariables() {
        gameVariable = GameVariable.byInitialValue();
        bridgeGame = new BridgeGame(gameVariable);
    }

    private void playGame() {
        while (!gameVariable.isExitGame()) {
            moveRounds(bridge);
            handleRoundFail();
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
        RoundStatus roundStatus = bridgeGame.move(bridge.getBridgeDirection(index), inputView.readMoving());
        outputView.printMap(gameVariable.getMaps());
        return roundStatus;
    }

    private void handleRoundFail() {
        if (gameVariable.isGameFail()) {
            handleGameCommand(inputView.readGameCommand());
        }
    }

    private void handleGameCommand(GameCommand gameCommand) {
        updateGameStatus(GameStatus.fromGameCommand(gameCommand));
        if (gameVariable.isRetryGame()) {
            bridgeGame.retry();
        }
    }

    private void updateGameStatus(GameStatus gameStatus) {
        gameVariable.updateGameStatus(gameStatus);
    }

    private void printResult() {
        outputView.printResult(gameVariable);
    }

}
