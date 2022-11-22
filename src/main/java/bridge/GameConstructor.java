package bridge;

import java.util.List;

public class GameConstructor {

    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private final int size;
    List<String> bridge;
    int bridgeCount = 0;
    int tryCount = 0;

    String alphabet;
    boolean wrongMovement = true;
    boolean playMore = true;

    public GameConstructor() {
        this.size = getSize();
        this.bridge = getBridge();
    }

    public int getSize() {
        return inputView.readBridgeSize();
    }

    public List<String> getBridge() {
        return bridgeMaker.makeBridge(size);
    }

    public String getAlphabet() {return inputView.readMoving();}

    public void move() {
//        System.out.println(bridge);
        bridgeCount = -1;
        do {
            oneMovement();
        } while (checkIfAnswer());
    }

    public void oneMovement() {
        alphabet = getAlphabet();
        bridgeCount += 1;
        outputView.printMap(alphabet, bridge, bridgeCount);
        getAnswerBool(bridgeCount);
    }

    public boolean checkIfAnswer() {
        return bridge.get(bridgeCount).equals(alphabet) && bridgeCount != size -1;
    }

    public boolean getMoveBool() {
        move();
        return wrongMovement;
    }

    public void getAnswerBool(int bridgeCount) {
        if (bridgeCount == size - 1 && bridge.get(bridgeCount).equals(alphabet)) {
            wrongMovement = false;
        }
    }

    public boolean askForRetry() {
        if (inputView.readGameCommand().equals("Q")) {
            playMore = false;
        }
        return playMore;
    }

    public void resultPrint(int tryCount) {
        outputView.printFinal();
        outputView.printResult();
        outputView.printResult(wrongMovement, tryCount);
    }

    public void clearResult() {
        outputView.clearResult();
        outputView.clearTempResult();
    }
}
