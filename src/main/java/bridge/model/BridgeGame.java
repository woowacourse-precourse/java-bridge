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
        if (!hasNextBlock()) return false;
        if (isFirstBlock()) numberOfAttempt++;
        return moveToNextBlock(playerMoving);
    }

    private boolean hasNextBlock() {
        return numberOfMoving < gameStages.size();
    }

    private boolean isFirstBlock() {
        return numberOfMoving == 0;
    }

    private boolean moveToNextBlock(String playerMoving) {
        BridgeGameStage currentGameStage = gameStages.get(numberOfMoving++);
        if (Objects.equals(currentGameStage.getBridgeBlock(), playerMoving)) {
            currentGameStage.crossBlock();
            return true;
        }
        currentGameStage.notCrossBlock();
        return false;
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
