package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private BridgeGameInfo gameInfo;

    BridgeGame(BridgeGameInfo bridgeGameInfo){
        this.gameInfo = bridgeGameInfo;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {
        gameInfo.setPositionNext();
        gameInfo.setPlayer(input);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameInfo.addTrial();
        gameInfo.setPosition(-1);
        gameInfo.setPlayer("");
    }

    public BridgeGameInfo getInfo(){
        return gameInfo;
    }

    public Player status(){
        int position = gameInfo.getPosition();
        int end = gameInfo.getEnd();
        String bridge = gameInfo.getBridgeAt(position);
        String player = gameInfo.getPlayer();
        if(position==end && bridge.equals(player))return Player.WIN;
        if(bridge.equals(player)) return Player.SURVIVE;
        return Player.DIE;
    }
}
