package game;

import inMemoryDB.GameData;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    GameData gameData;

    public BridgeGame(GameData gameData) {
        this.gameData = gameData;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String movingInputFloor, String bridgeFloorStatus) {
        if (movingInputFloor.equals(bridgeFloorStatus)) {
            gameData.setGameData(movingInputFloor, GameResult.CORRECT_FLOOR.getResultMessage());
            return;
        }
        gameData.setGameData(movingInputFloor, GameResult.WRONG_FLOOR.getResultMessage());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
