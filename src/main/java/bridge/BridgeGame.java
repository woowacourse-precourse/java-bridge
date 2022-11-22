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
    private List<String> ups;
    private List<String> downs;
    private STATUS status;
    private int step;


    public BridgeGame(BridgeMaker bridgeMaker, int size) {
        this.bridgeMaker = bridgeMaker;
        this.bridge = bridgeMaker.makeBridge(size);
        this.moves = new ArrayList<>();
        this.ups = new ArrayList<>();
        this.downs = new ArrayList<>();
        this.status = STATUS.RUNNING;
        this.step = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param direction 이동 방향
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        moves.add(direction);
        oneMove(direction.equals(bridge.get(step)), direction);
        step++;

        if (step >= bridge.size() && status == STATUS.RUNNING) {
            status = STATUS.END_WITH_SUCCESS;
        }
    }

    public void oneMove(boolean isSafe, String direction) {
        if (isSafe) {
            goodMove(direction);
            return;
        }
        badMove(direction);
        status = STATUS.END_WITH_FAILURE;
    }

    public void goodMove(String direction) {
        if (direction.equals("U")) {
            updateUpAndDown("O", " ");
            return;
        }
        updateUpAndDown(" ", "O");
    }

    public void badMove(String direction) {
        if (direction.equals("U")) {
            updateUpAndDown("X", " ");
            return;
        }
        updateUpAndDown(" ", "X");
    }

    public void updateUpAndDown(String upString, String downString) {
        ups.add(upString);
        downs.add(downString);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * @param size 다리의 길이
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(int size) {
        bridge = bridgeMaker.makeBridge(size);
        moves = new ArrayList<>();
        ups = new ArrayList<>();
        downs = new ArrayList<>();
        step = 0;
    }

    public STATUS getStatus(){
        return this.status;
    }
}
