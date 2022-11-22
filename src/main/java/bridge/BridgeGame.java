package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    private List<String> bridge = new ArrayList<>();
    private List<String> userInput = new ArrayList<>();
    private int userLocation = 0;
    private int cnt = 1;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void run() {
        outputView.startMessage();
        int bridgeSize = inputView.readBridgeSize();
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        while (userLocation < bridgeSize) {
            String moving = inputView.readMoving();
            userInput.add(moving);
            move(moving);
            userLocation++;
        }
        outputView.printResult(bridge, userInput, cnt);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        outputView.printMap(bridge, userInput);
        if (!canMove(moving)) {
            retry();
        }
    }

    public boolean canMove(String moving) {
        return bridge.get(userLocation).equals(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("R")) {
            userLocation = -1;
            userInput.clear();
            cnt++;
        }
        if (gameCommand.equals("Q")) {
            userLocation = bridge.size();
        }
    }
}
