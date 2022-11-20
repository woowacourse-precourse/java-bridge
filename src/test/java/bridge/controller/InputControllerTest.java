package bridge.controller;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputControllerTest {

    InputController inputController = new InputController();

    @DisplayName("게임 재시도 질문에 'R'을 입력하면 입력 처리 메서드에서 'True'가 반환 된다 ")
    @Test
    void readAndParseGameCommandInput() {
        String CommandInput = "R";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(CommandInput.getBytes());
        System.setIn(in);

        assertThat(inputController.retryCommandInput()).isTrue();
    }

}