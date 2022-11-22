package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.validator.BridgeGameCommandValidator;
import bridge.validator.BridgeValidator;
import bridge.view.ErrorView;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final int FIRST_TRY = 1;
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;
    private int tryCount;

    public BridgeGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.outputView.printGameStart();
        this.bridge = makeBridge();
        this.bridgeGame = new BridgeGame(this.bridge.getBridgeSize());
        this.tryCount = FIRST_TRY;
    }

    public void gameStart() {
        playOnce();
        while (!bridgeGame.isWin(this.bridge)) {
            if (!this.bridgeGame.retry(getGameRetry())) {
                break;
            }
            ++this.tryCount;
            playOnce();
        }
    }

    public void finish() {
        this.outputView.printFinalGameResult();
        this.outputView.printMap(this.bridge, this.bridgeGame);
        String result = FAIL;
        if (this.bridgeGame.isWin(this.bridge)) {
            result = SUCCESS;
        }
        this.outputView.printResult(result, this.tryCount);
    }

    private void playOnce() {
        while (!this.bridgeGame.isDone(this.bridge)) {
            this.bridgeGame.move(getMoving());
            this.outputView.printMap(this.bridge, this.bridgeGame);
        }
    }

    private Bridge makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = getBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private int getBridgeSize() {
        while (true) {
            try {
                return BridgeValidator.checkBridgeSize(this.inputView.readBridgeSize());
            } catch (IllegalArgumentException illegalArgumentException) {
                ErrorView.printException(illegalArgumentException);
            }
        }
    }

    private String getMoving() {
        while (true) {
            try {
                return BridgeGameCommandValidator.checkMovingCommandCharacter(this.inputView.readMoving());
            } catch (IllegalArgumentException illegalArgumentException) {
                ErrorView.printException(illegalArgumentException);
            }
        }
    }

    private String getGameRetry() {
        while (true) {
            try {
                return BridgeGameCommandValidator.checkRetryGameCommandCharacter(this.inputView.readGameCommand());
            } catch (IllegalArgumentException illegalArgumentException) {
                ErrorView.printException(illegalArgumentException);
            }
        }
    }
}
