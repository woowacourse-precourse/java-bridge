package bridge;

import controller.Service;
import controller.Util;
import model.*;
import view.GameMessage;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static final String WRONG = "X";

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

    public String move(Bridge bridge) {
        String moving = util.inputMoving();
        service.enterMoving(moving);
        String resultMoving = service.compareBridge(bridge);
        service.enterResult(resultMoving);
        return resultMoving;
    }


    public boolean retry(String resultMoving) {
        if (resultMoving.equals(WRONG)) {
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
