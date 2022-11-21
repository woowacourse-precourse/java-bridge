package bridge.controller;

import static bridge.service.BridgeGame.createGame;
import static bridge.domain.game.GameRunStatus.makeGameRunStatus;
import static bridge.value.GameCommand.QUIT;

import static bridge.view.game.GameResultView.makeGameResultView;
import static bridge.view.game.GameStatusView.makeGameResultStatusView;
import static bridge.view.game.GameStatusView.makeGameStatusView;

import bridge.service.BridgeGame;
import bridge.domain.game.GameRunStatus;
import bridge.value.BridgeCharacter;
import bridge.value.GameCommand;
import bridge.view.game.GameStatusView;
import bridge.view.io.UserIOView;

public class BridgeGameController {

    private final UserIOView userIOView;
    private final GameRunStatus gameRunStatus;
    private BridgeGame bridgeGame;

    public BridgeGameController(UserIOView userIOView) {
        this.userIOView = userIOView;
        this.gameRunStatus = makeGameRunStatus();
    }

    public void start() {
        init();
        process();
        release();
    }

    private void process() {
        while (!gameRunStatus.isStop()) {
            run();
        }
    }

    public void run() {
        BridgeCharacter bridgeCharacter = userIOView.inputMovingCharacterProcess();

        if (!bridgeGame.canMove(bridgeCharacter)) {
            gameFailProcess();
            return;
        }
        bridgeGame.move();

        if (bridgeGame.isGameSuccess()) {
            gameRunStatus.stop();
        }

        userIOView.outputGameStatus(makeGameStatusView(bridgeGame.status()));
    }

    private void gameFailProcess() {
        GameStatusView gameStatusView = makeGameResultStatusView(bridgeGame.status());
        proceedFor(userIOView.inputGameCommandProcess(gameStatusView));
    }
    private void proceedFor(GameCommand gameCommand) {
        if (gameCommand == QUIT) {
            gameRunStatus.stop();
            return;
        }
        bridgeGame.retry();
    }

    private void init() {
        userIOView.initProcess();

        this.bridgeGame = createGame(userIOView.inputBridgeSizeProcess());
    }

    private void release() {
        userIOView.releaseProcess(makeGameResultView(bridgeGame.result()));
    }
}
