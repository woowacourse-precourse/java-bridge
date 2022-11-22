package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();
    private int gameCount = 1;
    private List<String> bridge;
    private Status status = new Status();

    public void start() {
        outputView.printStart();

        createBridge();

        play();

        outputView.printResult(status, gameCount);
    }

    public void createBridge() {
        outputView.printRequestBridgeSize();
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    public void play() {
        int now = -1;
        while (isNotFinished(now)) {
            if (move(++now)) {
                continue;
            }
            if (isQuit()) {
                break;
            }
            retry();
            now = -1;
        }
    }

    private boolean isNotFinished(int now) {
        return !(bridge.size() - 1 <= now);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int now) {
        outputView.printRequestMoving();
        if (canMove(inputView.readMoving(), bridge.get(now))) {
            status.addSuccess(bridge.get(now));
            outputView.printMap(status);
            return true;
        }
        status.addFail(bridge.get(now));
        outputView.printMap(status);
        return false;
    }

    private boolean canMove(String moving, String now) {
        return now.equals(moving);
    }

    private boolean isQuit() {
        outputView.printRequestGameCommand();
        return inputView.readGameCommand().equals("Q");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameCount++;
        status.reset();
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }
}
