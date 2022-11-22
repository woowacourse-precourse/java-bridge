package bridge;

import java.util.List;

public class Gaming {
    private static List<String> bridge;
    private String upBridgeMap;
    private String DownBridgeMap;
    private int gameTryCount;

    Gaming(List<String> bridge, int turn){
        this.bridge = bridge;
        this.upBridgeMap = "";
        this.DownBridgeMap = "";
        this.gameTryCount = turn;
    }
    /** 게임을 시작하는 기능 */
    public int startGame(){
        gameLoop(0);
        return 0;
    }
    public boolean gameLoop(int count){
        while (true){
            return false;
        }
    }


}
