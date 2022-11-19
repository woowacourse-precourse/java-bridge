package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeMapMaker;
import bridge.domain.BridgeMove;
import bridge.domain.BridgeResult;
import bridge.domain.BridgeRetry;
import bridge.model.Bridge;
import bridge.model.BridgeMap;
import bridge.model.Player;

import static bridge.util.BridgeConstant.FALL_POSITION;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    BridgeMove bridgeMove = new BridgeMove();
    BridgeRetry bridgeRetry = new BridgeRetry();
    BridgeMapMaker bridgeMapMaker = new BridgeMapMaker();
    BridgeResult bridgeResult = new BridgeResult();
    BridgeMap bridgeMap = BridgeMap.getBridgeMap();
    Bridge bridge;
    boolean isContinue = true;
    boolean isWin = false;

    public void init() {
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).inputMakeBridge();
        start(new Player());
    }

    public void start(Player player) {
        while (isContinue) {
            move(player);
            checkPlayerPosition(player);
            if (reachFinalLine(player)) {
                isContinue = false;
                isWin = true;
            }
        }
        bridgeResult.printResult(player, isWin);
    }

    private void checkPlayerPosition(Player player) {
        boolean success = moveSuccess(player, bridge);
        bridgeMapMaker.addBridgeMapBlock(player, bridgeMap, success);
        bridgeResult.printMap();
        if (!success) {
            retry(player);
        }
    }

    private boolean reachFinalLine(Player player) {
        return player.getXPosition() == bridge.getBridge()[0].length - 1;
    }

    private boolean moveSuccess(Player player, Bridge bridge) {
        int positionX = player.getXPosition();
        int positionY = player.getYPosition();
        return bridge.getBridge()[positionY][positionX].equals(FALL_POSITION);
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param player
     */
    public void move(Player player) {
        bridgeMove.movePlayer(player);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Player player) {
        boolean continueCommand = bridgeRetry.getContinueCode(player);
        if (continueCommand == true) {
            updateGameStatus(player);
            return;
        }
        isWin = false;
        isContinue = false;
    }

    private void updateGameStatus(Player player) {
        player.initializePosition();
        player.addTryCount();
        bridgeMap.initializeBridges();
    }
}