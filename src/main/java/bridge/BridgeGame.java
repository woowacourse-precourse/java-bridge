package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private static List<String> bridge;
    private static boolean success;

    public void init() {
        outputView.printStart();
        int bridgeSize = getBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        success = false;

        System.out.println(bridge);
    }

    public static int getBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception);
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        for (int i = 0; i < bridge.size(); i++) {
            String moving = getMoving();
            boolean same = bridge.get(i).equals(moving);
            outputView.printMap(bridge, i, same);
            if (!same) {
                return;
            }
        }
        success = true;
    }

    public static String getMoving() {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception);
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        while (true) {
            try {
                String command = inputView.readGameCommand();
                return isRetry(command);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception);
            }
        }
    }

    private boolean isRetry(String command) {
        if (command.equals("R")) {
            return true;
        }
        return false;
    }

    public boolean getSuccess() {
        return success;
    }
}
