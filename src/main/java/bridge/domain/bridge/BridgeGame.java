package bridge.domain.bridge;

import bridge.domain.player.Player;
import bridge.domain.Result;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Player player = new Player();
    private Bridge bridge;
    private Result result;
    public void makeBridge(int size){
        try {
            bridge = new Bridge(size);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            makeBridge(size);
        }
    }
    public void makePlayer(String command){
        player.setInputMoving(command);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Result move(int index) {
        result = new Result(bridge.getBridgeNumber().numberTypeCheck(index),player.getMoveCommand().getMoveCommandType());
        return result;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        player.setPlayerCommand(command);
        return player.getPlayerCommand().getPlayerCommandType();
    }
    public Bridge getBridge(){
        return bridge;
    }
    public Player getPlayer(){
        return player;
    }
}
