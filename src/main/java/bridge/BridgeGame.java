package bridge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    protected static final String UP = "U";
    protected static final String DOWN = "D";
    protected static final String RETRY = "R";
    protected static final String QUIT = "Q";
    protected static final String O = "O";
    protected static final String X = "X";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker;

    private int count;
    private boolean isSuccess;
    private List<String> bridge;
    private Deque<String> bridgeIndex;

    public BridgeGame() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        count = 0;
    }

    public void game() {
        start();
        while (!(crossingBridge() || quit()))
            ;
        outputView.printResult(isSuccess, count);
    }

    private void start() {
        inputView.printGameStart();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    private boolean crossingBridge() {
        outputView.initMap();
        bridgeIndex = new ArrayDeque<>(bridge);
        count++;
        isSuccess = true;
        while (!bridgeIndex.isEmpty() && (isSuccess = move()))
            ;
        return isSuccess;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean move() {
        String input = inputView.readMoving();
        String currBridgeIndex = bridgeIndex.poll();
        outputView.writeMap(currBridgeIndex, input);
        outputView.printMap();
        return outputView.getOX(currBridgeIndex, input).equals(O);
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean quit() {
        String command = inputView.readGameCommand();
        return command.equals(QUIT);
    }
}