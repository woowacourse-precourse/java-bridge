package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final int INDEX_ZERO = 0;
    private static final String GAME_RETRY = "R";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;
    private final List<String> givenAnswerSheet;
    private int tryCount = 1;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.outputView.printGameStart();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int bridgeSize = inputView.readBridgeSize();
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        this.givenAnswerSheet = new ArrayList<>(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        String givenAnswer = inputView.readMoving();
        this.givenAnswerSheet.add(givenAnswer);
        outputView.printMap(this.bridge, this.givenAnswerSheet);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String retryGame = inputView.readGameCommand();
        if (retryGame.equals(GAME_RETRY)) {
            this.givenAnswerSheet.clear();
            ++this.tryCount;
            return true;
        }
        return false;
    }

    public void finish() {
        String result = FAIL;
        if (isWin()) {
            result = SUCCESS;
        }
        outputView.printResult(result, this.tryCount);
    }

    public boolean isDone() {
        if (!isWin()) {
            return true;
        }
        return this.bridge.getBridgeSize() == this.givenAnswerSheet.size();
    }

    public boolean isWin() {
        for (int i = INDEX_ZERO; i < this.givenAnswerSheet.size(); ++i) {
            if (!this.givenAnswerSheet.get(i).equals(this.bridge.getElementByIndex(i))) {
                return false;
            }
        }
        return true;
    }
}
