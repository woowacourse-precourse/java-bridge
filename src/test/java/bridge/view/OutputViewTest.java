package bridge.view;

import bridge.controller.BridgeGame;
import bridge.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    @Test
    void 사용자다리그리기(){
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.initGame("4");

        boolean isSuccess = bridgeGame.move("U");
        System.out.println(isSuccess);

        outputView.printMap(bridgeGame.getUser());

        boolean isSuccess1 = bridgeGame.move("U");
        System.out.println(isSuccess1);

        outputView.printMap(bridgeGame.getUser());
    }


}