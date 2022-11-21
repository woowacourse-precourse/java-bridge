package bridge;

import bridge.domain.Player;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Player player;

    private List<String> bridge;

    private int round = 1;

    private int location = 0 ;

    public BridgeGame(Player player){
        this.player = player;
    }

    public void generate(List<String> bridge){
        this.bridge = bridge;
    }

    public void move(String moving) {
        if(moving.equals("U")){
            if(bridge.get(location).equals(moving)){
                player.correctUpsideBridge(location);
            }
            if(!(bridge.get(location).equals(moving))){
                player.wrongUpsideBridge(location);
            }
        }

        if(moving.equals("D")){
            if(bridge.get(location).equals(moving)){
                player.correctDownsideBridge(location);
            }
            if(!(bridge.get(location).equals(moving))){
                player.wrongDownsideBridge(location);
            }
        }
        increaseLocation();
    }

    public void retry() {
        player.retry();
        increaseRetry();
        location = 0;
    }

    public int quit(){
        return round;
    }

    public void increaseRetry(){ // 재시도 횟수를 카운트 +1 해준다
        round++;
    }

    public void increaseLocation(){ // 다리를 건널때마다 현재 위치에 대한 값을 올려준다.
        location++;
    }

    public boolean isAllAnswer(int size){
        return player.isAllAnswer(size);
    }

}
