package bridge;

import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private List<String> bridge;
    private final BridgeGame bridgeGame = new BridgeGame();
    private final OutputView outputView = new OutputView();

    public void getSizeAndMakeBridge() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int bridgeSize = 0;
        try {
            bridgeSize = inputView.readBridgeSize();
        } catch (Error e) {
            bridgeSize = inputView.readBridgeSize();
        }
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public boolean getMovingResult(int inputIdx) {
        String inputMoving = "";
        try {
            inputMoving = inputView.readMoving();
        } catch (Error e) {
            inputMoving = inputView.readMoving();
        }
        return bridgeGame.move(bridge, inputMoving, inputIdx);
    }

    public void printLongMap(List<String> userInput, List<Boolean> result) {
        outputView.printLongMap(userInput, result);
    }

    public void printShortMap(List<String> userInput, List<Boolean> result){
        outputView.printShortMap(userInput,result);
    }
    public List<String> getbridge() {
        return bridge;
    }
}
