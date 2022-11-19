package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private InputView inputView;
    private OutputView outputView;
    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeMaker bridgeMaker;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public void startGame() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        int gameCount = 0;
        while (true) {
            boolean flag = false;
            countGame(gameCount);
            List<String> upperBridge = new ArrayList<>();
            List<String> downBridge = new ArrayList<>();
            for (int i = 0; i < bridge.size(); i++) {
                String moving = inputView.readMoving();
                if (move(moving, bridge.get(i))) {
                    outputView.makeMap(moving, "O", upperBridge, downBridge);
                    outputView.printMap(upperBridge, downBridge);
                } else if (!move(moving, bridge.get(i))) {
                    outputView.makeMap(moving, "X", upperBridge, downBridge);
                    outputView.printMap(upperBridge, downBridge);
                    String gameCommand = inputView.readGameCommand();
                    if (retry(gameCommand)) {
                        flag = true;
                    }
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving, String bridgeBlock) {
        return moving.equals(bridgeBlock);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            return true;
        } else if (gameCommand.equals("Q")) {
            return false;
        }
        return false;
    }

    public void countGame(int gameCount) {
        gameCount += 1;
    }
}
