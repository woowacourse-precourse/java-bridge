package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.vo.Bridge;
import bridge.vo.ErrorMessage;
import bridge.vo.UserStatus;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private UserStatus userStatus;
    private Bridge bridge;
    private int gameTryCount;
    private CurrentBridgeStatusMaker currentBridgeStatusMaker = new CurrentBridgeStatusMaker();

    public BridgeGame(int length) {
        gameTryCount = 1;
        userStatus = new UserStatus();
        List<String> createdBridge
                = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(length);
        bridge = new Bridge(createdBridge);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<StringBuilder> move(String direct) {
        userStatus.addCrossedHistory(direct);

        return currentBridgeStatusMaker
                .convertCurrentBridgeStatus(userStatus.getCurrentCrossedBridge(), bridge.getBridge());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String input) {
        if(input.equals("R")) {
            checkGameTryCountOverIntegerMaxValue();
            gameTryCount++;
            userStatus.clear();
            return true;
        }
        return false;
    }

    public void checkGameTryCountOverIntegerMaxValue() {
        if(gameTryCount == Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.GAME_TRY_COUNT_OVER_MESSAGE.toString());
        }
    }

    public boolean isEnd() {

        return (!isUserDead() && userStatus.getCurrentCrossedBridge().size() == bridge.getBridge().size()
        );
    }

    public boolean isUserDead() {
        return userStatus.getCurrentIndex() != -1 &&
                !userStatus.getCurrentPosition().equals(bridge.getBridge().get(userStatus.getCurrentIndex()));
    }

    public int getGameTryCount() {
        return gameTryCount;
    }
}
