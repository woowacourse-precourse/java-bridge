package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> Bridge ;
    private static List<String>Progress1 = new ArrayList<>();
    private static List<String>Progress2 = new ArrayList<>();


    BridgeGame(List<String> Bridge) {
        this.Bridge = Bridge;

    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public List<String>getBridge() {
        return Bridge;
    }

    public void move(String moving) {
        if (moving.equals("U")) {
            judgeUpOX(moving);
        }
        if (moving.equals("D")) {
            judgeDownOX(moving);
        }
    }
    public void judgeUpOX(String moving) {
        if (moving.equals(Bridge.get(Progress1.size()))){
            Progress1.add(" O ");
            Progress2.add("   ");
            return;
        }
        Progress1.add(" X ");
        Progress2.add("   ");
    }
    public void judgeDownOX(String moving) {
        if (moving.equals(Bridge.get(Progress2.size()))) {
            Progress1.add("   ");
            Progress2.add(" O ");
            return;
        }
        Progress1.add("   ");
        Progress2.add(" X ");
    }
    public List<String> getProgress1() {
        return Progress1;
    }

    public List<String> getProgress2() {
        return Progress2;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String restart) {
        if (restart.equals("R")) {
            Progress1.clear();
            Progress2.clear();
            return true;
        }
        return false;
    }
}
