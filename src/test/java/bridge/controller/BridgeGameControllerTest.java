package bridge.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Disabled
    @Test
    @DisplayName("게임 시작 컨트롤러 실행을 정상적으로 실행한다.")
    void 컨트롤러_시작_테스트(){
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        bridgeGameController.start();
        assertThat(outputStream.toString()).contains("다리 건너기 게임을 시작합니다.");
    }

}