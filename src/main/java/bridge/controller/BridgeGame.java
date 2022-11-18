package bridge.controller;

import bridge.domain.BridgeMove;
import bridge.model.Bridge;
import bridge.model.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.Arrays;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMove bridgeMove = new BridgeMove();
    Bridge bridge;

    public void init() {
        outputView.printStartMessage();
        makeBridge();
//        print2DBridge();
        start(new Player());
    }

    public void start(Player player) {
        move(player);
//        printPlayerPosition(player);
    }

//    private void printPlayerPosition(Player player) {
//        System.out.println(player.getXPosition());
//        System.out.println(player.getYPosition());
//    }

    private void makeBridge() {
        int bridgeSize = inputView.readBridgeSize();
        bridge = new Bridge(bridgeSize);
    }

//    private void print2DBridge() {
//        Arrays.stream(bridge.getBridge()).forEach(
//                bridgeBlock -> {
//                    System.out.println(Arrays.toString(bridgeBlock));
//                }
//        );
//    }

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
    public void retry() {
    }
}