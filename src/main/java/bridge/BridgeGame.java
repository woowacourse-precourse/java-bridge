package bridge;

import bridge.domain.GameRound;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeMaker bridgeMaker;
    private GameRound gameRound;
    private List<String> bridge;


    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void generateBridge(int size) {
        bridge = bridgeMaker.makeBridge(size);
    }

    public void generateNewRound() {
        gameRound = new GameRound();
    }

    public GameRound getGameRound() {
        return gameRound;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String movingCommand) {
        int nowBridgeIndex = gameRound.getBridgeIndex();
        String correctResult = checkBridge(movingCommand, bridge.get(nowBridgeIndex));

        gameRound.recordResult(movingCommand, bridge.get(nowBridgeIndex));

        if(correctResult.equals("0")) {
            gameRound.setBridgeIndex(gameRound.getBridgeIndex() + 1);
        }
        checkGameWin();

        return correctResult;
    }

    private void checkGameWin() {
        if(gameRound.getBridgeIndex() == bridge.size()) {
            gameRound.setWin(true);
        }
    }

    private String checkBridge(String command, String bridgeLocation) {
        if(command.equals(bridgeLocation)) {
            return "0";
        }
        return "X";
    }

    public boolean isBeAbleProceed(String correctResult) {
        if(gameRound.isWin() || correctResult.equals("X")) {
            return false;
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
