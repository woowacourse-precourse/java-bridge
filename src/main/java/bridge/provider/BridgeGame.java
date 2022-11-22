package bridge.provider;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final List<String> direction = new ArrayList<>();
    private int position;

    public BridgeGame(final String size) {
        bridge = new Bridge(size);
        this.position = 0; //상수처리
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(final String playerInput) { //플레이어의 입력 문자
        checkValidMoving(playerInput);
        direction.add(playerInput);
    }

    public int getPosition() {
        return position;
    }

    private int getBridgeEndPosition() {
        return bridge.getSize() - 1;
    }

    private void isCompareTo() {

    }

    private boolean isEqualsTo(int index) {
        return direction.get(index).equals(bridge.getBridge(index));
    }

    private void validateBridge(List<String> bridge, final List<String> playerInputDirection) {


    }


    //유효한 입력인지 검증
    private void checkValidMoving(final String input) {
        if (input != "U" || input != "D") {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }

    private void checkValidCommand(final String input) {
        if (input != "R" || input != "Q") {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
