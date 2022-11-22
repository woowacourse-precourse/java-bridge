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
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int bridgeSize = 0;
        while (true) {
            try {
                bridgeSize = inputView.readBridgeSize();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }


    public boolean getMovingResult(int inputIdx) {
        String inputMoving = "";
        while (true) {
            try {
                inputMoving = inputView.readMoving();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bridgeGame.move(bridge, inputMoving, inputIdx);
    }

    public void printLongMap() {
        System.out.println(bridgeGame.userInputList());
        System.out.println(bridgeGame.getResult());
        outputView.printLongMap(bridgeGame.userInputList(), bridgeGame.getResult());
    }

    public void printShortMap() {
        outputView.printShortMap(bridgeGame.userInputList(), bridgeGame.getResult());
    }

    public void printMap() {
        if (bridgeGame.getUserInputListLength() == 1) {
            printShortMap();
            return;
        }
        printLongMap();
    }

    public List<String> getbridge() {
        return bridge;
    }

    public int getbridgeLength() {
        return bridge.size();
    }
}
