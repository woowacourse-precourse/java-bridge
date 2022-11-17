package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    private static final String WIN_GAME = "성공";
    private static final String LOSE_GAME = "실패";

    private int trials = 1;
    private final List<String> moving = new ArrayList<>();
    private final List<String> upBridgeResult = new ArrayList<>();
    private final List<String> downBridgeResult = new ArrayList<>();

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        setGame();
    }

    public void setGame() {
        outputView.printStart();
        List<String> bridge = getBridge();
    }

    private List<String> getBridge() {
        List<String> bridge = new ArrayList<>();
        int size = 0;
        try {
            size = inputView.readBridgeSize();
            bridge = bridgeMaker.makeBridge(size);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            getBridge();
        }
        return bridge;
    }
}
