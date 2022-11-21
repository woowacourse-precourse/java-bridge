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

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        int count = 0;
        while (bridge.get(count).equals(inputView.readMoving())) {
            count += 1;
            checkCount(count);
            if (count == size) {break;}
        }
        return wrongMovement;
    }

    public void checkCount(int count) {
        if (count == size) {
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

    public void resultPrint() {
        int tryCount = 0;
        while (playMore && wrongMovement) {
            wrongMovement = move();
            if (wrongMovement) {playMore = retry();}
            tryCount += 1;
        }
        outputView.printResult(wrongMovement, tryCount);
    }

    public void play() {
        inputView.gameStart();
        resultPrint();
    }
}
