package bridge.controller;

import static bridge.BridgeGame.createGame;
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
        try {
            process();
        } catch(Exception e) {
            outputView.println(e.getMessage());
        }
    }
//TODO 1. 예외 메시지 enum 처리
//TODO 2. 기타 수정사항 있는지 확인하기
//TODO 3. 동작 정확한지 확인하기.
    private void process() {
        outputView.printMessage(GAME_START);
        outputView.lineSeparate();
        initGame();
        while (!gameRunStatus.isStop()) {
            run();
        }
        outputView.printMessage(GAME_RESULT);
        outputView.printResult(makeGameResultView(bridgeGame.result()));
    }

    private void initGame() {
        outputView.printMessage(INPUT_BRIDGE_SIZE);
        this.bridgeGame = createGame(inputView.readBridgeSize());
        outputView.lineSeparate();
    }

    public void run() {
        outputView.printMessage(INPUT_MOVING);
        BridgeCharacter bridgeCharacter = inputView.readMoving();

        if (!bridgeGame.canMove(bridgeCharacter)) {
            outputView.printMap(makeGameResultStatusView(bridgeGame.status()));
            outputView.printMessage(RETRY);
            processFor(inputView.readGameCommand());

            return;
        }

        bridgeGame.move();

        if (bridgeGame.isGameSuccess()) {
            gameRunStatus.stop();
        }

        outputView.printMap(makeGameStatusView(bridgeGame.status()));
    }

    private void processFor(GameCommand gameCommand) {
        if (gameCommand == QUIT) {
            gameRunStatus.stop();
            return;
        }
        bridgeGame.retry();
    }
}
