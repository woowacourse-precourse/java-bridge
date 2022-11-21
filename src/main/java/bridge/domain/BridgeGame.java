package bridge.domain;

import bridge.domain.constants.Command;
import bridge.domain.constants.GameState;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Integer currentBlockIndex = -1;
    private List<String> bridge = new ArrayList<>();
    private List<String> bridgeProgress = new ArrayList<>();
    private Integer trialCount = 1;
    private GameState gameState = GameState.RUNNING;

    private List<String> upperBlock = new ArrayList<>();
    private List<String> lowerBlock = new ArrayList<>();

    public void move(String moveCommand) {
        validateMoveCommand(moveCommand);
        if (isMovable(moveCommand)) {
            if (moveCommand.equals(Command.MOVE_UP.getCommand())){
                upperBlock.add("O");
                lowerBlock.add(" ");
            }
            if (moveCommand.equals(Command.MOVE_DOWN.getCommand())){
                upperBlock.add(" ");
                lowerBlock.add("O");
            }
            currentBlockIndex += 1;
            if (isClear()){
                gameState = GameState.CLEAR;
            }
            return;
        }
        if (moveCommand.equals(Command.MOVE_UP.getCommand())){
            upperBlock.add("X");
            lowerBlock.add(" ");
        }
        if (moveCommand.equals(Command.MOVE_DOWN.getCommand())){
            upperBlock.add(" ");
            lowerBlock.add("X");
        }
        gameState = GameState.PAUSE;
    }

    private Boolean isMovable(String moveCommand){
        return bridge.get(currentBlockIndex + 1).equals(moveCommand);
    }

    private Boolean isClear(){
        if (bridge.equals(bridgeProgress)){
            return true;
        }
        return false;
    }

    private void validateMoveCommand(String command){
        if (!command.equals(Command.MOVE_UP.getCommand()) && !command.equals(Command.MOVE_DOWN.getCommand())) {
            throw new IllegalArgumentException();
        }
    }

    public void retry(String retrialCommand) {
        validateRetrialCommand(retrialCommand);
        if (retrialCommand.equals(Command.RETRY.getCommand())) {
            currentBlockIndex = -1;
            this.bridgeProgress = new ArrayList<>();
            trialCount += 1;
            gameState = GameState.RUNNING;
            return;
        }
        gameState = GameState.FAIL;
    }

    private void validateRetrialCommand(String command){
        if (!command.equals(Command.RETRY.getCommand()) && !command.equals(Command.QUIT.getCommand())){
            throw new IllegalArgumentException();
        }

    }
    public List<String> getBridgeProgress() {
        return bridgeProgress;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Integer getTrialCount() {
        return trialCount;
    }

    public void setBridge(List<String> bridge){
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUpperBlock() {
        return upperBlock;
    }

    public List<String> getLowerBlock() {
        return lowerBlock;
    }
}
