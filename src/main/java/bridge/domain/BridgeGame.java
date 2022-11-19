package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private List<String> userPaths;
    private int userLocation;
    private int tryCount;

    public BridgeGame(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(bridgeSize);
        userPaths = new ArrayList<>();
        tryCount = 1;
        userLocation = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userPath) {
        userPaths.add(userPath);
        return isRightPath(userLocation++, userPath);
    }

    private boolean isRightPath(int location, String userPath) {
        String currentPath = bridge.get(location);
        return currentPath.equals(userPath);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        initializeUserPaths();
        userLocation = 0;
        tryCount++;
    }

    private void initializeUserPaths() {
        userPaths = new ArrayList<>();
    }

    public List<String> getPassedPaths() {
        return userPaths;
    }
    public int getBridgeLength() {
        return this.bridge.size();
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean doesCrossedBridge() {
        if (userLocation == bridge.size()) {
            return true;
        }

        return false;
        //return userLocatoion >= bridge.size() 가능
    }
}
