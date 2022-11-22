package bridge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Player player;
    private Bridge bridge;

    public BridgeGame(Player player) {
        this.player = player;
    }

    public void start(){
        makeBridge();
        do {
            player.increaseGameCount();
            player.currentPositionReset();
            play();
        }while(!player.isSuccess() && retry());

        // 여기서 Upline, DownLine 줘야할듯 // totalMap; (Map<String, List<String>>)
        player.printTotalScore(lastBridgeMap(player.getCurrentPosition(), player.success));
    }

    public void makeBridge(){
        this.bridge = new Bridge(player.makeBridge());
    }

    public void play(){
        while(move()){

        }
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        // 마지막 칸이 아니고 && 성공한 경우 -> true;
        boolean isCorrectSpot = bridge.isCorrectSpot(player.getNextIdx(), player.getNextSpot());
        if(!isCorrectSpot) // 틀린 경우 false
            return false;

        if(bridge.isLastSpot(player.getCurrentPosition())){
            player.success = true;
            return false;
        }

        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        return player.retry();
    }

    public Map<String, String> lastBridgeMap(int currentPosition, boolean result){
        Map<String, String> ret = new HashMap<>();
        ret.put("U", bridge.getUpLineResult(currentPosition, result));
        ret.put("D", bridge.getDownLineResult(currentPosition, result));
        return ret;
    }
}
