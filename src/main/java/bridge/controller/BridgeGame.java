package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.User;
import bridge.service.ExceptionService;
import bridge.service.MapMakerService;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private User user;
    private static MapMakerService mapMakerService;

    /**
     * 사용자가 게임을 시작할 때 랜덤한 다리를 만드는 메서드
     *
     * @param bridgeSize
     */
    public void initGame(String bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        ExceptionService.checkBridgeSize(bridgeSize);
        this.user = new User(bridgeMaker.makeBridge(Integer.parseInt(bridgeSize)));
        mapMakerService = new MapMakerService(user.getBridge());
    }

    public boolean onGame() {
        return user.onGame();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String move) {
        ExceptionService.checkMoving(move);
        this.user.addMove(move);
    }

    public boolean checkBridge() {
        return this.user.checkBridge();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        ExceptionService.checkRetry(command);
        if (command.equals("R")) {
            this.user.restartGame();
            return true;
        }
        return false;
    }

    public List<String> getMap() {
        return mapMakerService.makeMap(this.user.getUserBridge());
    }

    public int getRetryCount() {
        return this.user.getNumberOfAttempts();
    }
}
