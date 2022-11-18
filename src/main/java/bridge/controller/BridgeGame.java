package bridge.controller;

import bridge.domain.BridgeMove;
import bridge.model.Bridge;
import bridge.model.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.Arrays;

import static bridge.util.BridgeConstant.FALL_POSITION;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMove bridgeMove = new BridgeMove();
    boolean isContinue;
    boolean isWin;
    Bridge bridge;

    public void init() {
        outputView.printStartMessage();
        makeBridge();
        print2DBridge();
        start(new Player());
    }

    public void start(Player player) {
        isContinue = true;
        while (isContinue) {
            move(player);
            checkPlayerPosition(player);
        }
        outputView.printResult(player, isWin);
    }

    private void checkPlayerPosition(Player player) {
        if (!moveSuccess(player, bridge)) {
            retry(player);
        }

        if (reachFinalLine(player, bridge)) {
            isContinue = false;
            isWin = true;
        }
    }

    private boolean reachFinalLine(Player player, Bridge bridge) {
        int positionX = player.getXPosition();
        int bridgeLength = bridge.getBridge()[0].length;

        if (positionX == bridgeLength - 1) {
            return true;
        }
        return false;
    }

    private boolean moveSuccess(Player player, Bridge bridge) {
        String[][] tempBridge = bridge.getBridge();
        int positionX = player.getXPosition();
        int positionY = player.getYPosition();
        if (tempBridge[positionY][positionX].equals(FALL_POSITION)) {
            return false;
        }
        return true;
    }

//    private void printPlayerPosition(Player player) {
//        System.out.println(player.getXPosition());
//        System.out.println(player.getYPosition());
//    }

    private void makeBridge() {
        int bridgeSize = inputView.readBridgeSize();
        bridge = new Bridge(bridgeSize);
    }

    private void print2DBridge() {
        Arrays.stream(bridge.getBridge()).forEach(
                bridgeBlock -> {
                    System.out.println(Arrays.toString(bridgeBlock));
                }
        );
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param player
     */
    public void move(Player player) {
        String moveTo = inputView.readMoving();
        bridgeMove.movePlayer(player, moveTo);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Player player) {
        boolean continueCode = inputView.readGameCommand();
        if (continueCode) {
            player.initializePosition();
            player.setTryCount();
            return;
        }
        isWin = false;
        isContinue = false;
    }
}