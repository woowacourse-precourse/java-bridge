package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Player player;
    private int totalTry;
    private List<String> bridge;
    private MoveRecord moveRecord;
    private boolean run;

    public BridgeGame(List<String> bridge) {
        this.player = new Player();
        this.moveRecord = new MoveRecord();
        this.totalTry = 1;
        this.bridge = bridge;
        this.run = false;
    }

    public void init() {
        this.player.init();
        this.moveRecord.init();
        this.run = true;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean move(String moving) {
        Integer position = this.player.move();
        boolean success = this.bridge.get(position).equals(moving);
        this.moveRecord.add(moving, success);
        if (!success) {
            this.player.back();
        }
        return success;
    }

    public void command(String command) {
        if ("R".equals(command)) {
            retry();
        }
        if ("Q".equals(command)) {
            exit();
        }
    }
    public Boolean isClear() {
        return this.player.getPosition().equals(bridge.size() - 1);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        init();
        ++totalTry;
    }

    public void exit() {
        this.run = false;
    }

    public int getTotalTry() {
        return totalTry;
    }

    public MoveRecord getMoveRecord() {
        return moveRecord;
    }

    public boolean isRun() {
        return this.run;
    }
}
