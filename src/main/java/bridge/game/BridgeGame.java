package bridge.game;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int MOVE = 1;
    private final GameCharacter character;
    private List<Progress> gameProgress = new ArrayList<>();

    private List<String> bridge;

    public BridgeGame(GameCharacter character) {
        this.character = character;
    }

    public void move() {
        saveProgress();
        character.move();
    }

    public void saveProgress() {
        String destination = character.showNextDestination();
        Progress progress = makeProgress(destination, isAbleToMove());
        gameProgress.add(progress);
    }

    public Progress makeProgress(String destination, boolean result) {
        return new Progress(destination, result);
    }

    public List<Progress> showCurrentResult() {
        return new ArrayList<>(gameProgress);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String showRightDestinationInArea(int area) {
        return bridge.get(area);
    }

    public boolean isAbleToMove() {
        int nextArea = character.showNextArea();
        String nextMove = character.showNextDestination();
        return showRightDestinationInArea(nextArea).equals(nextMove);
    }
}
