package bridge;

import view.OutputView;
import java.util.List;

/**
 * 다리상황과 플레이어의 선택을 비교해서 출력하는 클래스
 */
public class BridgeComparator {
    OutputView outputView = new OutputView();

    public boolean movePlayer(List<String> bridge, List<String> player){
        if(!outputView.printMap(bridge, player, player.size())){ // 플레이어의 선택이 잘못됐을 경우
            return false; // 거짓 리턴
        }
        return true; // 플레이어가 끝까지 도달했을 경우 참 리턴
    }
}
