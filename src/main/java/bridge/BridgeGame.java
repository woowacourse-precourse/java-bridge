package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    List<String> curbridge;  // 현재 게임이 진행되고 있는 다리 정보
    int curidx; // 현재 유저가 위치하고 있는 인덱스
    public BridgeGame(int size){
        BridgeNumberGenerator bng = new BridgeRandomNumberGenerator();
        BridgeMaker bm = new BridgeMaker(bng);
        curbridge = bm.makeBridge(size);
        curidx = 0;
    }
    public int move() {
        InputView iv = new InputView();
        String mov = iv.readMoving();
        if(isFinish(curidx,mov) == 0) return 0;
        else {
            curidx++;
            return 1;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
    public int isFinish(int idx,String pos){
        if(curbridge.get(idx).equals(pos)) return 1;
        return 0;
    }
}
