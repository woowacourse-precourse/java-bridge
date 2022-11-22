package bridge;

import view.OutputView;
import java.util.List;
import java.util.ArrayList;

/**
 * 다리상황과 플레이어의 선택을 비교해서 출력하는 클래스
 */
public class BridgeComparator {
    OutputView outputView = new OutputView();

    public boolean movePlayer(List<String> bridge, List<String> player){
        for(int index = 0; index < player.size(); index++){
            if(!outputView.printMap(bridge, player, index)){ // 플레이어의 선택이 잘못됐을 경우
                return false; // 거짓 리턴
            }
        }
        return true; // 플레이어가 끝까지 도달했을 경우 참 리턴
    }
}
