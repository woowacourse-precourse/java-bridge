package bridge.controller;

import bridge.domain.BridgeMove;
import bridge.model.Bridge;
import bridge.model.BridgeMap;
import bridge.model.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.util.BridgeConstant.FALL_POSITION;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public final String SUCCESS_BLOCK = "O";
    public final String FAIL_BLOCK = "X";
    public final String BLANK_BLOCK = " ";

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMove bridgeMove = new BridgeMove();
    BridgeMap bridgeMap = new BridgeMap();
    boolean isContinue = true;
    boolean isWin;
    Bridge bridge;

    public void init() {
        outputView.printStartMessage();
        makeBridge();
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
        outputView.printResult(player, bridgeMap, isWin);
    }

    private void checkPlayerPosition(Player player) {
        if (!moveSuccess(player, bridge)) {
            addBridgeMapBlock(player, FAIL_BLOCK);
            outputView.printMap(bridgeMap);
            retry(player);
            return;
        }
        addBridgeMapBlock(player, SUCCESS_BLOCK);
        outputView.printMap(bridgeMap);
    }

    private void addBridgeMapBlock(Player player, String block) {
        if (player.getYPosition() == 1) {
            bridgeMap.getUpperBridgeMap().add(block);
            bridgeMap.getLowerBridgeMap().add(BLANK_BLOCK);
            return;
        }
        bridgeMap.getUpperBridgeMap().add(BLANK_BLOCK);
        bridgeMap.getLowerBridgeMap().add(block);
    }

    private boolean reachFinalLine(Player player) {
        return player.getXPosition() == bridge.getBridge()[0].length - 1;
    }

    private boolean moveSuccess(Player player, Bridge bridge) {
        int positionX = player.getXPosition();
        int positionY = player.getYPosition();
        return bridge.getBridge()[positionY][positionX].equals(FALL_POSITION);
    }


    private void makeBridge() {
        int bridgeSize = inputView.readBridgeSize();
        bridge = new Bridge(bridgeSize);
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
            player.addTryCount();
            bridgeMap.initializeBridges();
            return;
        }
        isWin = false;
        isContinue = false;
    }
}