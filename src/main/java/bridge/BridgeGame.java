package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<Integer> position = new ArrayList<>(List.of(0,0));

    private int tryNumber = 1;
    private boolean question = false;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String readMoving) {
        if(readMoving.equals("U")){
            this.position.set(0, UpOrDown.UP.getValue());
            this.position.set(1, this.position.get(1)+1);
        }
        if(readMoving.equals("D")){
            this.position.set(0, UpOrDown.DOWN.getValue());
            this.position.set(1, this.position.get(1)+1);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.position.set(0, 0);
        this.position.set(1, 0);
        this.tryNumber += 1;
        this.question = false;
    }

    public boolean getQuestion(){
        return this.question;
    }

    public void onQuestion(){
        this.question = true;
    }

    public List<Integer> getPosition() {
        return position;
    }

    public int getTryNumber() {
        return this.tryNumber;
    }
}
