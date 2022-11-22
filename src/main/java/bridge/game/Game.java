package bridge.game;

import bridge.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Game {
    private static final String DIVIDE_LETTER = "|";
    private final InputView inputView;
    private final OutputView outputView;

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeGame bridgeGame;
    private Bridge bridge;

    private String result;
    private int position;
    private int playCount = 1;
    private List<Bridge> resultBridge;

    public Game() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }
}