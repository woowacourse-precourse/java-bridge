package bridge.domain;

import bridge.domain.generator.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<List<String>> bridgeCorrects;
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private List<String> bridge;
    private int cnt = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(String user, int i) {
        List<String> bridgeCorrect = new ArrayList<>();
        up(bridgeCorrect, bridge.get(i), user);
        down(bridgeCorrect, bridge.get(i), user);
        bridgeCorrects.add(bridgeCorrect);
        return bridgeCorrects;
    }

    public void bridgeMaking(int bridgeSize) {
        bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeCorrects = new ArrayList<>();
    }

    private void up(List<String> bridgeCorrect, String bridge, String user) {
        if (user.equals(MessageStorage.UP.getMessage())) {
            if (bridge.equals(user)) {
                addBridgeCorrect(bridgeCorrect, MessageStorage.UP.getMessage(), MessageStorage.CORRECT.getMessage());
            }
            if (!bridge.equals(user)) {
                addBridgeCorrect(bridgeCorrect, MessageStorage.UP.getMessage(), MessageStorage.INCORRECT.getMessage());
            }
        }
    }

    private void down(List<String> bridgeCorrect, String bridge, String user) {
        if (user.equals(MessageStorage.DOWN.getMessage())) {
            if (bridge.equals(user)) {
                addBridgeCorrect(bridgeCorrect, MessageStorage.DOWN.getMessage(), MessageStorage.CORRECT.getMessage());
            }
            if (!bridge.equals(user)) {
                addBridgeCorrect(bridgeCorrect, MessageStorage.DOWN.getMessage(), MessageStorage.INCORRECT.getMessage());
            }
        }
    }

    private void addBridgeCorrect(List<String> bridgeCorrect, String location, String isCorrect) {
        bridgeCorrect.add(location);
        bridgeCorrect.add(isCorrect);
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeCorrects = new ArrayList<>();
        cnt++;
    }

    public List<List<String>> returnResult() {
        return bridgeCorrects;
    }

    public int totalTryTime() {
        return cnt;
    }

    public String isSuccess(int bridgeSize) {
        for (int i = 0; i < bridgeSize; i++) {
            if (returnResult().get(i).get(1).equals(MessageStorage.INCORRECT.getMessage())) {
                return MessageStorage.FAIL.getMessage();
            }
        }
        return MessageStorage.SUCCESS.getMessage();
    }

    public boolean wrongSelect(int i) {
        if (bridgeCorrects.get(i).get(1).equals(MessageStorage.INCORRECT.getMessage())) {
            return false;
        }
        return true;
    }
}
