package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private final MoveRecord moveRecord;
    private final int current;

    public BridgeGame(){
        moveRecord=new MoveRecord();
        current=0;
    }

    public void getBridge(BridgeNumberGenerator bridgeNumberGenerator, int size){
        bridge = new Bridge(bridgeNumberGenerator, size);
    }

    public void move(String move) {
        if(move.equals("U")){
            moveRecord.moveUP(current, bridge.canGo(current, move));
        }
        moveRecord.moveDOWN(current, bridge.canGo(current, move));
    }

    public void retry(String retry) {

    }
}
