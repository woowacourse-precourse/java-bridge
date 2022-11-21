package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private enum UpOrDown{
        UP(2),
        DOWN(1)
        ;
        private final int value;
        UpOrDown(int value){
            this.value = value;
        }
    }

    private List<Integer> position = new ArrayList<>(List.of(0,0));
    private List<Integer> formerPosition = new ArrayList<>(List.of(0,0));
    private int retryNumber = 0;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String readMoving) {
        this.formerPosition.set(0, this.position.get(0));
        this.formerPosition.set(1, this.position.get(1));
        if(readMoving.equals("U")){
            this.position.set(0, UpOrDown.UP.value);
            this.position.set(1, this.position.get(1)+1);
        }
        if(readMoving.equals("D")){
            this.position.set(0, UpOrDown.DOWN.value);
            this.position.set(1, this.position.get(1)+1);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.position.set(0, this.formerPosition.get(0));
        this.position.set(1, this.formerPosition.get(1));
        this.retryNumber += 1;
    }

    public List<Integer> getPosition() {
        return position;
    }

    public int getRetryNumber() {
        return retryNumber;
    }
}
