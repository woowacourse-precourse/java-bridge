package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Player;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String FAIL = "실패";
    private static final String EXCEPTION_MESSAGE_INVALID_MOVE = "[ERROR] 이동 가능 칸은 U 또는 D 만 있습니다.";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private final Bridge bridge;
    private final Player player;

    public BridgeGame() {
        this.bridge = new Bridge();
        this.player = new Player();
    }

    public void makeBridge(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge.setBridge(bridgeMaker.makeBridge(size));
    }

    public boolean move(String move) {
        validateMove(move);
        player.updateMoveInfo(move);
        player.setMoveResult(player.isPlayerMove(bridge));
        return player.getIsMove();
    }

    private void validateMove(String move){
        if(!(move.equals(UP) || move.equals(DOWN))){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_INVALID_MOVE);
        }
    }

    public boolean retry(String gameCommand) {
        return false;
    }

    public boolean isClearGame() {
        return player.isClearGame(bridge);
    }

    public void initPlayer(){
        player.InitRetryPlayer();
    }

    public Player getPlayer(){
        return player;
    }
}
