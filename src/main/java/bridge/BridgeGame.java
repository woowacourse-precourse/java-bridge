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

    public void getBridge(BridgeRandomNumberGenerator bridgeRandomNumberGenerator, int size){
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = new Bridge(bridgeMaker.makeBridge(size));
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
