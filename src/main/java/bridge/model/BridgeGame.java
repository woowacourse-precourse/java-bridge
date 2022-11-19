package bridge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
