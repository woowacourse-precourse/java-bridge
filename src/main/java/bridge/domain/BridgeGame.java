package bridge.domain;

import bridge.BridgeMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Integer currentBlockIndex = -1;
    private List<String> bridge = new ArrayList<>();
    private List<String> bridgeProgress = new ArrayList<>();
    private Integer trialCount = 1;
    private GameState gameState;
    public BridgeGame(List<String> bridge){
        currentBlockIndex = -1;
        this.bridge = bridge;
        this.bridgeProgress = new ArrayList<>();
        trialCount = 1;
        gameState = GameState.RUNNING;
    }

    public void move(String moveCommand) {
        validateMoveCommand(moveCommand);
        if (isMovable(moveCommand)) {
            this.bridgeProgress.add("O");
            currentBlockIndex += 1;
            return;
        }
        this.bridgeProgress.add("X");
        gameState = GameState.PAUSE;
    }

    private Boolean isMovable(String moveCommand){
        return bridge.get(currentBlockIndex + 1).equals(moveCommand);
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



}
