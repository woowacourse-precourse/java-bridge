package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    // InputViewn, OutputView 사용 불가
// 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
    static List<String> bridge;
    static List<String> choice = new ArrayList<>();
    int count = 1;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getCount() {
        return count;
    }

    public List<String> getChoice() {
        return choice;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String answer) {
        choice.add(answer);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        choice.clear();
        count++;
    }

    public boolean isRightChoice() {
        for (int i = 0; i < choice.size(); i++) {
            if (!choice.get(i).equals(bridge.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isBridgeSuccess() {
        return Arrays.equals(choice.toArray(), bridge.toArray());
    }
}
