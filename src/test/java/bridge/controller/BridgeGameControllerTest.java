package bridge.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BridgeGameControllerTest {

    BridgeGameController bridgeGameController;

    @BeforeEach
    void setUp(){
        bridgeGameController = BridgeGameController.create();
    }

    @Test
    @DisplayName("컨트롤러 생성자를 정상적으로 불러온다")
    void 컨트롤러_생성_테스트(){
        assertDoesNotThrow(() -> new BridgeGameController());
    }

}