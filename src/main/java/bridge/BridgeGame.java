package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> playerCommands = new ArrayList<>();
    private int playerMoveCount = 0;
    private GameMap gameMap = new GameMap();
    private GameStatus gameStatus;
    private int playCount;
    private List<String> bridge; // 직접 접근을 막고 bridge to map 으로 반환하여 출력하게끔

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        playCount = 1;
        gameStatus = GameStatus.PLAYING;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveCommand) {
        playerCommands.add(moveCommand);
        playerMoveCount++;
        String moveResult = checkMoveResult(moveCommand);
        checkFailed(moveResult);
        gameMap.add(moveCommand, moveResult);
        checkFinished();
    }

    private String checkMoveResult(String moveCommand) {
        String result = "";
        if (moveCommand.equals(bridge.get(playerMoveCount - 1))) {
            result = "O";
        }

        if (!moveCommand.equals(bridge.get(playerMoveCount - 1))) {
            result = "X";
        }
        return result;
    }

    private void checkFinished() {
        if (gameStatus != GameStatus.GAME_OVER && playerMoveCount == bridge.size()) {
            gameStatus = GameStatus.GAME_CLEAR;
        }
    }

    private void checkFailed(String moveResult) {
        if (moveResult.equals("X")) {
            gameStatus = GameStatus.GAME_OVER;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        playCount++;
        playerCommands.clear();
        playerMoveCount = 0;
        gameMap.clear();
        gameStatus = GameStatus.PLAYING;
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

    public boolean isClear() {
        return gameStatus.equals(GameStatus.GAME_CLEAR);
    }

    public int getPlayCount() {
        return playCount;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
