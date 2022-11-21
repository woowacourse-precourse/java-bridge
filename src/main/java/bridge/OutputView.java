package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    static final String BRIDGE_LINK = " | ";
    static final String BRIDGE_FRONT = "[ ";
    static final String BRIDGE_TAIL = " ]";

    public void printGameStart(){
        System.out.println(Message.GAME_START_MESSAGE);
        System.out.println();
    }
    public void printMap(GameResult gameResult) {
        showBridgeResult(gameResult.getUpBridge());
        showBridgeResult(gameResult.getDownBridge());
    }
    public static void showBridgeResult(List<String> bridge){
        System.out.println(BRIDGE_FRONT + String.join( BRIDGE_LINK, bridge) + BRIDGE_TAIL);
    }
    public void printResult() {
    }
}
