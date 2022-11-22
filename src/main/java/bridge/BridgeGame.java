package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;
    private List<String> Us = new ArrayList<>();
    private List<String> Ds = new ArrayList<>();
    private int index;
    private int count;
    private OutputView outputView = new OutputView();

    BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.index = 0;
        this.count = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        USetting(direction);
        DSetting(direction);
        return bridge.get(index++).equals(direction);
    }

    public void USetting(String direction) {
        Us.add(" ");
        if (direction.equals("U")) {
            if (direction.equals(bridge.get(index))) {
                Us.set(index, "O");
            }
            if (!direction.equals(bridge.get(index))) {
                Us.set(index, "X");
            }
        }
    }

    public void DSetting(String direction) {
        Ds.add(" ");
        if (direction.equals("D")) {
            if (direction.equals(bridge.get(index))) {
                Ds.set(index, "O");
            }
            if (!direction.equals(bridge.get(index))) {
                Ds.set(index, "X");
            }
        }
    }

    public List<String> getUList() {
        return this.Us;
    }

    public List<String> getDList() {
        return this.Ds;
    }

    public int getIndex() {
        return this.index;
    }

    public int getCount() {
        return this.count;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        Us = new ArrayList<>();
        Ds = new ArrayList<>();
        index = 0;
        count++;
    }
}
