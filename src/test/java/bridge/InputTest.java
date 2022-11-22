package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    @DisplayName("정상 값을 입력하는 경우 정상 통과")
    @Test
    void 정상_다리_사이즈_입력() {
        String input = "10";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThat(Input.readBridgeSize()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("정상 이동 위치 U를 입력하는 경우 정상 통과")
    @Test
    void 정상_이동_위치_U_입력() {
        final String input = "U";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThat(Input.readNextMove()).isEqualTo(input);
    }

    @DisplayName("종료 커맨드 Q를 입력하는 경우 정상 통과")
    @Test
    void 정상_커맨드_Q_입력() {
        final String input = "Q";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThat(Input.readExitCommand()).isEqualTo(input);
    }
}