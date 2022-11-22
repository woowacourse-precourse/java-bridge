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
        /** 건널 수 있는 칸으로 이동했을 시, 다리를 끝까지 건넜는지 확인하는 기능 */
        while (count < this.bridge.size()){
            new OutputView().printGetMoving();
            boolean moveResult = new BridgeGame().move(bridge, count, new InputView().readMoving()); // 잘 움직였는지 결과 가져오고
            fillBridgeMap(count, moveResult); // 지도저장
            new OutputView().printMap(upBridgeMap, DownBridgeMap); count++; // 지도 출력
            return false;
        }
        return true;
    }
    /** 매 턴마다 결과에 따른 다리 형태를 두 문자열로 저장하는 기능 */
    private boolean fillBridgeMap(int count, boolean moveResult){
        if (count != 0) {this.upBridgeMap += "|"; this.DownBridgeMap += "|";}
        if (moveResult) {fillUpBridgeMapCorrect(count); return true;}
        fillUpBridgeMapIncorrect(count); return true;
    }
    /** 이동할 수 있는 칸을 선택한 경우 O, 이동할 수 없는 칸을 선택한 경우 X 표시하는 기능 */
    private boolean fillUpBridgeMapCorrect(int count){
        if (this.bridge.get(count).equals("U")){
            this.upBridgeMap += " O "; this.DownBridgeMap += "   "; return true;
        }
        this.upBridgeMap += "   "; this.DownBridgeMap += " O "; return true;
    }
    private boolean fillUpBridgeMapIncorrect(int count){
        if (this.bridge.get(count).equals("U")){
            this.upBridgeMap += "   "; this.DownBridgeMap += " X "; return true;
        }
        this.upBridgeMap += " X "; this.DownBridgeMap += "   "; return true;
    }


}
