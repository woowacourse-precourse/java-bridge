package bridge.controller;

import bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BridgeGameControllerTest {

    static BridgeGameController controller;
    static String bridgeGameControllerName = "bridge.controller.BridgeGameController";

    @BeforeAll
    public static void beforeAll(){
        controller = new BridgeGameController(new InputView(), new OutputView(), new BridgeGame());
    }

    @DisplayName("BridgeGameController 객체가 생성이 되어야 한다.")
    @Test
    public void testBridgeController(){
        assertThat(controller.getClass().getName()).isEqualTo(bridgeGameControllerName);
    }

    @AfterAll
    public static void afterAll(){
        controller = null;
    }
}