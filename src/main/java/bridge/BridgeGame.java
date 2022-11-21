package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    List<List<String>> dashBoard;
    List<String> bridgeDown;
    List<String> bridgeUp;
    int count;
    public BridgeGame(int size){
        for(int i=0; i<size; i++){
            this.bridgeUp.add(" ");
            this.bridgeDown.add(" ");
        }
        this.dashBoard.add(bridgeDown); //0
        this.dashBoard.add(bridgeUp); //1
        this.count =0;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input, List<String> bridge) {

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
