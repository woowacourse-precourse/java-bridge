package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private InputController input;
    private Bridge bridge;
    private OutputView output;

    public void init() {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        input = new InputController();
        bridge = new Bridge(bridgeMaker.makeBridge(input.requestBridgeSize()));
        output = new OutputView();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int round, boolean status) {
        while(round < bridge.getSize() && status) {
            String movement = checkMovable(round);
            round += checkO(movement);
            status = checkX(movement);
            output.printMap(round);
            status = retry(status);
        }

        return status;
    }

    public int checkO(String movement) {
        if(movement.equals("O")) {
            return 1;
        }

        return 0;
    }
    public boolean checkX(String movement) {
        return movement.equals("O");
    }

    public String checkMovable(int round) {
        if(input.requestMove().equals("U")) {
            return bridge.getUpperBridge().get(round);
        }

        return bridge.getLowerBridge().get(round);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(boolean status) {
        if(status) {
            return true;
        }

        return input.requestRetry().equals("R");
    }
}
