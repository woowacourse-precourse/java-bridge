package bridge;

import bridge.domain.GameData;
import bridge.dto.HistoryMapDto;
import bridge.dto.PlayerLocationDto;
import bridge.dto.PlayerTryCountDto;
import bridge.exception.InputException;
import bridge.service.PlayerCommend;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputException inputException = new InputException();
    private final PlayerSetting playerSetting = new PlayerSetting();
    private GameData gameData;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String commend) {
        inputException.validateMoveCommend(commend);
        boolean result = isCorrect(commend, getPlayerLocation());
        gameData.moveLocation();
        gameData.addHistoryMap(commend, result);
        return result;
    }

    private boolean isCorrect(String commend, int playerLocation) {
        return commend.equals(playerSetting.getBridgeCorrectLocation(playerLocation));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String commend) {
        inputException.validateGameCommend(commend);
        return commend.equals(PlayerCommend.RESTART.getCommend());
    }

    public void start() {
        gameData = new GameData();
    }

    public void plusTryCount() {
        gameData.plusTryCount();
    }

    public void resetGameData() {
        gameData.resetLocation();
        gameData.resetHistoryMap();
    }

    public int getPlayerLocation() {
        return PlayerLocationDto.from(gameData).getLocation();
//        return gameData.getLocation();
    }

    public String getHistoryMap() {
        return HistoryMapDto.from(gameData).getHistoryMap();
//        return gameData.getHistoryMap();
    }

    public int getTryCount() {
        return PlayerTryCountDto.from(gameData).getTryCount();
//    return gameData.getTryCount();
    }
}
