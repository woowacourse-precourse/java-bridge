package bridge;

import java.util.Collections;
import java.util.List;
import java.util.stream.DoubleStream;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */

public class BridgeGame {

    Application application = new Application();


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        int randomNumber = BridgeNumberGenerator();
        // U == 1, D == 0일 때 성공
        if ((moving.equals("U") && randomNumber == 1) || (moving.equals("D") && randomNumber == 0)) {
            System.out.println("성공");
            return true;
        }
        System.out.println("실패");
        return false;
    }

    public List<Bridge> moveBridge(boolean isMove, String bridgeMove, List<Bridge> bridge) {
        if (isMove) {
            return successMoveBridge(bridgeMove, bridge);
        }
        return bridgeMoveFail(bridgeMove, bridge);
    }

    public List<Bridge> successMoveBridge(String bridgeMove, List<Bridge> bridge) {
        if (bridgeMove.equals("U")) {
            return successBridgeUp(bridge);
        }
        return successBridgeDown(bridge);
    }

    public List<Bridge> bridgeMoveFail(String bridgeMove, List<Bridge> bridge) {
        if (bridgeMove.equals("U")) {
            return failBridgeUp(bridge);
        }
        return failBridgeDown(bridge);
    }

    public List<Bridge> successBridgeUp(List<Bridge> bridge) {
        String bridgeUp = bridge.get(0).getBridge().get(application.getBridgeCount()).replace("   ", " O ");
        bridge.get(0).getBridge().set(application.getBridgeCount(), bridgeUp);
        return bridge;
    }

    public List<Bridge> successBridgeDown(List<Bridge> bridge) {
        String bridgeUp = bridge.get(1).getBridge().get(application.getBridgeCount()).replace("   ", " O ");
        bridge.get(1).getBridge().set(application.getBridgeCount(), bridgeUp);
        return bridge;
    }

    public List<Bridge> failBridgeUp(List<Bridge> bridge) {
        String bridgeUp = bridge.get(0).getBridge().get(application.getBridgeCount()).replace("   ", " X ");
        bridge.get(0).getBridge().set(application.getBridgeCount(), bridgeUp);
        return bridge;
    }

    public List<Bridge> failBridgeDown(List<Bridge> bridge) {
        String bridgeDown = bridge.get(1).getBridge().get(application.getBridgeCount()).replace("   ", " X ");
        bridge.get(1).getBridge().set(application.getBridgeCount(), bridgeDown);
        return bridge;
    }

    public int BridgeNumberGenerator() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        int randomNumber = bridgeRandomNumberGenerator.generate();
        return randomNumber;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameRetry) {
        if(gameRetry.equals("R")){
            return true;
        }
        return false;
    }

}
