package bridge.domain;

import bridge.domain.constants.BlockSymbol;
import bridge.domain.constants.Command;
import bridge.domain.constants.DomainError;
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
            if (isGameClear()){
                gameState = GameState.CLEAR;
            }
            return;
        }
        updateProgress(moveCommand, BlockSymbol.WRONG.getSymbol());
        gameState = GameState.PAUSE;
    }

    /**
     *
     * @param moveCommand 주어진 이동 커맨드
     * @return 이동 커맨드에 따른 이동이 가능한 경우 true 불가능한 경우 false
     */
    private Boolean isMovable(String moveCommand){
        if (moveCommand.equals(Command.MOVE_UP.getCommand())){
            return bridge.get(progress.size()).equals(BlockSymbol.UP.getSymbol());
        }
        if (moveCommand.equals(Command.MOVE_DOWN.getCommand())){
            return bridge.get(progress.size()).equals(BlockSymbol.DOWN.getSymbol());
        }
        return Boolean.FALSE;
    }

    /**
     *
     * @return 게임 클리어 여부
     */
    private Boolean isGameClear(){
        return progress.size() == bridge.size();
    }

    /**
     *
     * @param command 이동 커맨드
     * @exception IllegalArgumentException 이동 커맨드가 위로 이동 커맨드와 아래로 이동 커맨드가 아닐 경우 예외 발생
     */
    private void validateMoveCommand(String command){
        if (!command.equals(Command.MOVE_UP.getCommand()) && !command.equals(Command.MOVE_DOWN.getCommand())) {
            throw new IllegalArgumentException(DomainError.INVALID_MOVE_COMMAND.getMessage());
        }
    }

    /**
     *
     * @param retrialCommand 재시도 커맨드
     * 재시도 커맨드일 경우 재시도, 종료 커맨드일 경우 게임을 종료한다
     */
    public void retry(String retrialCommand) {
        validateRetrialCommand(retrialCommand);
        if (retrialCommand.equals(Command.RETRY.getCommand())) {
            progress.clear();
            trialCount += 1;
            gameState = GameState.RUNNING;
            return;
        }
        gameState = GameState.FAIL;
    }

    /**
     *
     * @param command 재시도 커맨드
     * @exception IllegalArgumentException 입력된 커맨드가 재시도, 또는 종료 커맨드가 아닐 경우 예외 발생
     */
    private void validateRetrialCommand(String command){
        if (!command.equals(Command.RETRY.getCommand()) && !command.equals(Command.QUIT.getCommand())){
            throw new IllegalArgumentException(DomainError.INVALID_RETRY_COMMAND.getMessage());
        }
    }

    /**
     *
     * @return 게임의 상태
     */
    public GameState getGameState() {
        return gameState;
    }

    /**
     *
     * @return 게임의 시도 횟수
     */
    public Integer getTrialCount() {
        return trialCount;
    }

    /**
     *
     * @param bridge 생성된 다리
     */
    public void setBridge(List<String> bridge){
        this.bridge = bridge;
    }

    /**
     *
     * @return 현재 게임에서 사용되고 있는 다리
     */
    public List<String> getBridge() {
        return bridge;
    }

    /**
     *
     * @param moveCommand 이동 커맨드
     * @param symbol 진행 상황을 표시하기 위한 기호
     * 주어진 이동 커맨드와 다리를 고려해 진행 상황을 갱신한다.
     */
    private void updateProgress(String moveCommand, String symbol){
        if (moveCommand.equals(Command.MOVE_UP.getCommand())){
            progress.put(symbol, BlockSymbol.BLANK.getSymbol());
        }
        if (moveCommand.equals(Command.MOVE_DOWN.getCommand())){
            progress.put(BlockSymbol.BLANK.getSymbol(), symbol);
        }
    }

    /**
     *
     * @return 진행상황
     */
    public BridgeProgress getProgress(){
        return progress;
    }
}
