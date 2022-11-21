package bridge.controller;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Movement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class InputControllerTest {

    InputController inputController = new InputController();

    @DisplayName("다리 길이 입력란에 숫자를 입력하면 적정성 검토 후 정수 타입 다리 길이값이 반환된다.")
    @Test
    void getBridgeSizeInput() {
        String bridgeSizeInput = "3";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(bridgeSizeInput.getBytes());
        System.setIn(in);
        int bridgeSize = Integer.parseInt(bridgeSizeInput);

        assertThat(inputController.getBridgeSizeInput()).isEqualTo(bridgeSize);
    }

    @DisplayName("방향 선택 입력란에 방향을 입력하면 해당 방향에 맞는 Movement 객체가 반환된다.")
    @Test
    void getDirectionInput() {
        String movementInput = "U";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(movementInput.getBytes());
        System.setIn(in);
        Movement movement = Movement.UP;

        assertThat(inputController.getDirectionInput()).isEqualTo(movement);
    }

    @DisplayName("게임 재시도 질문에 'R'을 입력하면 입력 처리 메서드에서 'True'가 반환된다 ")
    @Test
    void retryCommandInput() {
        String commandInput = "R";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(commandInput.getBytes());
        System.setIn(in);

        assertThat(inputController.retryCommandInput()).isTrue();
    }
}