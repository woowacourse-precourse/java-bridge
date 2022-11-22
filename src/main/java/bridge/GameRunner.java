package bridge;

import bridge.Util.COMMAND_CONSTANTS;
import bridge.Util.GAME_STATE;

import java.util.List;
import java.util.Objects;

public class GameRunner {
    private List<String> bridge;
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public GameRunner() {
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        OutputView.printInitialize();
        initializeBridge();
    }

    private void initializeBridge() {
        this.bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
    }

    // whole game process loop
    public void run() {
        GAME_STATE state = GAME_STATE.INITIALIZED;
        int tryNumber = 0;
        while (state != GAME_STATE.QUIT && state != GAME_STATE.SUCCESS) {
            GAME_STATE.QUIT.setValue(tryNumber + 1);
            state = inGame();
        }
        OutputView.printResult(bridge, state);
    }

    // each game loop's inner loop
    private GAME_STATE inGame() {
        GAME_STATE state = GAME_STATE.IN_GAME;
        System.out.println(bridge);
        while (state == GAME_STATE.IN_GAME) {
            OutputView.printSelectMessage();
            state = bridgeGame.move(InputView.readMoving(), this.bridge);
            OutputView.printMap(bridge, state);
        }
        if (state == GAME_STATE.SUCCESS) { // game win
            return GAME_STATE.SUCCESS;
        }
        return retry();
    }

    private GAME_STATE retry() {
        OutputView.printRetryMessage();
        String stateCommand = InputView.readGameCommand();
        if (Objects.equals(stateCommand, GAME_STATE.RETRY.getState())) {
            bridgeGame.retry();
            return GAME_STATE.RETRY;
        }
        return GAME_STATE.QUIT;
    }
}
