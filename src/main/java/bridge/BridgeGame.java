package bridge;

import controller.Service;
import controller.Util;
import model.*;
import view.GameMessage;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Service service;
    private Util util;
    private Bridge bridge;
    private BridgeMaker bridgeMaker;

    public BridgeGame() {
        util = new Util();
        service = new Service();
        System.out.println(GameMessage.START_MESSAGE);
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new Bridge(bridgeMaker.makeBridge(util.inputSize()));
    }

    public void run() {
        while (true) {
            String resultMoving = move(bridge);
            service.showMoving();
            if (retry(resultMoving))
                return;
            if (success())
                return;
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(Bridge bridge) {
        String moving = util.inputMoving();
        service.enterMoving(moving);
        String resultMoving = service.compareBridge(bridge);
        service.enterResult(resultMoving);
        return resultMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String resultMoving) {
        if (resultMoving.equals("X")) {
            String retry = util.inputRetry();
            if (service.checkRetry(retry))
                return true;
        }
        return false;
    }

    public boolean success() {
        if (service.checkSuccess(bridge))
            return true;
        return false;
    }

}
