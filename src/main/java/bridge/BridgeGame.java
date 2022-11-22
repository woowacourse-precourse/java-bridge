package bridge;

import java.util.Collections;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;

    private int index = 0;
    private int count = 1;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */

    public String move(Integer index) {
        this.index=index;
        return bridge.get(index);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        validateCommand(command);

        if (isCommandIsR(command)) {
            count++;
            return true;
        }
        return false;
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public String getLastItem() {
        return bridge.get(index);
    }

    public void addBridge(List<String> makeBridge) {
        bridge.addAll(makeBridge);
    }

    public int getCount() {
        return count;
    }

    private void validateCommand(String command) {
        if (!isCommandIsQ(command) && !isCommandIsR(command)) throw new IllegalArgumentException("U나 D를 입력해주십시오");
    }

    private static boolean isCommandIsQ(String command) {
        return command.equals("Q");
    }

    private static boolean isCommandIsR(String command) {
        return command.equals("R");
    }
}
