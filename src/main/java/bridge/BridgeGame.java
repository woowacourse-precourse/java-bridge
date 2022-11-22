package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private List<String> bridge;
    private List<String> moves;


    public BridgeGame(BridgeMaker bridgeMaker, int size) {
        this.bridgeMaker = bridgeMaker;
        this.bridge = bridgeMaker.makeBridge(size);
        this.moves = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param direction 이동 방향
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        moves.add(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * @param size 다리의 길이
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(int size) {
        bridge = bridgeMaker.makeBridge(size);
        moves = new ArrayList<>();
    }
}
