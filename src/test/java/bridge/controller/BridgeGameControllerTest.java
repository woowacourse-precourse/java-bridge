package bridge.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameControllerTest {
    private BridgeGameController bridgeGameController;

    @BeforeEach
    void setUp() {
        bridgeGameController = new BridgeGameController(new OutputView(), new InputView());
    }

    @Test
    @DisplayName("start 메서드 실행 시 시작 문구가 출력된다.")
    void isPrintStartMessageWhenStart() {
        //given
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        bridgeGameController.start();

        //then
        assertThat(outputStream.toString()).contains("시작");
    }
}
