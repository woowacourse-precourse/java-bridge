package bridge;

import bridge.EnumClass.EnumStates;

import java.util.List;
import java.util.Objects;

public class GameStarter {
    private List<String> bridge;
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public GameStarter() {
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        OutputView.printInitialize();
        initializeBridge();
    }

    private void initializeBridge() {
        this.bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
    }

    public void run() {
        EnumStates state = EnumStates.Initialize;
        int tryNumber = 0;
        while (state != EnumStates.Exit && state != EnumStates.Success) {
            EnumStates.Exit.setWorth(tryNumber++);
            state = inGame();
        }
        OutputView.printResult(bridge, state, tryNumber);
    }

    private EnumStates inGame() {
        EnumStates state = EnumStates.In_game;
        while (state == EnumStates.In_game) {
            OutputView.printSelectMessage();
            state = bridgeGame.move(InputView.readMoving(), this.bridge);
            OutputView.printMap(bridge, state);
        }
        if (state == EnumStates.Success) {
            return EnumStates.Success;
        }
        return retry();
    }

    private EnumStates retry() {
        OutputView.printRetryMessage();
        String stateCommand = InputView.readGameCommand();
        if (Objects.equals(stateCommand, EnumStates.Retry.getState())) {
            bridgeGame.retry();
            return EnumStates.Retry;
        }
        return EnumStates.Exit;
    }
}
