package bridge;

import bridge.service.BridgeGame;
import bridge.service.Referee;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameRun {
    private static final String FAIL_COMMAND_RETRY = "R";
    private static final String FAIL_COMMAND_QUIT = "Q";

    private final InputView inputView;
    private final OutputView outputView;


    public BridgeGameRun(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int bridgeSize = inputView.readBridgeSize();

        BridgeGame bridgeGame = initBridge(bridgeSize);
        while (true) {
            moveBridge(bridgeGame, bridgeSize);
            boolean result = Referee.makeResult(bridgeGame.getMovePath(), bridgeGame.getBridge());
            if (result || !isRetry()) {
                break;
            }
            bridgeGame.retry();
        }
        outputView.printResult(bridgeGame);
    }

    public BridgeGame initBridge(int bridgeSize) {

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        return bridgeGame;
    }

    public void moveBridge(BridgeGame bridgeGame, int bridgeSize) {
        for (int i = 0; i < bridgeSize; i++) {
            String moveCommand = inputView.readMoving();
            bridgeGame.move(moveCommand);

            outputView.printMap(bridgeGame.getMovePath(), bridgeGame.getBridge());

            if (!bridgeGame.checkPossibleMove(i)) {
                break;
            }
        }
    }

    private boolean isRetry() {
        String failCommand = inputView.readGameCommand();
        if (failCommand.equals(FAIL_COMMAND_RETRY)) {
            return true;
        }
        return false;
    }
}
