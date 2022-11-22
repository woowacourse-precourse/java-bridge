package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String CORRECT_MARK = "O";
    private static final String WRONG_MARK = "X";
    private final List<String> playerCommands;
    private int playerMoveCount = 0;
    private final GameMap gameMap = new GameMap();
    private GameStatus gameStatus;
    private int playCount;
    private final List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        playCount = 1;
        playerCommands = new ArrayList<>();
        gameStatus = GameStatus.PLAYING;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveCommand) {
        addPlayerCommandHistory(moveCommand);

        String moveResult = checkMoveResult(moveCommand);
        gameMap.add(moveCommand, moveResult);

        checkGameStatus(moveResult);
    }

    private void addPlayerCommandHistory(String moveCommand) {
        playerCommands.add(moveCommand);
        playerMoveCount++;
    }

    private String checkMoveResult(String moveCommand) {
        String result = "";
        if (isCorrect(moveCommand)) {
            result = CORRECT_MARK;
        }

        if (!isCorrect(moveCommand)) {
            result = WRONG_MARK;
        }

        return result;
    }

    private boolean isCorrect(String moveCommand) {
        return moveCommand.equals(bridge.get(playerMoveCount - 1));
    }

    private void checkGameStatus(String moveResult) {
        checkFailed(moveResult);
        checkFinished();
    }

    private void checkFailed(String moveResult) {
        if (moveResult.equals(WRONG_MARK)) {
            gameStatus = GameStatus.GAME_OVER;
        }
    }

    private void checkFinished() {
        if (gameStatus != GameStatus.GAME_OVER && playerMoveCount == bridge.size()) {
            gameStatus = GameStatus.GAME_CLEAR;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        resetPlayerHistory();
        playCount++;
        gameMap.clear();
        gameStatus = GameStatus.PLAYING;
    }

    private void resetPlayerHistory() {
        playerCommands.clear();
        playerMoveCount = 0;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public boolean isPlaying() {
        return gameStatus.equals(GameStatus.PLAYING);
    }

    public boolean isOver() {
        return gameStatus.equals(GameStatus.GAME_OVER);
    }

    public int getPlayCount() {
        return playCount;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
