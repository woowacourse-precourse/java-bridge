package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.code.BridgeMap;
import bridge.code.GameStatus;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final GameResult result;
    private int gameStatus;

    public BridgeGame(int size) {
        this.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        this.result = new GameResult();
        this.gameStatus = GameStatus.PLAY;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String input) {
        boolean isMoveSuccess = input.equals(bridge.get(result.getIndex()));
        updateResult(input, isMoveSuccess);
        return isMoveSuccess;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(String input) {
        if (input.equals("R")) {
            setGameStatus(GameStatus.PLAY);
            return result.updateGameResult();
        }
        setGameStatus(GameStatus.FAIL);
        return result.getAttempts();
    }

    private void updateResult(String input, boolean isMoveSuccess) {
        result.updateResultMap(input, BridgeMap.FOR_MOVE.getString(isMoveSuccess));
        if (bridge.size() == result.getIndex()) {
            setGameStatus(GameStatus.SUCCESS);
        }
    }

    private void setGameStatus(int gameStatus) {
        this.gameStatus = gameStatus;
    }

    public GameResult getResult() {
        return result;
    }

    public int getGameStatus() {
        return gameStatus;
    }
}
