package bridge.model;

import bridge. BridgeRandomNumberGenerator;
import static bridge.enums.Constant_BridgeGame.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private Map<String, List<String>> progress = new HashMap<>();

    public BridgeGame(int size) {
        retry();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {
        int currentProgressSize = this.progress.get(UP_SIDE_PROGRESS.get()).size();
        String movingResult = compareMovableCell(input, currentProgressSize);

        if (input.equals(GAME_COMMAND_UP.get())) {
            addProgress(movingResult, UP_SIDE_PROGRESS.get(), DOWN_SIDE_PROGRESS.get());
        }
        if (input.equals(GAME_COMMAND_DOWN.get())) {
            addProgress(movingResult, DOWN_SIDE_PROGRESS.get(), UP_SIDE_PROGRESS.get());
        }
    }

    public boolean isContinue() {
        if (this.bridge.size() == this.progress.get(UP_SIDE_PROGRESS.get()).size()) {
            return false;
        }
        if (this.progress.get(UP_SIDE_PROGRESS.get()).contains(UNMOVABLE_CELL.get())) {
            return false;
        }
        if (this.progress.get(DOWN_SIDE_PROGRESS.get()).contains(UNMOVABLE_CELL.get())) {
            return false;
        }
        return true;
    }

    public boolean isFallBridge() {
        return this.progress.get(UP_SIDE_PROGRESS.get()).stream()
                .anyMatch(element -> element.equals(UNMOVABLE_CELL.get()))
                ||
                this.progress.get(DOWN_SIDE_PROGRESS.get()).stream()
                .anyMatch(element -> element.equals(UNMOVABLE_CELL.get()));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        progress.put(UP_SIDE_PROGRESS.get(), new ArrayList<>());
        progress.put(DOWN_SIDE_PROGRESS.get(), new ArrayList<>());
    }

    private String compareMovableCell(String input, int currentProgressSize) {
        String movingResult = new String();

        if (input.equals(this.bridge.get(currentProgressSize))) {
            movingResult =  MOVABLE_CELL.get();
        }
        if (!input.equals(this.bridge.get(currentProgressSize))) {
            movingResult =  UNMOVABLE_CELL.get();
        }

        return movingResult;
    }

    private void addProgress(String movingResult, String dest, String other) {
        this.progress.get(dest).add(movingResult);
        this.progress.get(other).add(BLANK_CELL.get());
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public Map<String, List<String>> getProgress() {
        return this.progress;
    }
}
