package bridge;

import bridge.domain.Bridge;
import bridge.domain.Command;
import bridge.domain.Player;
import bridge.in.InputView;
import bridge.out.MapViewDto;
import bridge.out.OutputView;
import bridge.service.BridgeGame;
import bridge.service.BridgeMaker;

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
        Command command = inputView.readMoving();
        MoveResponseDto response = bridgeGame.move(command);
        outputView.printMap(new MapViewDto(response));
        if (response.isAllCorrect()) {
            outputView.printResult(response.getResult().getValue(), response.getAttemptCount());
        }
        return response;
    }

    public boolean retry() {
        outputView.askReplay();
        Command command = inputView.readGameCommand();
        RetryResponseDto retry = bridgeGame.retry(command);
        if (retry.isRetryGame()) {
            return Boolean.TRUE;
        }
        outputView.printResult(Boolean.FALSE, retry.getAttemptCount());
        return Boolean.FALSE;
    }
}
