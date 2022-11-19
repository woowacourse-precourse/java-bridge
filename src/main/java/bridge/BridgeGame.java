package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<BridgeGameStage> gameStages;
    private int numberOfMoving;
    private int numberOfAttempt;

    public BridgeGame(List<String> bridge) {
        gameStages = new ArrayList<>();
        for (String bridgeBlock : bridge) {
            gameStages.add(new BridgeGameStage(bridgeBlock));
        }
        numberOfMoving = 0;
        numberOfAttempt = 0;
    }

    public int getNumberOfMoving() {
        return numberOfMoving;
    }

    public int getNumberOfAttempt() {
        return numberOfAttempt;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String playerMoving) {
        if (isFirstMoving()) numberOfAttempt++;

        BridgeGameStage gameStage = gameStages.get(numberOfMoving++);
        if (Objects.equals(gameStage.getBridgeBlock(), playerMoving)) {
            gameStage.crossBlock();
            return true;
        }
        gameStage.notCrossBlock();
        return false;
    }

    private boolean isFirstMoving() {
        return numberOfMoving == 0;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameStages.forEach(BridgeGameStage::initStatus);
        numberOfMoving = 0;
    }

    public boolean isAllCrossed() {
        long numberOfCrossedBlock = gameStages.stream()
                .map(BridgeGameStage::getStatus)
                .filter(status -> status == Status.CROSSED)
                .count();
        return gameStages.size() == numberOfCrossedBlock;
    }

    public List<BridgeGameStage> getCurrentGameStages() {
        return new ArrayList<>(gameStages.subList(0, numberOfMoving));
    }
}
