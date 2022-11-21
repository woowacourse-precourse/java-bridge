package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.validator.BridgeGameCommandValidator;
import bridge.validator.BridgeValidator;
import bridge.view.ErrorView;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final int FIRST_TRY = 1;
    private static final int INDEX_ZERO = 0;
    private static final String GAME_RETRY = "R";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;
    private final List<String> userAnswerSheet;
    private int tryCount;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.outputView.printGameStart();
        this.bridge = makeBridge();
        this.userAnswerSheet = new ArrayList<>(this.bridge.getBridgeSize());
        this.tryCount = FIRST_TRY;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        this.userAnswerSheet.add(getMoving());
        this.outputView.printMap(this.bridge, this.userAnswerSheet);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        if (getGameRetry().equals(GAME_RETRY)) {
            this.userAnswerSheet.clear();
            ++this.tryCount;
            return true;
        }
        return false;
    }

    public void finish() {
        this.outputView.printFinalGameResult();
        this.outputView.printMap(this.bridge, this.userAnswerSheet);
        String result = FAIL;
        if (isWin()) {
            result = SUCCESS;
        }
        this.outputView.printResult(result, this.tryCount);
    }

    public boolean isDone() {
        if (!isWin()) {
            return true;
        }
        return this.bridge.getBridgeSize() == this.userAnswerSheet.size();
    }

    public boolean isWin() {
        for (int i = INDEX_ZERO; i < this.userAnswerSheet.size(); ++i) {
            if (!this.bridge.getResult(this.userAnswerSheet.get(i), i)) {
                return false;
            }
        }
        return true;
    }

    private Bridge makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = getBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private int getBridgeSize() {
        while (true) {
            try {
                return BridgeValidator.checkBridgeSizeValid(this.inputView.readBridgeSize());
            } catch (IllegalStateException illegalStateException) {
                ErrorView.printException(illegalStateException);
            }
        }
    }

    private String getMoving() {
        while(true) {
            try {
                return BridgeGameCommandValidator.checkMovingCommandCharacter(this.inputView.readMoving());
            } catch (IllegalStateException illegalStateException) {
                ErrorView.printException(illegalStateException);
            }
        }
    }

    private String getGameRetry() {
        while(true) {
            try {
                return BridgeGameCommandValidator.checkRetryGameCommandCharacter(this.inputView.readGameCommand());
            } catch (IllegalStateException illegalStateException) {
                ErrorView.printException(illegalStateException);
            }
        }
    }
}
