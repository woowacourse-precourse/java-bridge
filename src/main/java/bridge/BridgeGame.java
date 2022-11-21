package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final GameData gameData = new GameData();
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    public List<String> bridge;
    public int bridgeSize;
    private int bridgeIndex = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String direction) {

        if (this.bridge.get(this.bridgeIndex).equals(direction)) {
            increaseBridgeIndex();
            this.gameData.updateStatus(direction, "O");
            return "O";
        }

        this.gameData.updateStatus(direction, "X");
        return "X";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retryFlag) {
        if (retryFlag.equals("R")) {
            resetBridgeIndex();
            gameData.restartGame();
            return false;
        }
        return true;
    }

    public String checkGameResult() {
        if (this.bridgeSize == this.bridgeIndex) {
            return "성공";
        }

        return "실패";
    }

    public void startGame(int bridgeSize) {
        this.bridgeSize = bridgeSize;
        this.bridge = bridgeMaker.makeBridge(this.bridgeSize);
    }

    public boolean checkArrive() {
        if (this.bridgeIndex == this.bridgeSize) {
            return true;
        }
        return false;
    }

    public void increaseBridgeIndex() {
        this.bridgeIndex += 1;
    }

    public void resetBridgeIndex() {
        this.bridgeIndex = 0;
    }

    public GameData getGameData() {
        return this.gameData;
    }
}
