package bridge.controller;

import static bridge.service.BridgeGame.createGame;
import static bridge.domain.game.GameRunStatus.makeGameRunStatus;
import static bridge.message.SystemMessage.GAME_RESULT;
import static bridge.message.SystemMessage.GAME_START;
import static bridge.message.SystemMessage.INPUT_BRIDGE_SIZE;
import static bridge.message.SystemMessage.INPUT_MOVING;
import static bridge.message.SystemMessage.RETRY;
import static bridge.value.GameCommand.QUIT;

import static bridge.view.game.GameResultView.makeGameResultView;
import static bridge.view.game.GameStatusView.makeGameResultStatusView;
import static bridge.view.game.GameStatusView.makeGameStatusView;

import bridge.service.BridgeGame;
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
        try {
            run();
        } catch (Exception e) {
            outputView.println(e.getMessage());
        }
    }

    private void run() {
        initGame();

        while (!gameRunStatus.isStop()) {
            process();
        }
        releaseGame();
    }

    public void process() {
        outputView.printMessage(INPUT_MOVING);
        BridgeCharacter bridgeCharacter = inputView.readMoving();

        if (!bridgeGame.canMove(bridgeCharacter)) {
            gameFailProcess();
            return;
        }
        bridgeGame.move();

        if (bridgeGame.isGameSuccess()) {
            gameRunStatus.stop();
        }
        outputView.printMap(makeGameStatusView(bridgeGame.status()));
    }

    private void gameFailProcess() {
        outputView.printMap(makeGameResultStatusView(bridgeGame.status()));
        outputView.printMessage(RETRY);

        processFor(inputView.readGameCommand());
    }

    private void processFor(GameCommand gameCommand) {
        if (gameCommand == QUIT) {
            gameRunStatus.stop();
            return;
        }
        bridgeGame.retry();
    }

    private void initGame() {
        outputView.printMessage(GAME_START);
        outputView.lineSeparate();
        outputView.printMessage(INPUT_BRIDGE_SIZE);

        this.bridgeGame = createGame(inputView.readBridgeSize());

        outputView.lineSeparate();
    }

    private void releaseGame() {
        outputView.printMessage(GAME_RESULT);
        outputView.printResult(makeGameResultView(bridgeGame.result()));
    }
}
