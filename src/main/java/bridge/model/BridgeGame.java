package bridge.model;

import bridge.BridgeMaker;
import bridge.model.Bridge;
import bridge.model.Player;
import bridge.model.Result;
import bridge.util.BridgeGameStatus;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final Result result;
    private Player player;
    private Bridge bridge;

    public BridgeGame(BridgeMaker bridgeMaker, Result result) {
        this.result = result;
        this.bridgeMaker = bridgeMaker;
        player = Player.of();
    }

    /**
     * 다리 생성하는 함수
     * @param bridgeSize
     */
    public void setBridge(int bridgeSize) {
        bridge = makeBridge(bridgeSize);
    }

    public Bridge makeBridge(int size) {
        return new Bridge(size, bridgeMaker.makeBridge(size));
    }

    public Bridge getBridge() {
        return bridge;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String move) {
        boolean canMove = moveCorrect(move);

        if (canMove) {
            player.move(move, BridgeGameStatus.CORRECT.getGameStatus());
            return true;
        }

        player.move(move, BridgeGameStatus.INCORRECT.getGameStatus());
        return false;
    }

    public boolean moveCorrect(String move) {
        return move.equals(bridge.getBridgeMove(player.getCurrentLocation()));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        setPlayer();
    }

    public void startGame() {
        result.addPlayCount();

    }

    public void setPlayer() {
        player = Player.of();
    }


    public boolean isQuit(String gameCommand) {
        return gameCommand.equals(BridgeGameStatus.QUIT.getGameStatus());
    }

    /**
     * 게임을 성공하였을때 : 플레이어가 완주한 상태로, 마지막 칸은 O로 끝나야 한다.
     * @return
     */
    public boolean isFinish() {
        return bridge.getBridgeSize() == player.getCurrentLocation();
    }

    public void setResult(boolean gameResult) {
        this.result.setResult(gameResult);
    }

    public Result getResult() {
        return result;
    }

    public Player getPlayer() {
        return player;
    }
}
