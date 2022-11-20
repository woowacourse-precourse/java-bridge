package bridge.controller;

import static bridge.BridgeGame.createGame;
import static bridge.domain.game.GameRunStatus.makeGameRunStatus;
import static bridge.value.GameCommand.QUIT;

import bridge.BridgeGame;
import bridge.domain.game.GameRunStatus;
import bridge.value.BridgeCharacter;
import bridge.value.GameCommand;
import bridge.view.io.InputView;
import bridge.view.io.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameRunStatus gameRunStatus;
    private BridgeGame bridgeGame;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameRunStatus = makeGameRunStatus();
    }

    public void start() {
        while (!gameRunStatus.isStop()) {
            initGame();

            run();
            //결과 표시
        }
        //최종 결과 표시
    }

    private void initGame() {
        this.bridgeGame = createGame(inputView.readBridgeSize());
    }

    public void run() {
        BridgeCharacter bridgeCharacter = inputView.readMoving();

        if (!bridgeGame.canMove(bridgeCharacter)) {
            processFor(inputView.readGameCommand());

            return;
        }

        bridgeGame.move();

        if (bridgeGame.isGameSuccess()) {
            gameRunStatus.stop();
        }
    }

    private void processFor(GameCommand gameCommand) {
        if (gameCommand == QUIT) {
            gameRunStatus.stop();
            return;
        }
        bridgeGame.retry();
    }
}
