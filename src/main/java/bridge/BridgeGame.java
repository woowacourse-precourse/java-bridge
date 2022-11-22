package bridge;

import ui.InputView;
import ui.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final OutputView outputView;
    private final InputView inputView;
    private List<String> newBridge;
    private int gameTrialCount = 1;

    public BridgeGame(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void move() {
    }

    public void retry() {
    }
}
