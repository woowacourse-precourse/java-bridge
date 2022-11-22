package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.User;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private User user = new User(1);
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public String userBridge() {
        return user.toString();
    }

    public int userRetryCount() {
        return user.getRetryCount();
    }

    public boolean userRestartGame(){
        return user.isRestartFlag();
    }

    public void turnOffFlag() {
        user.turnOffFlag();
    }

    public List<String> makeResultBridge(int bridgeSize) {
        return bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String currentBridgeState, String direction) {
        String result = makeAnswer(direction, currentBridgeState);
        addResultBridge(direction.equals("U"), result);
        return result;
    }
    private void addResultBridge(boolean isUp, String result) {
        if(isUp) {
            user.addUpperBridge(result);
            return;
        }
        user.addLowerBridge(result);
    }

    public List<String> calculateRestartOrEnd(String retryOrQuit) {
        if(retryOrQuit.equals("R")) {
            retry();
            return null;
        }
        return List.of(user.toString(), userRetryCount() + "");
    }

    public String makeAnswer(String currentBridgeState, String answer) {
        if(currentBridgeState.equals(answer)) {
            return "O";
        }
        return "X";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.user = new User(user.getRetryCount());
        user.plusRetryCount();
        user.setRestartGame();
    }
}