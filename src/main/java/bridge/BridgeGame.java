package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    //private static final String UP = "O";
    //private static final String UP = "O";
    private static final String RIGHT = "O";
    private static final String WRONG = "X";
    private BridgeMaker bridgeMaker;
    private List<String> rightWayBridge;
    private List<List<String>> dashBoard;
    private List<String> bridgeDown;
    private List<String> bridgeUp;
    private int numberOfTimes;
    private int count;
    private boolean isWin;

    public BridgeGame(int size){
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        for(int i=0; i<size; i++){
            this.bridgeUp.add(" ");
            this.bridgeDown.add(" ");
        }
        this.dashBoard.add(bridgeDown); //0
        this.dashBoard.add(bridgeUp); //1
        this.count =0;
        this.numberOfTimes =1;
        isWin =false;
    }
    public void setBridge(int size) {
        rightWayBridge = bridgeMaker.makeBridge(size);
    }

    public void checkWin() {
        if(this.count == rightWayBridge.size()){
            this.isWin = true;
        }
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input, List<String> bridge) {
        if(input.equals("D")){
            moveDown(bridge);
            this.count += 1;
            return;
        }
        moveUp(bridge);
        this.count += 1;
        return;
    }
    private void moveDown(List<String> bridge){
        if(bridge.get(count).equals("D")){
            this.dashBoard.get(0).set(count, RIGHT);
            return;
        }
        this.dashBoard.get(0).set(count, WRONG);
        return;
    }
    private void moveUp(List<String> bridge){
        if(bridge.get(count).equals("U")){
            this.dashBoard.get(1).set(count, RIGHT);
            return;
        }
        this.dashBoard.get(1).set(count, WRONG);
        return;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        numberOfTimes +=1;
        //초기화
        int size = this.bridgeUp.size();
        for(int i=0; i<size; i++){
            this.bridgeUp.add(" ");
            this.bridgeDown.add(" ");
        }
        this.dashBoard.add(bridgeDown); //0
        this.dashBoard.add(bridgeUp); //1
        this.count =0;
    }
}
