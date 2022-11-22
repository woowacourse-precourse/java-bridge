package bridge;

import java.util.InputMismatchException;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    private Bridge bridge = null;
    private Bridge userBridge = null;

    private int gameCount = 1;

    public void initBridge(int size) throws IllegalArgumentException, InputMismatchException {
        bridge = new Bridge(size);
        userBridge = new Bridge();
    }
    public void initUserBridge(){
        userBridge = new Bridge();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String input) throws IllegalArgumentException{
        userBridge.addBridge(input);

        int userBridgeSize = userBridge.size() - 1;

        return !userBridge.get(userBridgeSize).equals(bridge.get(userBridgeSize));
    }

    public boolean checkGameEnd(){
        return (bridge.size() == userBridge.size());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retryFlag) throws IllegalArgumentException{
        if (retryFlag.equals("R")){
            gameCount += 1;
            return true;
        }
        return false;
    }

    public int getGameCount(){
        return gameCount;
    }

    public Bridge getBridge() throws CloneNotSupportedException {
        return (Bridge)bridge.clone();
    }

    public Bridge getUserBridge() throws CloneNotSupportedException {
        return (Bridge)userBridge.clone();
    }
}
