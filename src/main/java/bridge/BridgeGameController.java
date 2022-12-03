package bridge;

import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.in.InputView;
import bridge.output.MapViewDto;
import bridge.output.OutputView;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void init() {
        outputView.printGettingStart();
        int bridgeSize = inputView.readBridgeSize();
        Bridge bridge = Bridge.mapToBridge(bridgeMaker.makeBridge(bridgeSize));
        Player player = new Player();
        bridgeGame = new BridgeGame(bridge, player);
    }

    public MoveResponseDto move() {
        outputView.askCommand();
        String command = inputView.readMoving();
        MoveResponseDto response = bridgeGame.move(command);
        outputView.printMap(new MapViewDto(response));
        if (response.isAllCorrect()) {
            outputView.printResult(response.getResult().getValue(), response.getAttemptCount());
        }
        return response;
    }

    public boolean retry() {
        outputView.askReplay();
        RetryResponseDto retry = bridgeGame.retry(inputView.readGameCommand());
        if (retry.isRetryGame()) {
            outputView.retry();
            return Boolean.TRUE;
        }
        outputView.printResult(Boolean.FALSE, retry.getAttemptCount());
        return Boolean.FALSE;
    }
}
