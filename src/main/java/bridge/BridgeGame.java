package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int retryCount;
    private final List<String> bridge;
    private final List<String> userList;

    public BridgeGame(int bridgeSize) {
        this.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        this.userList = new ArrayList<>();
        retryCount = 1;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUserList() {
        return userList;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userInput) {
        int idx = userList.size();
        userList.add(userInput);
        if (!bridge.get(idx).equals(userInput)) return false;
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String buff) {
        if (buff.equals(UserResponse.RESTART.stateInfo)) {
            retryCount++;
            userList.clear();
        }
        // quit 일 경우, false 리턴
        return !buff.equals(UserResponse.QUIT.stateInfo);
    }

    public boolean isEnd() {
        if (userList.size() != bridge.size()) return false;
        for (int i = 0; i < bridge.size(); i++) {
            if (!bridge.get(i).equals(userList.get(i))) return false;
        }
        return true;
    }

}
