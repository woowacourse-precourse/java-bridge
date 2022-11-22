package bridge;

import bridge.model.Bridge;
import bridge.model.BridgeSize;
import bridge.model.Player;
import bridge.view.InputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static int GAME_STATUS_DIE = -1;
    public static int GAME_STATUS_NORMAL = 0;
    public static int GAME_STATUS_CLEAR = 1;
    private Bridge bridge;
    private Player player;
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private int gameStatus;
    private int tried;
    private String cleared;

    public BridgeGame() {

    }

    public BridgeGame(BridgeSize size, Player player) {
        bridge = new Bridge(bridgeMaker.makeBridge(size.getBridgeSize()));
        this.player = player;
        tried = 0;
        cleared = "실패";
        gameStatus = GAME_STATUS_NORMAL;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveCommand) {
        player.move(moveCommand);
        judgeGame(player.getPlayerMoveList(), bridge.getBridgeString());
    }

    public void judgeGame(List<String> playerList, List<String> bridgeList) {
        if (!playerList.get(playerList.size() - 1).equals(bridgeList.get(playerList.size() - 1))) {
            gameStatus = GAME_STATUS_DIE;
        }
        else if (playerList.size() == bridgeList.size()) {
            gameStatus = GAME_STATUS_CLEAR;
            cleared = "성공";
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retryCommand) {
        if (retryCommand.equals(InputView.RETRY_YES)) {
            gameStatus = GAME_STATUS_NORMAL;
            return true;
        } else if (retryCommand.equals(InputView.RETRY_NO)) {
            gameStatus = GAME_STATUS_DIE;
            return false;
        }
        return false;
    }

    public void reGame() {
        player = new Player();
        tried++;
        gameStatus = GAME_STATUS_NORMAL;
    }

    public int getGameStatus() {
        return gameStatus;
    }

    public String getCleared() {
        return cleared;
    }

    public int getTried() {
        return tried;
    }

    public Player getPlayer() {
        return player;
    }

    public Bridge getBridge() {
        return bridge;
    }
}
