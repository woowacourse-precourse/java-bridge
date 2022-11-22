package bridge.controller;

import static bridge.domain.game.GameRunStatus.makeGameRunStatus;
import static bridge.service.BridgeGame.createGame;
import static bridge.value.GameCommand.QUIT;
import static bridge.view.game.GameResultView.makeGameResultView;
import static bridge.view.game.GameStatusView.makeGameResultStatusView;
import static bridge.view.game.GameStatusView.makeGameStatusView;

import bridge.domain.game.GameRunStatus;
import bridge.service.BridgeGame;
import bridge.value.GameCommand;
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
        run();
        release();
    }

    private void run() {
        while (!gameRunStatus.isStop()) {
            runProcess();
        }
    }

    public void runProcess() {
        if (!canMove()) {
            failProcess();
            return;
        }
        successProcess();
    }

    private void successProcess() {
        bridgeGame.move();

        updateGameRunStatus();

        userIOView.outputGameStatus(makeGameStatusView(bridgeGame.status()));
    }

    private void updateGameRunStatus() {
        if (bridgeGame.isGameSuccess()) {
            gameRunStatus.stop();
        }
    }

    private boolean canMove() {
        return bridgeGame.canMove(userIOView.inputMovingCharacterProcedure());
    }

    private void failProcess() {
        userIOView.outputGameStatus(makeGameResultStatusView(bridgeGame.status()));

        proceedFor(userIOView.inputGameCommandProcedure());
    }

    private void proceedFor(GameCommand gameCommand) {
        if (gameCommand == QUIT) {
            gameRunStatus.stop();
            return;
        }
        bridgeGame.retry();
    }

    private void init() {
        userIOView.initProcedure();

        this.bridgeGame = createGame(userIOView.inputBridgeSizeProcedure());
    }

    private void release() {
        userIOView.releaseProcedure(makeGameResultView(bridgeGame.result()));
    }
}
