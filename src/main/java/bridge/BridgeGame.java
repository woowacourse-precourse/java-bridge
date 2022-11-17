package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    /*
    final means you can't change the object's reference to point to another, while you can still
    mutate its state (through setter function)
    */
    private final List<String> bridge;
    private Integer where;

    BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        where = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String dir) {
        if (dir.equals(bridge.get(where + 1))) {
            where++;
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String reOrNot) {
        if (reOrNot.equals("R"))
            return true;
        return false;
    }

    public boolean ifEnd() {
        return where == bridge.size();
    }
    
    public List<String> getBridge() {
        List<String> get = new ArrayList<>();
        for (String s: bridge)
            get.add(s);

        return get;
    }
}
