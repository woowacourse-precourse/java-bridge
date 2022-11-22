package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private final int size;
    private final List<String> bridge;
    int bridgeCount = 0;

    int tryCount = 0;

    String alphabet;
    boolean wrongMovement = true;
    boolean playMore = true;

    public BridgeGame() {
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

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        System.out.println(bridge);
        bridgeCount = -1;
        do {
            alphabet = getAlphabet();
            bridgeCount += 1;
            outputView.printMap(alphabet, bridge, bridgeCount);
            checkCount(bridgeCount);
        } while (bridge.get(bridgeCount).equals(alphabet) && bridgeCount != size -1);
    }

    public boolean getMove() {
        move();
        return wrongMovement;
    }

    public void checkCount(int bridgeCount) {
        if (bridgeCount == size - 1 && bridge.get(bridgeCount).equals(alphabet)) {
            wrongMovement = false;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        if (inputView.readGameCommand().equals("Q")) {
            playMore = false;
        }
        return playMore;
    }

    public void playOneGame() {
        tryCount = 0;
        while (playMore && wrongMovement) {
            outputView.clearResult();
            wrongMovement = getMove();
            if (wrongMovement) {playMore = retry();}
            tryCount += 1;
        }
    }
    public void resultPrint() {
        playOneGame();
        outputView.printFinal();
        outputView.printResult();
        outputView.printResult(wrongMovement, tryCount);
    }

    public void play() {
        inputView.gameStart();
        resultPrint();
    }
}
