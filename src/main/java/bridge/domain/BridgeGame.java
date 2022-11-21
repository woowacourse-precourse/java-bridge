package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private Bridge bridge;
    private User user;

    public void setGameStart(int bridgeSize) {
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        this.user = new User();
    }

    public void setBridge(Bridge bridge){
        user = new User();
        this.bridge = bridge;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public User getUser() {
        return user;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param move
     */
    public void move(String move) {
        user.addMoving(move);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        user.clearMovings();
    }

    public boolean roundClear() {
        List<String> userMovings = user.getMovings();
        return userMovings.get(userMovings.size()-1)
                .equals(bridge.getRoads().get(userMovings.size()-1));
    }

    public boolean gameOver() {
        if(user.getMovings().size()!=bridge.getRoads().size())
            return false;
        for (int i = 0; i < user.getMovings().size(); i++) {
            if(!user.getMovings().get(i).equals(bridge.getRoads().get(i)))
                return false;
        }
        user.setClearConfime(ClearConfirm.성공);
        return true;
    }

    public int getTryCount() {
        return user.getCount();
    }

    public String getClearConfirm() {
        return user.getClearConfirm().name();
    }
}
