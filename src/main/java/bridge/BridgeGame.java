package bridge;

import bridge.messages.InputMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private InputView inputView;
    private OutputView outputView;
    private int tryCount = 0;
    private final int counting = 1;
    private final String quit = "Q";
    private final boolean willRetry = true;
    private final boolean willNotRetry = false;

    public BridgeGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    /**
     * 사용자가 게임을 시작할 때 사용하는 메서드
     */
    public void start() {
        outputView.printStartMessage();
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        List<String> moves = new ArrayList<>();
        boolean retry = play(bridgeSize, bridge, moves);
        while (retry) {
            retry = retry(bridgeSize, bridge, moves);
        }
        outputView.printResult(moves, bridge, tryCount);
    }

    /**
     * 실제 게임이 진행되는 메서드
     */
    private boolean play(int bridgeSize, List<String> bridge, List<String> moves) {
        tryCount = tryCount + counting;
        moves.clear();
        for (int i = 0; i < bridgeSize; ++i) {
            move(moves);
            outputView.printMap(moves, bridge);
            if (!isRightMove(moves.get(i), bridge.get(i))) {
                return willRetry;
            }
        }
        return willNotRetry;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> moves) {
        String moveDirection = inputView.readMoving();
        moves.add(moveDirection);
    }

    private boolean isRightMove(String movedDirection, String answerDirection) {
        return movedDirection.equals(answerDirection);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(int bridgeSize, List<String> bridge, List<String> moves) {
        String retryInput = inputView.readGameCommand();
        if (retryInput.equals(quit)) {
            return false;
        }
        return play(bridgeSize, bridge, moves);
    }
}
