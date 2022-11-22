package bridge.domain;

import bridge.domain.constants.BlockSymbol;
import bridge.domain.constants.Command;
import bridge.domain.constants.ErrorMessage;
import bridge.domain.constants.GameState;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge = new ArrayList<>();
    private Integer trialCount = 1;
    private GameState gameState = GameState.RUNNING;
    private BridgeProgress progress = new BridgeProgress();

    /**
     *
     * @param moveCommand 주어진 이동 커맨드
     * 주어진 커맨드에 따른 이동을 구현한다.
     */
    public void move(String moveCommand) {
        validateMoveCommand(moveCommand);
        if (isMovable(moveCommand)) {
            updateProgress(moveCommand, BlockSymbol.CORRECT.getSymbol());
            if (isClear()){
                gameState = GameState.CLEAR;
            }
            return;
        }
        updateProgress(moveCommand, BlockSymbol.WRONG.getSymbol());
        gameState = GameState.PAUSE;
    }

    private Boolean isMovable(String moveCommand){
        return bridge.get(progress.size()).equals(moveCommand);
    }

    private Boolean isClear(){
        if (progress.size() == bridge.size()){
            return true;
        }
        return false;
    }

    private void validateMoveCommand(String command){
        if (!command.equals(Command.MOVE_UP.getCommand()) && !command.equals(Command.MOVE_DOWN.getCommand())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MOVE_COMMAND.getMessage());
        }
    }

    public void retry(String retrialCommand) {
        validateRetrialCommand(retrialCommand);
        if (retrialCommand.equals(Command.RETRY.getCommand())) {
            progress = new BridgeProgress();
            trialCount += 1;
            gameState = GameState.RUNNING;
            return;
        }
        gameState = GameState.FAIL;
    }

    private void validateRetrialCommand(String command){
        if (!command.equals(Command.RETRY.getCommand()) && !command.equals(Command.QUIT.getCommand())){
            throw new IllegalArgumentException(ErrorMessage.INVALID_RETRY_COMMAND.getMessage());
        }
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

    private void updateProgress(String moveCommand, String symbol){
        if (moveCommand.equals(Command.MOVE_UP.getCommand())){
            progress.put(symbol, BlockSymbol.BLANK.getSymbol());
            return;
        }
        if (moveCommand.equals(Command.MOVE_DOWN.getCommand())){
            progress.put(BlockSymbol.BLANK.getSymbol(), symbol);
            return;
        }
    }
}
